package com.libraryApp.services.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libraryApp.entities.Book;
import com.libraryApp.entities.impl.Author;
import com.libraryApp.entities.impl.LibraryBook;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.storage.MySQLDBUtil;

public class MySQLBookManagementService implements BookManagementService {

	private static MySQLBookManagementService instance;
	private AuthorManagementService authorManagementService;
	private List<Author> authors;

	{
		authorManagementService = MySQLAuthorManagementService.getInstance();
	}

	private MySQLBookManagementService() {
	}

	public static MySQLBookManagementService getInstance() {
		if (instance == null) {
			instance = new MySQLBookManagementService();
		}
		return instance;
	}

	@Override
	public String addBook(String title, int authorId, BigDecimal price, int totalQuantity) {

		String query = "INSERT INTO book (title, author_id, price, total_quantity) VALUES (?,?,?,?)";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psInsert = con.prepareStatement(query);) {
			psInsert.setString(1, title);
			psInsert.setInt(2, authorId);
			psInsert.setBigDecimal(3, price);
			psInsert.setInt(4, totalQuantity);
			psInsert.executeUpdate();
			return "";
		} catch (SQLException e) {
			return (e.getMessage());
		}

	}


	public Book getBookById(int bookId) {
		String query = "SELECT * FROM book WHERE id = ? ;";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			psSelect.setInt(1, bookId);
			ResultSet rs = psSelect.executeQuery();
			if (rs.next()) {
				return loadBook(rs);
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<Book> getBookByAuthor(int authorId) {
		List<Book> books = new ArrayList<Book>();
		authors = authorManagementService.getAuthors();
		String query = "SELECT * FROM book WHERE author_id = ? ;";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			psSelect.setInt(1, authorId);
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				books.add(loadBook(rs));
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Book> getBooks() {
		String query = "SELECT * FROM book;";
		try {
			return loadBooks(query);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Book> getAvailableBooks() {
		String query = "SELECT * FROM book WHERE available_quantity>0;";
		try {
			return loadBooks(query);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// TODO: Debug Unknown column 'available_quantity' in 'field list'
	@Override
	public List<Book> getBorrowedBooks(int userId) {
		String query = "SELECT * from book b join `transaction` t "
				+ "ON b.id = t.book_id " + "WHERE t.user_id = ? ;";
		List<Book> books = new ArrayList<Book>();
		authors = authorManagementService.getAuthors();

		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			psSelect.setInt(1, userId);
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				books.add(loadBook(rs));
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private List<Book> loadBooks(String query) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		authors = authorManagementService.getAuthors();
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				books.add(loadBook(rs));
			}
		}
		return books;
	}

	private Book loadBook(ResultSet rs) throws SQLException {
		Book book = new LibraryBook();
		book.setId(rs.getInt("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(authors.get(rs.getInt("author_id") - 1));
		book.setPrice(rs.getBigDecimal("price"));
		book.setTotalQuantity(rs.getInt("total_quantity"));
		book.setAvailableQuantity(rs.getInt("available_quantity"));
		return book;
	}

	@Override
	public String UpdateBook(Book book) {
		String query = "UPDATE book SET title = ?, price = ?, total_quantity = ?, available_quantity = ? WHERE id = ? ";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psUpdate = con.prepareStatement(query);) {
			psUpdate.setString(1, book.getTitle());
			psUpdate.setBigDecimal(2, book.getPrice());
			psUpdate.setInt(3, book.getTotalQuantity());
			psUpdate.setInt(4, book.getAvailableQuantity());
			psUpdate.setInt(5, book.getId());
			psUpdate.executeUpdate();
			return "";
		} catch (SQLException e) {
			return (e.getMessage());
		}
	}

	@Override
	public String RemoveBook(int bookId) {
		String query = "DELETE FROM book WHERE id = ? ";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psDelete = con.prepareStatement(query);) {
			psDelete.setInt(1, bookId);
			psDelete.executeUpdate();
			return "";
		} catch (SQLException e) {
			return (e.getMessage());
		}
	}

}

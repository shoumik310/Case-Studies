package com.libraryApp.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.libraryApp.entities.Book;
import com.libraryApp.entities.Transaction;
import com.libraryApp.entities.User;
import com.libraryApp.entities.impl.LibraryTransaction;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.TransactionManagementService;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.storage.MySQLDBUtil;

public class MySQLTransactionManagementService implements TransactionManagementService {

	private static MySQLTransactionManagementService instance;
	private final int DAILY_FINE_AMOUNT = 10;
	private UserManagementService userManagementService;
	private BookManagementService bookManagementService;
	
	{
		bookManagementService = MySQLBookManagementService.getInstance();
		userManagementService = MySQLUserManagementService.getInstance();
	}

	private MySQLTransactionManagementService() {
	}

	public static MySQLTransactionManagementService getInstance() {
		if (instance == null) {
			instance = new MySQLTransactionManagementService();
		}
		return instance;
	}

	@Override
	public String addTransaction(int userId, int bookId) {
		String insertQuery = "INSERT INTO transaction (user_id, book_id) VALUES (?,?)";
		String updateQuery = "UPDATE user SET borrowed = ? WHERE id = ?;";
		String updateQuery2 = "UPDATE book SET available_quantity = ? WHERE id = ?;";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psInsert = con.prepareStatement(insertQuery);
				PreparedStatement psUpdateU = con.prepareStatement(updateQuery);
				PreparedStatement psUpdateB = con.prepareStatement(updateQuery2);) {
			con.setAutoCommit(false);
			psInsert.setInt(1, userId);
			psInsert.setInt(2, bookId);
			psInsert.executeUpdate();
			
			User user = userManagementService.getUserById(userId);
			psUpdateU.setInt(1, user.getBorrowed()+1);
			psUpdateU.setInt(2, userId);
			psUpdateU.executeUpdate();
			
			Book book = bookManagementService.getBookById(bookId);
			psUpdateB.setInt(1, book.getAvailableQuantity()-1);
			psUpdateB.setInt(2, bookId);
			psUpdateB.executeUpdate();
			
			con.commit();
			
			return "";
		} catch (SQLException e) {

//			con.rollback();
			return (e.getMessage());
		}
	}

	@Override
	public int updateReturnDate(int bookId, int userId) {
		String updateQuery1 = "UPDATE transaction SET return_date = NOW() WHERE user_id = ? AND book_id = ? ";
		String updateQuery2 = "UPDATE user SET borrowed = ?, SET fine = ? WHERE id = ?;";
		String updateQuery3 = "UPDATE book SET available_quantity = ? WHERE id = ?;";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psUpdateT = con.prepareStatement(updateQuery1);
				PreparedStatement psUpdateU = con.prepareStatement(updateQuery2);
				PreparedStatement psUpdateB = con.prepareStatement(updateQuery3);) {
			
			con.setAutoCommit(false);
			
			psUpdateT.setInt(1, userId);
			psUpdateT.setInt(2, bookId);
			psUpdateT.executeUpdate();
			
			Transaction transaction = getTransaction(userId, bookId);
			System.out.println(transaction);
			System.out.println(transaction.getReturnDate());
			long timeInSeconds = transaction.getReturnDate().getTime()-transaction.getDueDate().getTime();
			int differenceInDays = (int)((timeInSeconds/ (1000 * 60 * 60 * 24))% 365);
			int fine = differenceInDays*DAILY_FINE_AMOUNT>=0?differenceInDays*DAILY_FINE_AMOUNT:0;
			
			User user = userManagementService.getUserById(userId);
			psUpdateU.setInt(1, user.getBorrowed()-1);
			psUpdateU.setInt(2, fine);
			psUpdateU.setInt(3, userId);
			psUpdateU.executeUpdate();
			
			Book book = bookManagementService.getBookById(bookId);
			psUpdateB.setInt(1, book.getAvailableQuantity()+1);
			psUpdateB.setInt(2, bookId);
			psUpdateB.executeUpdate();
			
			con.commit();
			
			return fine;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
//			con.rollback();
			return -1;
		}
	}

	private Transaction getTransaction(int userId, int bookId) {
		String query = "SELECT * FROM transaction WHERE user_id = ? AND book_id = ? AND return_date = null; ";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psUpdate = con.prepareStatement(query);) {
			psUpdate.setInt(1, userId);
			psUpdate.setInt(2, bookId);
			ResultSet rs = psUpdate.executeQuery();
			if (rs.next()) {
				return loadTransaction(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return new LibraryTransaction();
	}

	private Transaction loadTransaction(ResultSet rs) throws SQLException {
		Transaction transaction = new LibraryTransaction();
		transaction.setId(rs.getInt("id"));
		transaction.setUserId(rs.getInt("user_id"));
		transaction.setBookId(rs.getInt("book_id"));
		transaction.setDueDate(rs.getDate("due_date"));
		transaction.setIssueDate(rs.getDate("issue_date"));
		transaction.setReturnDate(rs.getDate("return_date"));
		return transaction;
	}

}

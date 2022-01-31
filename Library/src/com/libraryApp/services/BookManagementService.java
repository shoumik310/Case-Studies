package com.libraryApp.services;

import java.math.BigDecimal;
import java.util.List;

import com.libraryApp.entities.Book;

public interface BookManagementService {
	String addBook(String title, int authorId, BigDecimal price, int totalQuantity);
	
	String UpdateBook(Book book);

	String RemoveBook(int bookId);
	
	Book getBookById(int bookId);

	List<Book> getBookByAuthor(int authorId);

	List<Book> getBooks();
	
	List<Book> getAvailableBooks();
	
	List<Book> getBorrowedBooks(int userId);

}

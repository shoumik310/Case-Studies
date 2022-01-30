package com.libraryApp.services;

import java.util.List;

import com.libraryApp.entities.Book;

public interface BookManagementService {
	void addBook(String title, int authorId);
	
	void UpdateBook(Book book);

	void RemoveBook(int bookId);

	List<Book> getBookByAuthor(int authorId);

	List<Book> getBooks();
	
	List<Book> getAvailableBooks();
	
	List<Book> getBorrowedBooks(int userId);

}

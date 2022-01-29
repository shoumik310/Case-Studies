package com.libraryApp.services;

import java.util.List;

import com.libraryApp.entities.Book;

public interface BookManagementService {
	String addBook(Book book);

	List<Book> getBookByAuthor(int authorId);

	List<Book> getBooks();

	Book getBookById(int bookIdToBorrow);

}

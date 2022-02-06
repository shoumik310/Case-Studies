package com.libraryApp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryApp.entities.Book;
import com.libraryApp.repositories.BookRepository;

@Service
public class BookManagementService {

	@Autowired
	private BookRepository bookRepo;

	public Book addBook(Book book) {
		System.out.println(book);
		book.setAvailableQuantity(book.getTotalQuantity());
		System.out.println(book);
		return bookRepo.save(book);
	}
	
	public Book updateBook(Book book) {
		Book prevBook = getBookById(book.getId());
		System.out.println(book);
		int newAvailable = book.getTotalQuantity() - prevBook.getTotalQuantity() + prevBook.getAvailableQuantity();
		book.setAvailableQuantity(newAvailable);
		System.out.println(book);
		return bookRepo.save(book);
	}
	
	public void removeBook(int bookId) {
		bookRepo.deleteById(bookId);
	}

	public Book getBookById(int bookId) {
		return bookRepo.getById(bookId);
	}

	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	public List<Book> getAvailableBooks() {
		return bookRepo.findAll().stream().filter(book -> book.getAvailableQuantity() > 0).collect(Collectors.toList());
	}

	public List<Book> getBorrowedBooks(int readerId) {
		return bookRepo.findBorrowedBooksByReaderID(readerId);
	}
}

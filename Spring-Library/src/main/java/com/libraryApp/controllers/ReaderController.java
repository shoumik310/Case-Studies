package com.libraryApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryApp.entities.Book;
import com.libraryApp.entities.Reader;
import com.libraryApp.entities.Transaction;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.ReaderManagementService;
import com.libraryApp.services.TransactionManagementService;

@RestController
@RequestMapping("/reader")
public class ReaderController {

	Reader reader;
	@Autowired
	ReaderManagementService readerManagementService;
	@Autowired
	BookManagementService bookManagementService;
	@Autowired
	TransactionManagementService transactionManagementService;

	@GetMapping("/login/{email}/{password}")
	public String loginReader(@PathVariable("email") String email, @PathVariable("password") String password) {
		reader = readerManagementService.getReaderByEmail(email);
		if (reader != null && reader.getUserType().equals("reader") && reader.getPassword().equals(password)) {
			return "Logged In Succesfully" + System.lineSeparator() + reader.toString();
		} else {
			reader = null;
			return "Invalid email and password";
		}
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		if (reader == null) {
			return null;
		}
		return bookManagementService.getAvailableBooks();
	}

	@GetMapping("/details")
	public Reader getReaderDetails() {
		if (reader == null) {
			return null;
		}
		return reader;
	}

	@GetMapping("/signout")
	public String signOut() {
		reader = null;
		return "Signed Out";
	}

	static private class BookInput {
		public int bookId;

		@SuppressWarnings("unused")
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
	}

	@PostMapping("/getbook")
	public String borrowBook(@RequestBody BookInput bookInput) {
		if (reader == null) {
			return "No reader signed in";
		}
		String output = transactionManagementService
				.addTransaction(new Transaction(reader, bookManagementService.getBookById(bookInput.bookId)));
		if (output == null || output.isEmpty()) {
			reader = readerManagementService.getReaderById(reader.getId());
			return "Book Successfully Borrowed";
		} else {
			return output;
		}

	}

	@PostMapping("/returnbook")
	public int returnBook(@RequestBody BookInput bookInput) {
		if (reader == null) {
			return -1;
		}
		int output = transactionManagementService.returnBook(reader,
				bookManagementService.getBookById(bookInput.bookId));
		if (output != -1) {
			reader = readerManagementService.getReaderById(reader.getId());
		}
		return output;
	}

	@RequestMapping("/payfine")
	public String payFine() {
		if (reader == null) {
			return "No reader signed in";
		}
		readerManagementService.PayFine(reader.getId());
//		reader = readerManagementService.getReaderById(reader.getId());
		return "Fine Payed";
	}

}

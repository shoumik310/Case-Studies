package com.libraryApp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@GetMapping("/books/borrowed")
	public List<Book> getBorrowedBooks() {
		if (reader == null) {
			return null;
		}
		return bookManagementService.getBorrowedBooks(reader.getId());
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
		private List<Integer> bookId;

		@SuppressWarnings("unused")
		public void setBookId(List<Integer> bookId) {
			this.bookId = bookId;
		}

		public List<Integer> getBookIds() {
			return bookId;
		}

	}

	@PostMapping("/getbook")
	public String borrowBook(@RequestBody BookInput bookInput) {
		if (reader == null) {
			return "No reader signed in";
		}
		String returnString = "";
		for (int id : bookInput.getBookIds()) {
			String output = transactionManagementService
					.addTransaction(new Transaction(reader, bookManagementService.getBookById(id)));
			if (output == null || output.isEmpty()) {
				reader = readerManagementService.getReaderById(reader.getId());
				returnString += String.format("Book With Id: %d  Successfully Borrowed", id) + System.lineSeparator();
			} else {
				returnString += String.format("For Book With Id: %d -> ", id) + output + System.lineSeparator();
			}
		}
		return returnString;

	}

	@PostMapping("/returnbook")
	public Map<Integer, Integer> returnBook(@RequestBody BookInput bookInput) {
		if (reader == null) {
			return null;
		}
		Map<Integer, Integer> fines = new HashMap<Integer, Integer>();
		for (int id : bookInput.getBookIds()) {
			fines.put(id, transactionManagementService.returnBook(reader, bookManagementService.getBookById(id)));
		}
		reader = readerManagementService.getReaderById(reader.getId());
		return fines;
	}

	@RequestMapping("/payfine")
	public String payFine() {
		if (reader == null) {
			return "No reader signed in";
		}
		readerManagementService.PayFine(reader.getId());
		System.out.println(reader);
		reader = readerManagementService.getReaderById(reader.getId());
		System.out.println(reader);
		return "Fine Payed";
	}

}

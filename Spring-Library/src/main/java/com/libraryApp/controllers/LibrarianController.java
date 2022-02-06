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
import com.libraryApp.entities.Librarian;
import com.libraryApp.entities.Reader;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.LibrarianManagementService;
import com.libraryApp.services.ReaderManagementService;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	private Librarian librarian;
	@Autowired
	private ReaderManagementService readerManagementService;
	@Autowired
	private LibrarianManagementService librarianManagementService;
	@Autowired
	private BookManagementService bookManagementService;

	@GetMapping("/login/{email}/{password}")
	public String loginLibrarian(@PathVariable("email") String email, @PathVariable("password") String password) {
		librarian = librarianManagementService.getLibrarianByEmail(email);
		if (librarian != null && librarian.getUserType().equals("librarian")
				&& librarian.getPassword().equals(password)) {
			return "Logged In Succesfully"+System.lineSeparator()+librarian.toString();
		} else {
			librarian = null;
			return "Invalid email and/or password";
		}
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		if (librarian == null) {
			return null;
		}
		return bookManagementService.getBooks();
	}

	@GetMapping("/users")
	public List<Reader> getUsers() {
		if (librarian == null) {
			return null;
		}
		return readerManagementService.getReaders();
	}

	@GetMapping("/signout")
	public String signOut() {
		librarian = null;
		return "Signed Out";
	}
	
	@PostMapping("books/add")
	public Book addBook(@RequestBody Book book) {
		if (librarian == null) {
			return null;
		}
		bookManagementService.addOrUpdateBook(book);
		return bookManagementService.getBookById(book.getId());
	}
	
	@PostMapping("books/update")
	public Book updateBook(@RequestBody Book book) {
		if (librarian == null) {
			return null;
		}
		bookManagementService.addOrUpdateBook(book);
		return bookManagementService.getBookById(book.getId());
	}
	
	@RequestMapping("books/delete/{id}")
	public String deleteBook(@PathVariable("id") int bookId) {
		if (librarian == null) {
			return null;
		}
		bookManagementService.removeBook(bookId);
		return "Deleted";
	}

}

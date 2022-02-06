package com.libraryApp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@SuppressWarnings("unused")
	private static class LoginInput {
		String email;
		String password;

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

	@PostMapping("/login")
	public String loginLibrarian(@RequestBody LoginInput loginInput) {
		librarian = librarianManagementService.getLibrarianByEmail(loginInput.email);
		if (librarian != null && librarian.getUserType().equals("librarian")
				&& librarian.getPassword().equals(loginInput.password)) {
			return "Logged In Successfully" + System.lineSeparator() + librarian.toString();
		} else {
			librarian = null;
			return "Invalid email and/or password";
		}
	}

//	@GetMapping("/login/{email}/{password}")
//	public String loginLibrarian(@PathVariable("email") String email, @PathVariable("password") String password) {
//		librarian = librarianManagementService.getLibrarianByEmail(email);
//		if (librarian != null && librarian.getUserType().equals("librarian")
//				&& librarian.getPassword().equals(password)) {
//			return "Logged In Successfully" + System.lineSeparator() + librarian.toString();
//		} else {
//			librarian = null;
//			return "Invalid email and/or password";
//		}
//	}

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
		return readerManagementService.getReaders().stream().peek(reader -> reader.setPassword("******")).collect(Collectors.toList());
	}

	@GetMapping("/logout")
	public String logOut() {
		librarian = null;
		return "Logged Out";
	}

	@PostMapping("books/add")
	public Book addBook(@RequestBody Book book) {
		if (librarian == null) {
			return null;
		}
		return bookManagementService.addBook(book);
	}

	@PostMapping("books/update")
	public Book updateBook(@RequestBody Book book) {
		if (librarian == null) {
			return null;
		}

		return bookManagementService.updateBook(book);
	}

	@DeleteMapping("books/delete/{id}")
	public String deleteBook(@PathVariable("id") int bookId) {
		if (librarian == null) {
			return "No Librarian Logged In";
		}
		bookManagementService.removeBook(bookId);
		return "Deleted";
	}

}

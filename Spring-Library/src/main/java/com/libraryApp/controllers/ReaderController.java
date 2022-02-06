package com.libraryApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryApp.entities.Book;
import com.libraryApp.entities.Reader;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.ReaderManagementService;

@RestController
@RequestMapping("/reader")
public class ReaderController {

	Reader reader;
	@Autowired
	ReaderManagementService readerManagementService;
	@Autowired
	BookManagementService bookManagementService;


	@GetMapping("/login/{email}/{password}")
	public String loginReader(@PathVariable("email") String email,@PathVariable("password") String password) {
		reader = readerManagementService.getReaderByEmail(email);
		if(reader!=null && reader.getUserType().equals("librarian") && reader.getPassword().equals(password)) {
			return "Logged In Succesfully"+System.lineSeparator()+reader.toString();
		}else {
			reader=null;
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

	
}

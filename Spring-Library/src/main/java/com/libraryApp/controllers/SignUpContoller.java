package com.libraryApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryApp.entities.Librarian;
import com.libraryApp.entities.Reader;
import com.libraryApp.services.LibrarianManagementService;
import com.libraryApp.services.ReaderManagementService;

@RestController
public class SignUpContoller {

	@Autowired
	ReaderManagementService readerManagementService;
	@Autowired
	LibrarianManagementService librarianManagementService;

	@PostMapping("/addreader")
	public String addReader(@RequestBody Reader reader) {
		if (checkEmail(reader.getEmail())) {
			readerManagementService.addReader(reader);
			return "Success";
		}
		return "Invalid Email";
	}

	@PostMapping("/addlibrarian")
	public String addLibrarian(@RequestBody Librarian librarian) {
		if (checkEmail(librarian.getEmail())) {
			librarianManagementService.addLibrarian(librarian);
			return "Success";
		}
		return "Invalid Email";
	}

	private Boolean checkEmail(String emailInput) {
		return emailInput.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
	}

}

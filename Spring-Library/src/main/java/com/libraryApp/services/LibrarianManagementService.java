package com.libraryApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryApp.entities.Librarian;
import com.libraryApp.repositories.LibrarianRepository;

@Service
public class LibrarianManagementService {

	@Autowired
	LibrarianRepository librarianRepo;

	public void addLibrarian(Librarian librarian) {
		librarianRepo.save(librarian);
	}

	public Librarian getLibrarianByEmail(String librarianEmail) {
		return librarianRepo.findByEmail(librarianEmail);
	}

	public Librarian getLibrarianById(int librarianId) {
		return librarianRepo.getById(librarianId);
	}

	public List<Librarian> getLibrarians() {
		return librarianRepo.findAll();
	}
}

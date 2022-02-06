package com.libraryApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryApp.entities.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

	Librarian findByEmail(String email);

}

package com.libraryApp.services;

import java.sql.SQLException;
import java.util.List;

import com.libraryApp.entities.impl.Author;

public interface AuthorManagementService {
	
	List<Author> getAuthors() throws SQLException;

	void AddAuthor(String firstName, String lastName);

	void UpdateAuthor(Author author);

	void RemoveAuthor();
}

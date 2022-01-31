package com.libraryApp.services;

import java.util.List;

import com.libraryApp.entities.impl.Author;

public interface AuthorManagementService {
	
	List<Author> getAuthors();

	String AddAuthor(String firstName, String lastName);

	String UpdateAuthor(Author author);

	String RemoveAuthor(int Author);
}

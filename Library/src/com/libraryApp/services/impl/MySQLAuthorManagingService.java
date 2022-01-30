package com.libraryApp.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libraryApp.entities.impl.Author;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.storage.MySQLDBUtil;

public class MySQLAuthorManagingService implements AuthorManagementService {

	private static MySQLAuthorManagingService instance;
	
	private  MySQLAuthorManagingService() {
	}
	
	public	static MySQLAuthorManagingService getInstance() {
		if(instance==null) {
			instance = new MySQLAuthorManagingService();
		}
		return instance;
	}
	
	@Override
	public List<Author> getAuthors() throws SQLException {
		List<Author> authors = new ArrayList<>();
		String query = "SELECT * FROM author";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				authors.add(loadAuthor(rs));
			}
		}
		return authors;
	}

	@Override
	public void AddAuthor(String firstName, String lastName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateAuthor(Author author) {
		// TODO Auto-generated method stub

	}

	@Override
	public void RemoveAuthor() {
		// TODO Auto-generated method stub

	}

	private Author loadAuthor(ResultSet rs) throws SQLException {
		return new Author(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
	}
}

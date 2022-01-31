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

public class MySQLAuthorManagementService implements AuthorManagementService {

	private static MySQLAuthorManagementService instance;
	
	private  MySQLAuthorManagementService() {
	}
	
	public	static MySQLAuthorManagementService getInstance() {
		if(instance==null) {
			instance = new MySQLAuthorManagementService();
		}
		return instance;
	}
	
	@Override
	public List<Author> getAuthors(){
		List<Author> authors = new ArrayList<>();
		String query = "SELECT * FROM author";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				authors.add(loadAuthor(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}

	@Override
	public String AddAuthor(String firstName, String lastName) {
		String query = "INSERT INTO author (first_name, last_name) VALUES (?,?)";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psInsert = con.prepareStatement(query);) {
			psInsert.setString(1, firstName);
			psInsert.setString(2, lastName);
			psInsert.executeUpdate();
			return "";
		} catch (SQLException e) {
			return(e.getMessage());
		}

	}

	@Override
	public String UpdateAuthor(Author author) {
		String query = "UPDATE author SET first_name = ?, last_name = ? WHERE id = ? ";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psUpdate = con.prepareStatement(query);) {
			psUpdate.setString(1, author.getFirstName());
			psUpdate.setString(2, author.getLastName());
			psUpdate.setInt(3, author.getId());
			psUpdate.executeUpdate();
			return "";
		} catch (SQLException e) {
			return(e.getMessage());
		}

	}

	@Override
	public String RemoveAuthor(int authorId) {
		String query = "DELETE FROM author WHERE id = ? ";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psDelete = con.prepareStatement(query);) {
			psDelete.setInt(1, authorId);
			psDelete.executeUpdate();
			return "";
		} catch (SQLException e) {
			return(e.getMessage());
		}
	}

	private Author loadAuthor(ResultSet rs) throws SQLException {
		return new Author(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
	}
}

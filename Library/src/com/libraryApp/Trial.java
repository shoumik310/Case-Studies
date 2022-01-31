package com.libraryApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libraryApp.entities.Book;
import com.libraryApp.entities.impl.Author;
import com.libraryApp.entities.impl.LibraryBook;
import com.libraryApp.services.impl.MySQLAuthorManagementService;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.services.impl.MembershipLoadingService;
import com.libraryApp.services.impl.MySQLBookManagementService;
import com.libraryApp.services.impl.MySQLUserManagementService;
import com.libraryApp.storage.MySQLDBUtil;

public class Trial {
	public static void main(String[] args) throws SQLException {
//		User user = new LibraryReader(1,"a","a","a","a", 0, 0, "gold", 0);
//		User user = new LibraryLibrarian(1,"a","a","a","a");
//		System.out.println(user.getBorrowLimit());
//		System.out.println("User id: \t Name: \t Email=");

//		try (Connection connection = MySQLDBUtil.getLibrarianConnection()) {
//			if (connection != null) {
//				System.out.println("You made it, take control your database now!");
//			} else {
//				System.out.println("Failed to make connection!");
//			}
//
//		} catch (SQLException e) {
//			System.out.println("Connection Failed! Check output console");
//			e.printStackTrace();
//			return;
//		}

		AuthorManagementService authorManagementService = MySQLAuthorManagementService.getInstance();
		UserManagementService userManagementService = MySQLUserManagementService.getInstance();
		BookManagementService bookManagementService = MySQLBookManagementService.getInstance();

//		List<Book> books = 
		bookManagementService.getBorrowedBooks(2).forEach(book -> System.out.println(book));
//		authorManagementService.getAuthors().forEach(System.out::println);

		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement ps = con.prepareStatement("Select * from book");) {

		}

	}
}

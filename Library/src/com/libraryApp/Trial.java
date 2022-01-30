package com.libraryApp;

import com.libraryApp.services.impl.MembershipLoadingService;

//import java.sql.Connection;
//import java.sql.SQLException;
//
//import com.libraryApp.storage.MySQLDBUtil;

//import com.libraryApp.entities.User;
//import com.libraryApp.entities.impl.LibraryLibrarian;
//import com.libraryApp.entities.impl.LibraryReader;

public class Trial {
	public static void main(String[] args) {
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
		
		MembershipLoadingService.getMemberships().forEach(System.out::println);
	}
}

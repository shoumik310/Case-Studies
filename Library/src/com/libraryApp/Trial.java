package com.libraryApp;

import com.libraryApp.entities.User;
import com.libraryApp.entities.impl.LibraryLibrarian;
//import com.libraryApp.entities.impl.LibraryReader;

public class Trial {
	public static void main(String[] args) {
//		User user = new LibraryReader(1,"a","a","a","a", 0, 0, "gold", 0);
		User user = new LibraryLibrarian(1,"a","a","a","a");
		System.out.println(user.getBorrowLimit());
	}
}

package com.libraryApp.menu.impl.librarianOptions;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.services.impl.MySQLAuthorManagementService;

public class AddAuthorMenu implements Menu {

	AuthorManagementService authorManagementService;
	
	{
		authorManagementService = MySQLAuthorManagementService.getInstance();
	}
	
	@Override
	public void init() {
		printMenuHeader();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter author's First Name: ");
		String firstName = sc.next();
		System.out.print("Please enter author's Last Name: ");
		String lastName = sc.next();
		String output = authorManagementService.AddAuthor(firstName, lastName);
		if (output.isEmpty() || output == null) {
			System.out.println("Added Successfully");
		} else {
			System.out.println(output);
		}
		new ViewAuthorsMenu().init();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Add Author -*-*-*-");	
	}

}

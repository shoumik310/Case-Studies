package com.libraryApp.menu.impl.librarianOptions;

import java.util.Scanner;

import com.libraryApp.entities.impl.Author;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.services.impl.MySQLAuthorManagementService;

public class UpdateAuthorMenu implements Menu {
	
	AuthorManagementService authorManagementService;
	
	{
		authorManagementService = MySQLAuthorManagementService.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of author to edit: ");
		int authorId;
		loop: while (true) {
			try {
				String userInput = sc.next();
				authorId = Integer.parseInt(userInput);
				break loop;
			} catch (NumberFormatException e) {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
			}
		}
		Author author = authorManagementService.getAuthors().get(authorId-1);
		System.out.println("You have selected : " + author);
		System.out.print("Please enter author's First Name, or na to keep same: ");
		String firstName = sc.next();
		if(!firstName.equals("na")){
			author.setFirstName(firstName);
		}
		System.out.print("Please enter author's Last Name, or na to keep same: ");
		String lastName = sc.next();
		if(!lastName.equals("na")){
			author.setLastName(lastName);
		}
		String output = authorManagementService.UpdateAuthor(author);
		if (output.isEmpty() || output == null) {
			System.out.println("Updated Successfully");
		} else {
			System.out.println(output);
		}
		new ViewAuthorsMenu().init();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Update Author -*-*-*-");
	}

}

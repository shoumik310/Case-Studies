package com.libraryApp.menu.impl.librarianOptions;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.services.impl.MySQLAuthorManagementService;

public class RemoveAuthorMenu implements Menu {

	private AuthorManagementService authorManagementService;

	{
		authorManagementService = MySQLAuthorManagementService.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		int authorID = MenuInput.getIntInput(sc, "Please Enter ID of author to be removed: ");

		System.out.println("You have chosen: " + authorManagementService.getAuthors().get(authorID - 1));
		loop: while (true) {
			System.out.print("Please confirm with Y or return to previous menu with N: ");
			String userConfirmation = sc.next();
			if (userConfirmation.equalsIgnoreCase("y")) {
				String output = authorManagementService.RemoveAuthor(authorID);
				if (output.isEmpty() || output == null) {
					System.out.println("Deleted Successfully");
				} else {
					System.out.println(output);
				}
				break loop;
			} else if (userConfirmation.equalsIgnoreCase("n")) {
				break loop;
			} else {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
			}
		}

		new ViewAuthorsMenu().init();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Remove Author -*-*-*- ");
	}

}

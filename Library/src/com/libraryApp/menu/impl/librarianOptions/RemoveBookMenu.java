package com.libraryApp.menu.impl.librarianOptions;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.impl.MySQLBookManagementService;

public class RemoveBookMenu implements Menu {

	BookManagementService bookManagementService;

	{
		bookManagementService = MySQLBookManagementService.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		int bookId = MenuInput.getIntInput(sc, "Please Enter ID of book to be removed: ");
		System.out.println("You have chosen: " + bookManagementService.getBooks().get(bookId-1));
		loop: while (true) {
			System.out.print("Please confirm with Y or return to previous menu with N: ");
			String userConfirmation = sc.next();
			if (userConfirmation.equalsIgnoreCase("y")) {
				String output = bookManagementService.RemoveBook(bookId);
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

		new ViewBooksMenu().init();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Remove Book -*-*-*- ");

	}

}

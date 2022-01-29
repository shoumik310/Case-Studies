package com.libraryApp.menu.impl.librarianOptions;


import java.util.List;
import java.util.Scanner;

import com.libraryApp.entities.Book;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.menu.impl.MainMenu;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.session.SessionContext;

public class ViewBooksMenu implements Menu {

	private static final String OPTIONS = "1. Add Book" + System.lineSeparator() + "2. Edit Book"
			+ System.lineSeparator() + "3. Delete Book";

	private SessionContext context;
	private BookManagementService bookManagementService;
	
	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		Menu nextMenu;
		while (true) {
			printMenuHeader();
			printAllBooks();
			String userInput = getUserInput();
			if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				nextMenu = context.getDefaultMenu();
				break;
			} else {
				int commandNumber;
				try {
					commandNumber = Integer.parseInt(userInput);
				} catch (NumberFormatException e) {
					System.out.println(MenuInput.INVALID_INPUT_TEXT);
					continue;
				}
				switch (commandNumber) {
				case 1:
					nextMenu = new AddBookMenu();
					break;
				case 2:
					nextMenu = new UpdateBookMenu();
					break;
				case 3:
					nextMenu = new RemoveBookMenu();
					break;
				default:
					System.out.println(MenuInput.INVALID_INPUT_TEXT);
					continue;
				}
			}
		}
		nextMenu.init();
	}

	private String getUserInput() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println(OPTIONS);
			System.out.printf(("Enter the number of operation in console, or '%s' to return to previous menu."
					+ System.lineSeparator()), MainMenu.MENU_COMMAND);
			String userInput = sc.next();
			return userInput;
		}
	}

	private void printAllBooks() {
		List<Book> books = bookManagementService.getBooks();
		books.forEach(System.out::println);
	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Books -*-*-*-");
	}

}

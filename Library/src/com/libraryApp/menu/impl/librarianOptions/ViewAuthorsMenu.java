package com.libraryApp.menu.impl.librarianOptions;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.libraryApp.entities.impl.Author;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.menu.impl.MainMenu;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.services.impl.MySQLAuthorManagingService;
import com.libraryApp.session.SessionContext;

public class ViewAuthorsMenu implements Menu {

	private static final String OPTIONS = "1. Add Author" + System.lineSeparator() + "2. Edit Author"
			+ System.lineSeparator() + "3. Delete Author";

	private SessionContext context;
	private AuthorManagementService authorManagementService;

	{
		authorManagementService = MySQLAuthorManagingService.getInstance();
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		Menu nextMenu;
		while (true) {
			printMenuHeader();
			printAllAuthors();
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
					nextMenu = new AddAuthorMenu();
					break;
				case 2:
					nextMenu = new UpdateAuthorMenu();
					break;
				case 3:
					nextMenu = new RemoveAuthorMenu();
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

	private void printAllAuthors() {
		List<Author> authors = null;
		try {
			authors = authorManagementService.getAuthors();
			authors.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Authors -*-*-*-");
	}

}

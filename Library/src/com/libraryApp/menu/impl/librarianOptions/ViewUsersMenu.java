package com.libraryApp.menu.impl.librarianOptions;

import java.util.List;
import java.util.Scanner;

import com.libraryApp.entities.User;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.impl.MainMenu;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.session.SessionContext;

public class ViewUsersMenu implements Menu {

	private SessionContext context;
	private UserManagementService userManagementService;
	
	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		while (true) {
			printMenuHeader();
			printAllUsers();
			String userInput = getUserInput();
			if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				break;
			} 
		}
		context.getDefaultMenu().init();
	}

	private String getUserInput() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.printf(("Enter '%s' to return to previous menu."
					+ System.lineSeparator()), MainMenu.MENU_COMMAND);
			String userInput = sc.next();
			return userInput;
		}
	}

	private void printAllUsers() {
		List<User> readers = userManagementService.getUsers("reader");
		List<User> librarians = userManagementService.getUsers("librarian");
		System.out.println(System.lineSeparator()+"-*-*-*- Readers -*-*-*-");
		readers.forEach(System.out::println);
		System.out.println(System.lineSeparator()+"-*-*-*- Librarians -*-*-*-");
		librarians.forEach(System.out::println);
	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Users -*-*-*-");
	}
}

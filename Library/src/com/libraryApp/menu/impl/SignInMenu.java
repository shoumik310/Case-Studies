package com.libraryApp.menu.impl;

import java.util.Scanner;

import com.libraryApp.entities.User;
import com.libraryApp.entities.impl.LibraryLibrarian;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.services.impl.MySQLUserManagementService;
import com.libraryApp.session.SessionContext;

public class SignInMenu implements Menu {

	private SessionContext context;
	private UserManagementService userManagementService;

	{
		userManagementService = MySQLUserManagementService.getInstance();
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String email;
		while(true) {
		System.out.print("Please enter your Email: ");
		email = sc.next();
		if(checkEmail(email)) {
			break;
		}
		System.out.println(MenuInput.INVALID_INPUT_TEXT);
		}
		System.out.print("Please enter your Password: ");
		String password = sc.next();

		User user = userManagementService.getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			System.out.printf("Glad to see you back %s %s", user.getFirstName(),
					user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
			if(user instanceof LibraryLibrarian) {
				context.setDefaultMenu(new LibrarianMenu());
			}else {
				context.setDefaultMenu(new ReaderMenu());
			}
		} else {
			System.out.println("Unfortunately, such login and password doesn’t exist");
		}

		context.getDefaultMenu().init();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator() + "-*-*-*- Sign In -*-*-*-");

	}
	
	private Boolean checkEmail(String emailInput) {
		return emailInput.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
	}


}

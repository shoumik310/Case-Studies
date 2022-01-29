package com.libraryApp.menu.impl;

import java.util.Scanner;

import com.libraryApp.Main;
import com.libraryApp.menu.Menu;
import com.libraryApp.session.SessionContext;

public class MainMenu implements Menu {

	private static final String MAIN_MENU_TEXT = System.lineSeparator()+"Welcome to the XYZ Library" + System.lineSeparator()
			+ "Please enter number in console to proceed:" + System.lineSeparator() + "1. Sign In"
			+ System.lineSeparator() + "2. Sign Up";

	private SessionContext context;

	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {

		if (context.getDefaultMenu() == null) {
			context.setDefaultMenu(this);
		}

		Menu nextMenu = null;
		Scanner sc = new Scanner(System.in);
		mainLoop: while (true) {
			printMenuHeader();

			System.out.print("User Input: ");
			String userInput = sc.next();

			if (userInput.equalsIgnoreCase(Main.EXIT_TEXT)) {
				sc.close();
				System.exit(0);
			} else {
				int commandNumber;
				try {
					commandNumber = Integer.parseInt(userInput);
				} catch (NumberFormatException e) {
					System.out.println("That is an invalid input! Please try again.");
					continue;
				}
				switch (commandNumber) {
				case 1:
					nextMenu = new SignInMenu();
					break mainLoop;
				case 2:
					nextMenu = new SignUpMenu();
					break mainLoop;
				default:
					System.out.println("That is an invalid input! Please try again.");
					continue;
				}
			}
		}
		nextMenu.init();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(MAIN_MENU_TEXT);
	}

}

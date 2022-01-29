package com.libraryApp.menu.impl;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.session.SessionContext;

public class MainMenu implements Menu {
	
	public static final String MENU_COMMAND = "menu";

	private static final String MAIN_MENU_TEXT = System.lineSeparator() + "Welcome to the XYZ Library"
			+ System.lineSeparator() + "Please enter number in console to proceed:" + System.lineSeparator()
			+ "1. Sign In" + System.lineSeparator() + "2. Sign Up";

	private SessionContext context;

	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {

		if (context.getMainMenu() == null) {
			context.setMainMenu(this);
		}

		if (context.getDefaultMenu() == null) {
			context.setDefaultMenu(this);
		}

		Menu nextMenu = null;
		Scanner sc = new Scanner(System.in);
		mainLoop: while (true) {
			printMenuHeader();

			int commandNumber = MenuInput.getMenuInput(sc);
			switch (commandNumber) {
			case 1:
				nextMenu = new SignInMenu();
				break mainLoop;
			case 2:
				nextMenu = new SignUpMenu();
				break mainLoop;
			default:
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
				continue;
			}

		}
		nextMenu.init();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(MAIN_MENU_TEXT);
	}

}

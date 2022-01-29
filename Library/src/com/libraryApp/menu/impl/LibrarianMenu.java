package com.libraryApp.menu.impl;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.menu.impl.librarianOptions.ViewAuthorsMenu;
import com.libraryApp.menu.impl.librarianOptions.ViewBooksMenu;
import com.libraryApp.menu.impl.librarianOptions.ViewUsersMenu;

public class LibrarianMenu implements Menu {

	private static final String LIBRARIAN_MENU_TEXT = System.lineSeparator()
			+ "Please enter number in console to proceed:" + System.lineSeparator() + "1. View All Books"
			+ System.lineSeparator() + "2. View All Authors" + System.lineSeparator() + "3. View Users"
			+ System.lineSeparator() + "4. Sign Out";

	@Override
	public void init() {
		Menu nextMenu = null;
		Scanner sc = new Scanner(System.in);
		loop: while (true) {
			printMenuHeader();
			int commandNumber = MenuInput.getMenuInput(sc);
			switch (commandNumber) {
			case 1:
				nextMenu = new ViewBooksMenu();
				break loop;
			case 2:
				nextMenu = new ViewAuthorsMenu();
				break loop;
			case 3:
				nextMenu = new ViewUsersMenu();
				break loop;
			case 4:
				nextMenu = new SignOutMenu();
				break loop;
			default:
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
				continue;
			}
		}

		nextMenu.init();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(LIBRARIAN_MENU_TEXT);
	}

}

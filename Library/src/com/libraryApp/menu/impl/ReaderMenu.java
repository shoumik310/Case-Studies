package com.libraryApp.menu.impl;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.menu.impl.readerOptions.BookSelectionMenu;
import com.libraryApp.menu.impl.readerOptions.BorrowedBooksMenu;
import com.libraryApp.menu.impl.readerOptions.PayFineMenu;
import com.libraryApp.session.SessionContext;

public class ReaderMenu implements Menu {

	private SessionContext context;

	{
		context = SessionContext.getInstance();
		getUserInfo();
	}

	private static String userInfo;
	private static final String READER_MENU_TEXT = System.lineSeparator() + "Please enter number in console to proceed:"
			+ System.lineSeparator() + "1. View Available Books" + System.lineSeparator()
			+ "2. View Books Current Borrowed By You" + System.lineSeparator() + "3. Pay Pending Fine"
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
				nextMenu = new BookSelectionMenu();
				break loop;
			case 2:
				nextMenu = new BorrowedBooksMenu();
				break loop;
			case 3:
				nextMenu = new PayFineMenu();
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

	public void getUserInfo() {
		userInfo = System.lineSeparator() + "Membership Type: " + context.getLoggedInUser().getMembership().getName()
				+ System.lineSeparator() + "Number of Books Borrowed: " + context.getLoggedInUser().getNumberBorrowed()
				+ System.lineSeparator() + "Book Limit: " + context.getLoggedInUser().getBorrowLimit()
				+ System.lineSeparator() + "Fine Due: " + context.getLoggedInUser().getFine();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(userInfo);
		System.out.println(READER_MENU_TEXT);
	}

}

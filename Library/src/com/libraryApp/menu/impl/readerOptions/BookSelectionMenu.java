package com.libraryApp.menu.impl.readerOptions;

import java.util.List;
import java.util.Scanner;

import com.libraryApp.entities.Book;
import com.libraryApp.entities.Transaction;
import com.libraryApp.entities.impl.LibraryTransaction;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.menu.impl.MainMenu;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.TransactionManagementService;
import com.libraryApp.session.SessionContext;

public class BookSelectionMenu implements Menu {

	private SessionContext context;
	private BookManagementService bookManagementService;
	private TransactionManagementService transactionManagementService;

	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		while (true) {
			printMenuHeader();
			printAllBooks();
			String userInput = getUserInput();
			if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				break;
			} else if (borrowBook(userInput)) {
				break;
			}
		}
		context.getDefaultMenu().init();

	}

	private Boolean borrowBook(String userInput) {
		int bookId;
		try {
			bookId = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.out.println(MenuInput.INVALID_INPUT_TEXT);
			return false;
		}
		String Error = createTransaction(bookId);
		if (Error.isEmpty() || Error == null) {
			System.out.println("Successfully Borrowed Book");
			return true;
		} else {
			System.out.println(Error);
			return false;
		}
	}

	private String createTransaction(int bookId) {
		if (context.getLoggedInUser().getFine() != 0) {
			return "Please pay all Pending Fines before borrowing another book";
		} else if (context.getLoggedInUser().getBorrowLimit() - context.getLoggedInUser().getNumberBorrowed() <= 0) {
			return "You Have Exceeded your Limit! Please Return a book before borrowing another.";
		}

		List<Book> books = bookManagementService.getAvailableBooks();
		if (books.stream().noneMatch(book -> book.getId() == bookId)) {
			return "The requested book id Does Not Exist";
		} else {
			Transaction transaction = new LibraryTransaction(context.getLoggedInUser().getId(), bookId);
			transactionManagementService.addTransaction(transaction);
			return "";
		}

	}

	private String getUserInput() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.printf(("Enter the book id in console to borrow, or '%s' to return to previous menu."
					+ System.lineSeparator()), MainMenu.MENU_COMMAND);
			String userInput = sc.next();
			return userInput;
		}
	}

	private void printAllBooks() {
		List<Book> books = bookManagementService.getAvailableBooks();
		books.stream().map(book -> book.toLimitedString()).forEach(System.out::println);
	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Books -*-*-*-");
	}
}

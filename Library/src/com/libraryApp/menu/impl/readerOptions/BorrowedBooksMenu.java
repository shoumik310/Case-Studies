package com.libraryApp.menu.impl.readerOptions;

import java.util.List;
import java.util.Scanner;

import com.libraryApp.entities.Book;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.menu.impl.MainMenu;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.TransactionManagementService;
import com.libraryApp.services.impl.MySQLBookManagementService;
import com.libraryApp.services.impl.MySQLTransactionManagementService;
import com.libraryApp.session.SessionContext;

public class BorrowedBooksMenu implements Menu {

	private SessionContext context;
	private BookManagementService bookManagementService;
	private TransactionManagementService transactionManagementService;

	{
		transactionManagementService = MySQLTransactionManagementService.getInstance();
		bookManagementService = MySQLBookManagementService.getInstance();
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
			} else if (returnBook(userInput)) {
				break;
			}
		}
		context.getDefaultMenu().init();

	}

	private Boolean returnBook(String userInput) {
		int bookId;
		try {
			bookId = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.out.println(MenuInput.INVALID_INPUT_TEXT);
			return false;
		}
		String result = updateReturnDate(bookId);
		if (result.charAt(0) == 'S') {
			System.out.printf(
					"Successfully Returned Book, Your Fine is %d" + System.lineSeparator() + "Your Total Fine is  %d"
							+ System.lineSeparator(),
					Integer.parseInt(result.substring(2)), context.getLoggedInUser().getFine());
			return true;
		} else {
			System.out.println(result);
			return false;
		}
	}

	private String updateReturnDate(int bookId) {
		List<Book> books = bookManagementService.getBorrowedBooks(context.getLoggedInUser().getId());
		if (books.stream().noneMatch(book -> book.getId() == bookId)) {
			return "You Have not Borrowed This book";
		} else {
			int fineAmount = transactionManagementService.updateReturnDate(bookId);
			return "S " + fineAmount;
		}

	}

	private String getUserInput() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.printf(("Enter the book id in console to return, or '%s' to return to previous menu."
					+ System.lineSeparator()), MainMenu.MENU_COMMAND);
			String userInput = sc.next();
			return userInput;
		}
	}

	private void printAllBooks() {
		List<Book> books = bookManagementService.getBorrowedBooks(context.getLoggedInUser().getId());
		books.stream().map(book -> book.toLimitedString()).forEach(System.out::println);
	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Borrowed Books -*-*-*-");
	}
}

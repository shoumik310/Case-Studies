package com.libraryApp.menu.impl.librarianOptions;

import java.math.BigDecimal;
import java.util.Scanner;

import com.libraryApp.entities.Book;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.impl.MySQLBookManagementService;

public class UpdateBookMenu implements Menu {

	BookManagementService bookManagementService;

	{
		bookManagementService = MySQLBookManagementService.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id of book to edit: ");
		
		int bookId;
		loop: while (true) {
			try {
				String userInput = sc.next();
				bookId = Integer.parseInt(userInput);
				break loop;
			} catch (NumberFormatException e) {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
			}
		}
		Book book = bookManagementService.getBooks().get(bookId - 1);
		System.out.println("You have selected : " + book);
		System.out.print("Please enter book title, or na to keep same: ");
		String title = sc.next();
		if (!title.equals("na")) {
			book.setTitle(title);
		}
	
		System.out.println("Please enter book price, or 0 to keep same: ");
		BigDecimal price;
		loop: while (true) {
			try {
				String userInput = sc.next();
				price = new BigDecimal(Double.parseDouble(userInput));
				break loop;
			} catch (NumberFormatException e) {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
				continue;
			}
		}
		if (price != new BigDecimal(0)) {
			book.setPrice(price);
		}
		System.out.println("Please enter quantity, or 0 to keep same:  ");

		int totalQuantity;
		loop: while (true) {
			try {
				String userInput = sc.next();
				totalQuantity = Integer.parseInt(userInput);
				break loop;
			} catch (NumberFormatException e) {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
				continue;
			}
		}
		if (totalQuantity != 0) {
			book.setTotalQuantity(totalQuantity);
		}
		String output = bookManagementService.UpdateBook(book);
		if (output.isEmpty() || output == null) {
			System.out.println("Added Successfully");
		} else {
			System.out.println(output);
		}
		new ViewBooksMenu().init();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Update Book -*-*-*-");
	}

}

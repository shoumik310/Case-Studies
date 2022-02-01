package com.libraryApp.menu.impl.librarianOptions;

import java.math.BigDecimal;
import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.AuthorManagementService;
import com.libraryApp.services.BookManagementService;
import com.libraryApp.services.impl.MySQLAuthorManagementService;
import com.libraryApp.services.impl.MySQLBookManagementService;

public class AddBookMenu implements Menu {

	private BookManagementService bookManagementService;
	private AuthorManagementService authorManagementService;

	{
		bookManagementService = MySQLBookManagementService.getInstance();
		authorManagementService = MySQLAuthorManagementService.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter book title: ");
		String title = sc.nextLine();
		System.out.println(System.lineSeparator());
		authorManagementService.getAuthors().forEach(System.out::println);
		System.out.print("Please enter author id, if does not exist please add author first: ");
		int authorId;
		loop: while (true) {
			try {
				String userInput = sc.next();
				authorId = Integer.parseInt(userInput);
				break loop;
			} catch (NumberFormatException e) {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
			}
		}
		System.out.println("Please enter book price: ");
		BigDecimal price;
		loop: while (true) {
			try {
				String userInput = sc.next();
				price = new BigDecimal(Double.parseDouble(userInput));
				break loop;
			} catch (NumberFormatException e) {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
			}
		}
		System.out.println("Please enter quantity: ");
		int totalQuantity;
		loop: while (true) {
			try {
				String userInput = sc.next();
				totalQuantity = Integer.parseInt(userInput);
				break loop;
			} catch (NumberFormatException e) {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
			}
		}
		String output = bookManagementService.addBook(title, authorId, price, totalQuantity);
		if (output.isEmpty() || output == null) {
			System.out.println("Added Successfully");
		} else {
			System.out.println(output);
		}
		new ViewBooksMenu().init();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("-*-*-*- Add Book -*-*-*-");
	}

}

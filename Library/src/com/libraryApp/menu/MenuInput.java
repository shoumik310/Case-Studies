package com.libraryApp.menu;

import java.util.Scanner;

public abstract class MenuInput implements Menu {

	public static final String INVALID_INPUT_TEXT  = System.lineSeparator() + "Invalid input! Please try again."
			+ System.lineSeparator();
	
	public static final String EXIT_TEXT = "exit";

	public static int getIntInput(Scanner sc, String queryText) {
		int selectedInt;
		typeLoop: while (true) {
			System.out.println(queryText);
			System.out.println("User Input: ");
			String userInput = sc.next();
			try {
				selectedInt = Integer.parseInt(userInput);
				break typeLoop;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_TEXT);
				continue;
			}

		}
		return selectedInt;
	}

	public static int getMenuInput(Scanner sc) {
		int commandNumber;
		typeLoop: while (true) {
			System.out.print("User Input: ");
			String userInput = sc.next();

			if (userInput.equalsIgnoreCase(EXIT_TEXT)) {
				sc.close();
				System.exit(0);
			} else {
				try {
					commandNumber = Integer.parseInt(userInput);
					break typeLoop;
				} catch (NumberFormatException e) {
					System.out.println(INVALID_INPUT_TEXT);
					continue;
				}
			}
		}
		return commandNumber;
	}
}

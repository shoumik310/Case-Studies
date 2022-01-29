package com.libraryApp.menu.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.libraryApp.constants.UserType;
import com.libraryApp.entities.User;
import com.libraryApp.entities.impl.LibraryLibrarian;
import com.libraryApp.entities.impl.LibraryReader;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.session.SessionContext;

public class SignUpMenu implements Menu {

	private final String MEMBERSHIP_TYPE_MESSAGE = "Please select desired membership type: " + System.lineSeparator()
			+ "1. Bronze Tier -> Monthly -> 3 book limit" + System.lineSeparator()
			+ "2. Silver Tier -> Semi-Anually -> 5 book limit" + System.lineSeparator()
			+ "3. Gold Tier -> Anually -> 7 book limit" + System.lineSeparator()
			+ "4. Diamond Tier -> Lifetime -> 4 book limit" + System.lineSeparator();

	// TODO:Improve membership
	private String[] arr = new String[] { "Bronze", "Silver", "Gold", "Platinum" };
	private List<String> membershipTiers = new ArrayList<>(Arrays.asList(arr));

	private SessionContext context;
	private UserManagementService userManagementService;

	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your First Name: ");
		String firstName = sc.next();
		System.out.print("Please enter your Last Name: ");
		String lastName = sc.next();
		System.out.print("Please enter your Email: ");
		String email = sc.next();
		System.out.print("Please enter your Password: ");
		String password = sc.next();
		UserType userType;
		String membershipType;
		loop: while (true) {
			int typeInput = MenuInput.getIntInput(sc, "Please select desired user type: " + System.lineSeparator()
					+ "1. Reader" + System.lineSeparator() + "2. Librarian");

			switch (typeInput) {
			case 1:
				userType = UserType.READER;
				while (true) {
					int memInput = MenuInput.getIntInput(sc, MEMBERSHIP_TYPE_MESSAGE);
					if (memInput <= 0 || memInput > membershipTiers.size()) {
						System.out.println(MenuInput.INVALID_INPUT_TEXT);
						continue;
					} else {
						membershipType = membershipTiers.get(typeInput);
						break;
					}
				}
			case 2:
				userType = UserType.LIBRARIAN;
				membershipType = "N/A";
				break loop;
			default:
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
				continue;
			}
		}
		User user;
		if (userType == UserType.READER) {
			user = new LibraryReader(firstName, lastName, email, password, membershipType);
		} else {
			user = new LibraryLibrarian(firstName, lastName, email, password);
		}
		String errorMessage = userManagementService.addUser(user, userType);
		if (errorMessage == null || errorMessage.isEmpty()) {
			context.setLoggedInUser(user);
		} else {
			System.out.println(errorMessage);
		}
		context.getDefaultMenu().init();

	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator() + "-*-*-*- Sign Up -*-*-*-");

	}

}

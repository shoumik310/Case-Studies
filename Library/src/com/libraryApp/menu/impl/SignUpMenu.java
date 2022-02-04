package com.libraryApp.menu.impl;

import java.util.List;
import java.util.Scanner;

import com.libraryApp.entities.User;
import com.libraryApp.entities.impl.LibraryLibrarian;
import com.libraryApp.entities.impl.LibraryReader;
import com.libraryApp.entities.impl.Membership;
import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.services.impl.MembershipLoadingService;
import com.libraryApp.services.impl.MySQLUserManagementService;
import com.libraryApp.session.SessionContext;

public class SignUpMenu implements Menu {

	private final String MEMBERSHIP_MESSAGE;

	private List<Membership> membershipTiers = MembershipLoadingService.getMemberships();

	private SessionContext context;
	private UserManagementService userManagementService;

	{
		userManagementService = MySQLUserManagementService.getInstance();
		context = SessionContext.getInstance();
		MEMBERSHIP_MESSAGE = voidGenerateMembershipString();
	}

	@Override
	public void init() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your First Name: ");
		String firstName = sc.next();
		System.out.print("Please enter your Last Name: ");
		String lastName = sc.next();
		String email;
		while(true) {
		System.out.print("Please enter your Email: ");
		email = sc.next();
		if(checkEmail(email)) {
			break;
		}
		System.out.println(MenuInput.INVALID_INPUT_TEXT);
		}
		// TODO: Add password hiding
		System.out.print("Please enter your Password: ");
		String password = sc.next();
		String userType;
		Membership membership;
		loop: while (true) {
			int typeInput = MenuInput.getIntInput(sc, "Please select desired user type: " + System.lineSeparator()
					+ "1. Reader" + System.lineSeparator() + "2. Librarian");
			switch (typeInput) {
			case 1:
				userType = "reader";
				while (true) {
					int memInput = MenuInput.getIntInput(sc, MEMBERSHIP_MESSAGE);
					if (memInput <= 0 || memInput > membershipTiers.size()) {
						System.out.println(MenuInput.INVALID_INPUT_TEXT);
						continue;
					} else {
						membership = membershipTiers.get(memInput-1);
						break;
					}
				}
				break loop;
			case 2:
				userType = "librarian";
				membership = null;
				break loop;
			default:
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
				continue;
			}
		}
		User user;
		if (userType.equalsIgnoreCase("reader")) {
			user = new LibraryReader(firstName, lastName, email, password, membership);
		} else {
			user = new LibraryLibrarian(firstName, lastName, email, password);
		}
		String errorMessage = userManagementService.addUser(user, userType);
		if (errorMessage == null || errorMessage.isEmpty()) {
			context.setLoggedInUser(user);
			if(user instanceof LibraryLibrarian) {
				context.setDefaultMenu(new LibrarianMenu());
			}else {
				context.setDefaultMenu(new ReaderMenu());
			}
		} else {
			System.out.println(errorMessage);
		}
		context.getDefaultMenu().init();

	}

	private String voidGenerateMembershipString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Please select desired membership type: " + System.lineSeparator());
		membershipTiers.stream().map(tier -> tier.toString())
				.forEach(tier -> stringBuilder.append(tier + System.lineSeparator()));
		return stringBuilder.toString();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator() + "-*-*-*- Sign Up -*-*-*-");

	}
	
	private Boolean checkEmail(String emailInput) {
		return emailInput.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
	}

}

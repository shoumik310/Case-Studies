package com.libraryApp.menu.impl.readerOptions;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.MenuInput;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.services.impl.MySQLUserManagementService;
import com.libraryApp.session.SessionContext;

public class PayFineMenu implements Menu {

//	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

	private SessionContext context;
	private UserManagementService userManagementService;

	{
		userManagementService = MySQLUserManagementService.getInstance();
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		if(context.getLoggedInUser().getFine()==0) {
			context.getDefaultMenu().init();
		}
		while (true) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Would you like to pay all outstanding fines? y/n");
			String userInput = sc.next();
			if (userInput.equalsIgnoreCase("N")) {
				System.out.println("Returning to previous menu");
				break;
			} else if (userInput.equalsIgnoreCase("Y")) {
				if(userManagementService.PayFine(context.getLoggedInUser().getId())) {
				context.setLoggedInUser(userManagementService.getUserById(context.getLoggedInUser().getId()));
				System.out.println("Thank You for Clearing your Fines");
				}else {
					System.out.println("We were Unable to Clear your Fines");
				}
				break;
			} else {
				System.out.println(MenuInput.INVALID_INPUT_TEXT);
				continue;
			}
		}
		context.getDefaultMenu().init();
	}

//	public boolean isCreditCardNumberValid(String creditCardNumber) {
//		return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER
//				&& !creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0;
//	}

	@Override
	public void printMenuHeader() {
		System.out.println("Your Fine amount is " + context.getLoggedInUser().getFine());

	}

}

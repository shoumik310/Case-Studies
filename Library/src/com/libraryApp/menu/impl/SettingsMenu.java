package com.libraryApp.menu.impl;
//package com.libraryApp.menu.navigableImpl;
//
//import java.util.Scanner;
//
//import com.libraryApp.constants.StringConstants;
//import com.libraryApp.menu.Menu;
//import com.libraryApp.session.SessionContext;
//
//public class SettingsMenu implements Menu {
//
//	private static final String SETTINGS = "1. Change Password" + System.lineSeparator() + "2. Change Email";
//	private SessionContext context;
//	
//	{
//		context = SessionContext.getInstance();
//	}
//	
//	@Override
//	public void init() {
//			
//		Menu nextMenu;
//
//		loop: while (true) {
//			printMenuHeader();
//
//			
//
//				System.out.println(SETTINGS);
//
//				System.out.print("Please, enter option or type 'menu' to navigate back to the main menu: ");
//				
//				Scanner sc = new Scanner(System.in);
//				String userInput = sc.next();
//
//				if (userInput.equalsIgnoreCase(StringConstants.MENU_COMMAND)) {
//					nextMenu = new MainMenu();
//					break loop;
//				}
//
//				int chosenOption = Integer.parseInt(userInput);
//				switch (chosenOption) {
//				case 1:
//					nextMenu = new ChangePasswordMenu();
//					break mainloop;
//				case 2:
//					nextMenu = new ChangeEmailMenu();
//					break mainloop;
//				default:
//					System.out.println("Only 1, 2 is allowed. Try one more time");
//					continue;
//				}
//			}
//		
//
//		nextMenu.start();
//
//
//	}
//
//	@Override
//	public void printMenuHeader() {
//		System.out.println("-*-*-*- Settings -*-*-*-");
//	}
//
//}

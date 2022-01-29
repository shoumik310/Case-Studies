package com.libraryApp.menu.impl;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.session.SessionContext;

public class SignUpMenu implements Menu {

	private SessionContext context;

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

		// TODO: Implement Sign Up Logic

		context.getDefaultMenu().init();
		sc.close();

	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator()+"-*-*-*- Sign Up -*-*-*-");

	}

}

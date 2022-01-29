package com.libraryApp.menu.impl;

import java.util.Scanner;

import com.libraryApp.menu.Menu;
import com.libraryApp.session.SessionContext;

public class SignInMenu implements Menu {
	
	private SessionContext context;
	
	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your Email: ");
		String email = sc.next();
		System.out.print("Please enter your Password: ");
		String password = sc.next();
		
		//TODO: Implement Login Logic
		
		context.getDefaultMenu().init();
		sc.close();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator()+"-*-*-*- Sign In -*-*-*-");

	}
	
}

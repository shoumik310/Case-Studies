package com.libraryApp.menu.impl;

import com.libraryApp.menu.Menu;
import com.libraryApp.session.SessionContext;

public class SignOutMenu implements Menu{

	private SessionContext context;

	{
		context = SessionContext.getInstance();
	}

	@Override
	public void init() {
		printMenuHeader();

		context.setLoggedInUser(null);
		context.setDefaultMenu(context.getMainMenu());
		context.getDefaultMenu().init();
	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator()+"-*-*-*- Sign Out -*-*-*-");
		System.out.println("Have a nice day! Look forward to welcoming back!");
	}

}

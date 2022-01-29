package com.libraryApp.menu.impl;

import com.libraryApp.menu.Menu;

public class ReaderMenu implements Menu {

	private static final String READER_MENU_TEXT = System.lineSeparator()+"Welcome to the XYZ Library" + System.lineSeparator()
	+ "Please enter number in console to proceed:" + System.lineSeparator() + "1. Sign In"
	+ System.lineSeparator() + "2. Sign Up";
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator()+"Main ");

	}

}

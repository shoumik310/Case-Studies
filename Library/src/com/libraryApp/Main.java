package com.libraryApp;

import com.libraryApp.menu.Menu;
import com.libraryApp.menu.impl.MainMenu;

public class Main {

	public static final String EXIT_TEXT="exit";
	
	public static void main(String[] args) {
		
		Menu mainMenu = new MainMenu();
		mainMenu.init();
	}

}

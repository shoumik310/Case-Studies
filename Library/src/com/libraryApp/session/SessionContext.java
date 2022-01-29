package com.libraryApp.session;

import com.libraryApp.entities.User;
import com.libraryApp.menu.Menu;

public class SessionContext {
	private static SessionContext instance;
	
	private Menu defaultMenu;
	private User loggedInUser;
	
	private SessionContext() {}

	public static SessionContext getInstance() {
		if(instance==null) {
			instance = new SessionContext();
		}
		return instance;
	}

	public Menu getDefaultMenu() {
		return defaultMenu;
	}

	public void setDefaultMenu(Menu mainMenu) {
		this.defaultMenu = mainMenu;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	};
	
	
}

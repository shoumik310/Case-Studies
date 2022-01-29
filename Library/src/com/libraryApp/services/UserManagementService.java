package com.libraryApp.services;

import java.util.List;

import com.libraryApp.constants.UserType;
import com.libraryApp.entities.User;

public interface UserManagementService {
	String addUser(User user,UserType userType);
	
	User getUserByEmail(String userEmail);
	
	// TODO: implement authUser
//	Boolean authUser();
	
	List<String> getMembershipDetails();
	
	List<User> getUserWithFine();
	
	List<User> getUsers(UserType userType);
	
	void PayFine();

}

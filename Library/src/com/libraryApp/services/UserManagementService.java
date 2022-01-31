package com.libraryApp.services;

import java.util.List;

import com.libraryApp.entities.User;

public interface UserManagementService {
	
	String addUser(User user,String userType);
	
	User getUserByEmail(String userEmail);
	
	User getUserById(int userId);
	
	// TODO: implement authUser
//	Boolean authUser();
	
	List<User> getUserWithFine();
	
	List<User> getUsers(String userType);
	
	Boolean PayFine(int userId);

}

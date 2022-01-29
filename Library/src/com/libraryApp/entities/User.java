package com.libraryApp.entities;

import com.libraryApp.exceptions.InvalidUserTypeException;

public interface User {
	String getEmail();

	String getPassword();

	void setEmail(String email);

	void setPassword(String password);

	void setFine(int fine) throws InvalidUserTypeException;

	void setMembershipType(String membershipType) throws InvalidUserTypeException;

	void setNumberBorrowed(int numberBorrowed) throws InvalidUserTypeException;
	
	int getId();

	String getMembershipType() throws InvalidUserTypeException;

	int getNumberBorrowed() throws InvalidUserTypeException;

	int getBorrowLimit() throws InvalidUserTypeException;

	int getFine() throws InvalidUserTypeException;

	String getFirstName();

	String getLastName();
}

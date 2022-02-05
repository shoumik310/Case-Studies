package com.libraryApp.entities;

//import com.libraryApp.entities.impl.Membership;

public interface User {
	String getEmail();

	String getPassword();
	
	void setFirstName(String firstName);
	
	void setLastName(String lastName);
	
	void setId(int id);
	
	void setBorrowed(int borrowed);

	void setEmail(String email);

	void setPassword(String password);

	void setFine(int fine);

	int getId();

	void setMembershipId(int membershipId);
	
	int getMembershipId();
	
	int getBorrowed();

	int getFine();

	String getFirstName();

	String getLastName();
}

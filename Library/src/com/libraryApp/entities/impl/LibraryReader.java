package com.libraryApp.entities.impl;

import com.libraryApp.entities.User;

public class LibraryReader implements User {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int id;
	private int fine;
	private int numberBorrowed;
	private int borrowLimit;
	private String membershipType;

	public LibraryReader(int id, String first_name, String last_name, String email, String password, int fine,
			int numberBorrowed, String membershipType, int borrowLimit) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.fine = fine;
		this.numberBorrowed = numberBorrowed;
		this.borrowLimit = borrowLimit;
		this.membershipType = membershipType;
	}

	public LibraryReader(String first_name, String last_name, String email, String password, String membershipType) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.membershipType = membershipType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public int getNumberBorrowed() {
		return numberBorrowed;
	}

	public void setNumberBorrowed(int numberBorrowed) {
		this.numberBorrowed = numberBorrowed;
	}

	public int getBorrowLimit() {
		return borrowLimit;
	}

	public void setBorrowLimit(int borrowLimit) {
		this.borrowLimit = borrowLimit;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
}

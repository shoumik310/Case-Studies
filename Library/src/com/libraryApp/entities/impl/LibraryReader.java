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
	private Membership membership;

	public LibraryReader(int id, String first_name, String last_name, String email, String password, int fine,
			int numberBorrowed, Membership membership) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.fine = fine;
		this.numberBorrowed = numberBorrowed;
		this.setMembership(membership);
	}

	public LibraryReader(String first_name, String last_name, String email, String password, Membership membership) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.membership = membership;
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
		return membership.getBorrowLimit();
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	@Override
	public String toString() {
		return "User id: " + id + "\t Name: " + firstName + " " + lastName + "\t Email: " + email + "\t Fine: " + fine
				+ "\t Borrowed: " + numberBorrowed + "\t Limit: " + membership.getBorrowLimit() + "\t Membership:"
				+ membership.getName();
	}

}

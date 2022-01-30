package com.libraryApp.entities.impl;

import com.libraryApp.entities.User;
import com.libraryApp.exceptions.InvalidUserTypeException;

public class LibraryLibrarian implements User {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int id;

	public LibraryLibrarian(int id, String first_name, String last_name, String email, String password) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
		this.id = id;
	}

	public LibraryLibrarian(String first_name, String last_name, String email, String password) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.password = password;
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

	public void setFine(int fine) {
		throw new InvalidUserTypeException("Fine is not applicable for Librarian");

	}

	@Override
	public void setMembership(Membership membership) {
		throw new InvalidUserTypeException("Membership Type is not applicable for Librarian");

	}

	@Override
	public void setNumberBorrowed(int numberBorrowed) {
		throw new InvalidUserTypeException("Number borrowed  is not applicable for Librarian");
	}

	@Override
	public Membership getMembership() {
		throw new InvalidUserTypeException("Membership Type is not applicable for Librarian");
	}

	@Override
	public int getNumberBorrowed() {
		throw new InvalidUserTypeException("Number borrowed  is not applicable for Librarian");
	}

	@Override
	public int getBorrowLimit() {
		throw new InvalidUserTypeException("Borrow Limit  is not applicable for Librarian");
	}

	@Override
	public int getFine() {
		throw new InvalidUserTypeException("Fine is not applicable for Librarian");
	}

	@Override
	public String toString() {
		return "User id: " + id + "\t Name: " + firstName + " " + lastName + "\t Email=" + email;
	}

}

package com.libraryApp.entities.impl;

import com.libraryApp.entities.User;

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

	public LibraryLibrarian() {
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
		System.out.println("Invalid function setFine for type Librarian");
	}

	@Override
	public void setMembership(Membership membership) {
		System.out.println("Invalid function setMembership for type Librarian");
	}

	@Override
	public void setBorrowed(int borrowed) {
		System.out.println("Invalid function setBorrowed for type Librarian");
	}

	@Override
	public Membership getMembership() {
		System.out.println("Invalid function getMembership for type Librarian");
		return null;
	}

	@Override
	public int getBorrowed() {
		System.out.println("Invalid function getBorrowed for type Librarian");
		return 0;
	}

	@Override
	public int getBorrowLimit() {
		System.out.println("Invalid function setBorrowLimit for type Librarian");
		return 0;
	}

	@Override
	public int getFine() {
		System.out.println("Invalid function getFine for type Librarian");
		return 0;
	}

	@Override
	public String toString() {
		return "User id: " + id + "\t Name: " + firstName + " " + lastName + "\t Email=" + email;
	}

}

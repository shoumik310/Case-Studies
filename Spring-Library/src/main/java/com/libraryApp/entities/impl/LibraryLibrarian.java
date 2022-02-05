package com.libraryApp.entities.impl;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.libraryApp.entities.User;

public class LibraryLibrarian implements User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column
	private String email;

	@Column
	private String password;

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
	public void setMembershipId(int membershipId) {
		System.out.println("Invalid function setMembership for type Librarian");
	}

	@Override
	public void setBorrowed(int borrowed) {
		System.out.println("Invalid function setBorrowed for type Librarian");
	}

	@Override
	public int getMembershipId() {
		System.out.println("Invalid function getMembership for type Librarian");
		return 0;
	}

	@Override
	public int getBorrowed() {
		System.out.println("Invalid function getBorrowed for type Librarian");
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

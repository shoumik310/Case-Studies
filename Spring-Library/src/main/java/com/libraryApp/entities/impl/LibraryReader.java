package com.libraryApp.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.libraryApp.entities.User;

@Entity
@Table(name="user")
public class LibraryReader implements User {
	
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
	
	@Column
	private int fine;
	
	@Column
	private int borrowed;
	
	@Column
	private int membershipId;
	
//	private Membership membership;
	
	public LibraryReader() {
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

	public int getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(int borrowed) {
		this.borrowed = borrowed;
	}
	public int getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}

	@Override
	public String toString() {
		return "User id: " + id + "\t Name: " + firstName + " " + lastName + "\t Email: " + email + "\t Fine: " + fine
				+ "\t Borrowed: " + borrowed + "\t Limit: " ;//+ membership.getBorrowLimit() + "\t Membership:"
//				+ membership.getName();
	}

}

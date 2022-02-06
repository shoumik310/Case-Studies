package com.libraryApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;

	private String userType = "librarian";

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Librarian() {
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

//	@Override
//	public void setBorrowed(int borrowed) {
//		System.out.println("Invalid function setBorrowed for type Librarian");
//	}
//
//	@Override
//	public int getBorrowed() {
//		System.out.println("Invalid function getBorrowed for type Librarian");
//		return 0;
//	}
//
//	@Override
//	public int getFine() {
//		System.out.println("Invalid function getFine for type Librarian");
//		return 0;
//	}

	@Override
	public String toString() {
		return "User id: " + id + "\t Name: " + firstName + " " + lastName + "\t Email=" + email;
	}

//	@Override
//	public void setMembership(Membership membership) {
//		System.out.println("Invalid function setMembership for type Librarian");
//	}
//
//	@Override
//	public Membership getMembership() {
//		System.out.println("Invalid function getFine for type Librarian");
//		return null;
//	}

}

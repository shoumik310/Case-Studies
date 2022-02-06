package com.libraryApp.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Reader {

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
	@Column(columnDefinition = "INT DEFAULT 0")
	private int fine = 0;
	@Column(columnDefinition = "INT DEFAULT 0")
	private int borrowed = 0;

	private String userType = "reader";

	@OneToMany(mappedBy = "reader")
	Set<Transaction> transactions;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Reader() {
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

	@Override
	public String toString() {
		return "User id: " + id + "\t Name: " + firstName + " " + lastName + "\t Email: " + email + "\t Fine: " + fine
				+ "\t Borrowed: " + borrowed;
	}

}

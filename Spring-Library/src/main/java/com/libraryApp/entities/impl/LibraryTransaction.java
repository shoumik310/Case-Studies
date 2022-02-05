package com.libraryApp.entities.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.libraryApp.entities.Transaction;

public class LibraryTransaction implements Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "book_id")
	private int bookId;
	
	@Column
	private Date issueDate;
	
	@Column
	private Date dueDate;
	
	@Column
	private Date returnDate;
	
	public LibraryTransaction(int userId, int bookId) {
		super();
		this.userId = userId;
		this.bookId = bookId;
	}
	
	public LibraryTransaction() {
		this.returnDate=null;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "LibraryTransaction [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", issueDate=" + issueDate
				+ ", dueDate=" + dueDate + ", returnDate=" + returnDate + "]";
	}
	
	
	
	
}

package com.libraryApp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@ManyToOne
	@JoinColumn(name = "reader_id", referencedColumnName = "id", nullable = false)
	private Reader reader;

	@ManyToOne()
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private Book book;

	@Column(name = "issue_date")
	private LocalDate issueDate = LocalDate.now();

	@Column(name = "due_date")
	private LocalDate dueDate = LocalDate.now().plusDays(14);

	@Column(name = "return_date")
	private LocalDate returnDate = null;

	{
		this.returnDate = null;
	}

	public Transaction(Reader reader, Book book) {
		this.reader = reader;
		this.book = book;
	}

	public Transaction() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "LibraryTransaction [id=" + id + ", reader=" + reader + ", book=" + book + ", issueDate=" + issueDate
				+ ", dueDate=" + dueDate + ", returnDate=" + returnDate + "]";
	}
}

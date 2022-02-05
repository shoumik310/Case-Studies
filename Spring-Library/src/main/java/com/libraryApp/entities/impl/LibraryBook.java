package com.libraryApp.entities.impl;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.libraryApp.entities.Book;

public class LibraryBook implements Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private String title;

	@Column
	private BigDecimal price;

	@Column
	private int totalQuantity;

	@Column
	private int availableQuantity = totalQuantity;

	@Column(name = "author_id")
	private int authorId;

//	private Author author;

	public LibraryBook() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toLimitedString() {
		return "Book id: " + id + "\t Title: " + title + "\t Remaining: " + availableQuantity + "\t Author: ";
				//+ author.getName();
	}

	@Override
	public String toString() {
		return "Book id: " + id + "\t Title: " + title + "\t Price: " + price + "\t Stock: " + totalQuantity
				+ "\t Remaining: " + availableQuantity + "\t Author: ";// + author.getName();
	}

}

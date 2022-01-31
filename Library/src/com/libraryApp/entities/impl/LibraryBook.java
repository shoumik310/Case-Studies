package com.libraryApp.entities.impl;

import java.math.BigDecimal;

import com.libraryApp.entities.Book;

public class LibraryBook implements Book {
	private int id;
	private String title;
	private BigDecimal price;
	private int totalQuantity;
	private int availableQuantity;
	private Author author;

	public LibraryBook() {
	}

	public LibraryBook(String title, BigDecimal price, int totalQuantity, Author author) {
		super();
		this.title = title;
		this.price = price;
		this.totalQuantity = totalQuantity;
	}

	public LibraryBook(int id, String title, Author author, BigDecimal price, int totalQuantity, int availableQuantity) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.totalQuantity = totalQuantity;
		this.availableQuantity = availableQuantity;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toLimitedString() {
		return "Book id: " + id + "\t Title: " + title + "\t Remaining: " + availableQuantity + "\t Author: "
				+ author.getName();
	}

	@Override
	public String toString() {
		return "Book id: " + id + "\t Title: " + title + "\t Price: " + price + "\t Stock: " + totalQuantity
				+ "\t Remaining: " + availableQuantity + "\t Author: " + author.getName();
	}

}

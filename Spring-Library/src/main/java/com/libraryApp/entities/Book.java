package com.libraryApp.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "book")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	private String title;
	@Column(nullable = false)
	private BigDecimal price;

	@Column(name = "total_quantity", nullable = false)
	private int totalQuantity;

	@Column(name = "available_quantity")
	private int availableQuantity = totalQuantity;

	@OneToMany(mappedBy = "book")
	Set<Transaction> transactions;

	public Book() {
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

	public String toLimitedString() {
		return "Book id: " + id + "\t Title: " + title + "\t Remaining: " + availableQuantity;
	}

	public String toString() {
		return "Book id: " + id + "\t Title: " + title + "\t Price: " + price + "\t Stock: " + totalQuantity
				+ "\t Remaining: " + availableQuantity;
	}

}

package com.libraryApp.entities.impl;

import java.math.BigDecimal;

public class Membership {
	private int id;
	private String name;
	private int borrowLimit;
	private String duration;
	private BigDecimal price;

	public Membership() {
	}

	public Membership(int id, String name, int borrowLimit, String duration, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.borrowLimit = borrowLimit;
		this.duration = duration;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBorrowLimit() {
		return borrowLimit;
	}

	public void setBorrowLimit(int borrowLimit) {
		this.borrowLimit = borrowLimit;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return id + ". " + name + "\t Duration: " + duration + "\t Price: " + price;
	}
	
	
}

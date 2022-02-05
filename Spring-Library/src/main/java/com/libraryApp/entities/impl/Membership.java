package com.libraryApp.entities.impl;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Membership {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column
	private String name;

	@Column
	private int borrowLimit;

	@Column
	private String duration;

	@Column
	private BigDecimal price;

	public Membership() {
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

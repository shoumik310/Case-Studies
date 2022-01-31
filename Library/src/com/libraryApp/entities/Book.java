package com.libraryApp.entities;

import java.math.BigDecimal;

import com.libraryApp.entities.impl.Author;

public interface Book {

	public int getId();
	
	void setId(int id);
	
	void setAuthor(Author author);
	
	public void setTitle(String title);

	public void setPrice(BigDecimal price);
	
	public void setTotalQuantity(int totalQuantity);
	
	String getTitle();
	
	Author getAuthor();
	
	int getTotalQuantity();
	
	BigDecimal getPrice();
	
	public int getAvailableQuantity();
	
	public void setAvailableQuantity(int availableQuantity);
	
	public String toLimitedString();
}

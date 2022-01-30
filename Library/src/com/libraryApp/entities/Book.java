package com.libraryApp.entities;

import java.math.BigDecimal;

public interface Book {

	public int getId();
	
	public void setTitle(String title);

	public void setPrice(BigDecimal price);
	
	public void setTotalQuantity(int totalQuantity);
	
	String getTitle();
	
	int getTotalQuantity();
	
	BigDecimal getPrice();
	
	public int getAvailableQuantity();
	
	public void setAvailableQuantity(int availableQuantity);
	
	public String toLimitedString();
}

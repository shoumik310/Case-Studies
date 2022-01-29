package com.libraryApp.entities;

public interface Book {

	public int getId();
	
	public void setTitle(String title);

	public void setPrice(double price);
	
	public void setTotalQuantity(int totalQuantity);
	
	public int getAvailableQuantity();
	
	public void setAvailableQuantity(int availableQuantity);
	
	public String toLimitedString();
}

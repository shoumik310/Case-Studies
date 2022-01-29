package com.libraryApp.entities;

import java.util.Date;

public interface Transaction {
	Date getDueDate();

	int getBookId();

	int getUserId();

	int getId();

	void setReturnDate(Date returnDate);
}

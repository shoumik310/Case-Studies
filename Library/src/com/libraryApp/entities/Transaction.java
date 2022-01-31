package com.libraryApp.entities;

import java.util.Date;

public interface Transaction {
	Date getDueDate();

	Date getIssueDate();

	void setDueDate(Date dueDate);

	void setIssueDate(Date issueDate);

	void setBookId(int bookId);

	void setUserId(int userId);

	void setId(int id);

	int getBookId();

	int getUserId();

	int getId();

	void setReturnDate(Date returnDate);

	Date getReturnDate();
}

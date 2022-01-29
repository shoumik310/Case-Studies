package com.libraryApp.services;

import java.util.List;

import com.libraryApp.entities.Transaction;

public interface TransactionManagementService {
	void addTransaction(Transaction transaction);
	
	String updateReturnDate(Transaction transaction);
	
	List<Transaction> getTransactionByUserID(int userId);
	
	List<Transaction> getTransaction(int userId);
}

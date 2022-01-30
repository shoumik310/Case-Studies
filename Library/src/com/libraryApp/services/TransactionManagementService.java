package com.libraryApp.services;

import java.util.List;

import com.libraryApp.entities.Transaction;

public interface TransactionManagementService {
	
	void addTransaction(Transaction transaction);
	
	int updateReturnDate(int BookId);
	
	List<Transaction> getTransactionByUserID(int userId);
	
	List<Transaction> getTransaction(int userId);
}

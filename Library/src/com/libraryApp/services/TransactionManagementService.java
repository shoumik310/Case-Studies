package com.libraryApp.services;


public interface TransactionManagementService {
	
	String addTransaction(int userId, int bookId);
	
	int updateReturnDate(int bookId, int userId);
}

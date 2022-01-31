package com.libraryApp.services;


public interface TransactionManagementService {
	
	String addTransaction(int userId, int bookId);
	
	String updateReturnDate(int bookId, int userId);
}

package com.libraryApp.services.impl;

import java.util.List;

import com.libraryApp.entities.Transaction;
import com.libraryApp.services.TransactionManagementService;

public class MySQLTransactionManagementService implements TransactionManagementService {
	
	private static MySQLTransactionManagementService instance;
	
	private MySQLTransactionManagementService() {
	}
	
	public static MySQLTransactionManagementService getInstance() {
		if(instance==null) {
			instance = new MySQLTransactionManagementService();
		}
		return instance;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateReturnDate(int BookId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transaction> getTransactionByUserID(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransaction(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

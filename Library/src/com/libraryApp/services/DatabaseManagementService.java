package com.libraryApp.services;

import java.util.Date;

public interface DatabaseManagementService {
	void updateTable(String tableName, String attributeName, String newValue, int referenceId);
	void updateTable(String tableName, String attributeName, int newValue, int referenceId);
	void updateTable(String tableName, String attributeName, double newValue, int referenceId);
	void updateTable(String tableName, String attributeName, Date newValue, int referenceId);
	
	void deleteEntry(String tableName, int referenceId);

}

package com.libraryApp.storage;

import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class OracleDBUtil{

//	private static final String JDBC_ORACLE_HOST = "jdbc:oracle:";
//	private static final String DB_NAME = "library";
//	
//	private static final String READER_USERNAME = "";
//	private static final String READER_PASSWORD = "";
//	
//	private static final String LIBRARIAN_USERNAME = "";
//	private static final String LIBRARIAN_PASSWORD = "";

	private OracleDBUtil() {
	};
	
	//TODO: Add Oracle Support
	
	public static Connection getLibrarianConnection() {
		throw new RuntimeException("Database Not Configured"); 
//		try {
//			return DriverManager.getConnection(JDBC_ORACLE_HOST + DB_NAME, LIBRARIAN_USERNAME, LIBRARIAN_PASSWORD);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
	}

	public static Connection getReaderConnection() {
		throw new RuntimeException("Database Not Configured"); 
//		try {
//			return DriverManager.getConnection(JDBC_ORACLE_HOST + DB_NAME, READER_USERNAME, READER_PASSWORD);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
	}
}

package com.libraryApp.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.libraryApp.entities.User;
import com.libraryApp.entities.impl.LibraryLibrarian;

public class MySQLDBUtil {

	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "library";

	private static final String READER_USERNAME = "reader";
	private static final String READER_PASSWORD = "reader";

	private static final String LIBRARIAN_USERNAME = "librarian";
	private static final String LIBRARIAN_PASSWORD = "librarian";

	private MySQLDBUtil() {
	};

	public static Connection getConnection(User user) {
		if (user instanceof LibraryLibrarian) {
			try {
				return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, LIBRARIAN_USERNAME, LIBRARIAN_PASSWORD);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			try {
				return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, READER_USERNAME, READER_PASSWORD);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

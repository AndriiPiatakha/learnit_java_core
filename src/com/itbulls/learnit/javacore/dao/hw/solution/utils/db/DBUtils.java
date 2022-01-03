package com.itbulls.learnit.javacore.dao.hw.solution.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "learn_it_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private DBUtils() {
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

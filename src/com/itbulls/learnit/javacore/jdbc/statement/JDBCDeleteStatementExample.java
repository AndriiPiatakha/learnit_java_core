package com.itbulls.learnit.javacore.jdbc.statement;

import java.sql.SQLException;
import java.sql.Statement;

import com.itbulls.learnit.javacore.jdbc.DBUtils;

public class JDBCDeleteStatementExample {
	
	public static void main(String[] args) throws SQLException {
		try (var conn = DBUtils.getConnection()) {
			Statement statement = conn.createStatement();
			String query = "DELETE FROM user WHERE id = 20";
			
			int rows = statement.executeUpdate(query);
			System.out.println(rows);
			
		}
	}
	
}

package com.itbulls.learnit.javacore.jdbc.preparedstatement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.itbulls.learnit.javacore.jdbc.DBUtils;

public class JDBCDeleteStatementExample {
	
	public static void main(String[] args) throws SQLException {
		String query = "DELETE FROM user WHERE id = ?";
		try (var conn = DBUtils.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setInt(1, 20);
			int rows = preparedStatement.executeUpdate();
			System.out.println(rows);
			
		}
	}
	
}

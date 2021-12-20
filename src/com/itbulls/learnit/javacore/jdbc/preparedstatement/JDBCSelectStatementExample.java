package com.itbulls.learnit.javacore.jdbc.preparedstatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itbulls.learnit.javacore.jdbc.DBUtils;

public class JDBCSelectStatementExample {
	
	public static void main(String[] args) throws SQLException {
		String query = "SELECT * FROM user";
		
		try (var conn = DBUtils.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					System.out.println("=================");
					System.out.println("ID:\t\t" + rs.getInt("ID"));
					System.out.println("First Name:\t" + rs.getString("first_name"));
					System.out.println("Last Name:\t" + rs.getString("last_name"));
					System.out.println("Email:\t\t" + rs.getString("email"));
				}
			};
			
		}
	}

}

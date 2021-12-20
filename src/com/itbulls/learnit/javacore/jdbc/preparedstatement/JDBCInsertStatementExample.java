package com.itbulls.learnit.javacore.jdbc.preparedstatement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.itbulls.learnit.javacore.jdbc.DBUtils;

public class JDBCInsertStatementExample {
	
	public static void main(String[] args) throws SQLException {
		String query = "INSERT INTO user (first_name, last_name, email, fk_user_role, money) VALUES (?, ?, ?, ?, ?)";
		
		try (var conn = DBUtils.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			preparedStatement.setString(1, "Dmytriy");
			preparedStatement.setString(2, "Voloshov");
			preparedStatement.setString(3, "d.voloshov@email.com");
			preparedStatement.setInt(4, 4);
			preparedStatement.setInt(5, 0);
			int rows = preparedStatement.executeUpdate();
			System.out.println(rows);
			
		}
	}

}

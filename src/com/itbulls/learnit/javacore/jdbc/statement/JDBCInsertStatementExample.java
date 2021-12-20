package com.itbulls.learnit.javacore.jdbc.statement;

import java.sql.SQLException;
import java.sql.Statement;

import com.itbulls.learnit.javacore.jdbc.DBUtils;

public class JDBCInsertStatementExample {
	
	public static void main(String[] args) throws SQLException {
		String query = "INSERT INTO user (first_name, last_name, email, fk_user_role, money) VALUES ('Dmytriy', 'Voloshov', 'd.voloshov@email.com', 4, 0)";
		try (var conn = DBUtils.getConnection();
				Statement statement = conn.createStatement()) {
			int rows = statement.executeUpdate(query);
			System.out.println(rows);
			
		}
	}

}

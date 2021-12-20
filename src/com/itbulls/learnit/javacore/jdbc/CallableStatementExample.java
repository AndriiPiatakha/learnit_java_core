package com.itbulls.learnit.javacore.jdbc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExample {
	
	public static void main(String[] args) throws SQLException {
		try (var conn = DBUtils.getConnection();
				CallableStatement callStatement = conn.prepareCall("CALL select_user_by_email(?)")) {
			
			callStatement.setString(1, "s.ivanov@email.com");
			
			// ONLY IN CASE out parameter register the OUT parameter before calling the stored procedure
//			callStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
			
			try (ResultSet rs = callStatement.executeQuery()) {
				
				if (rs.next()) {
					System.out.println("User last name: " + rs.getString("last_name"));
				}
				
				// ONLY IN CASE out parameter read the OUT parameter now
//				String result = callStatement.getString(1);
				
			}
			
		}
	}

}

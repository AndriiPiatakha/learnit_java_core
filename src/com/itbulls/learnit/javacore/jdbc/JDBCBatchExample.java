package com.itbulls.learnit.javacore.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCBatchExample {
	
	
	public static void main(String[] args) throws SQLException {
		
		try(var conn = DBUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO user (first_name, last_name, email, fk_user_role, money) VALUES (?, ?, ?, ?, ?)")) {
			conn.setAutoCommit(false);
			
			try {
				ps.setString(1, "Dmytriy");
				ps.setString(2, "Voloshov");
				ps.setString(3, "d.voloshov@email.com");
				ps.setInt(4, 4);
				ps.setInt(5, 0);
				ps.addBatch();
				
				ps.setString(1, "Semen");
				ps.setString(2, "Zhukov");
				ps.setString(3, "s.zhukov@email.com");
				ps.setInt(4, 4);
				ps.setInt(5, 0);
				ps.addBatch();
				
				ps.setString(1, "Andrey");
				ps.setString(2, "Makarevych");
				ps.setString(3, "a.makarevych@email.com");
				ps.setInt(4, 4);
				ps.setInt(5, 0);
				ps.addBatch();
				
				ps.executeBatch();
				
				conn.commit();
				System.out.println("All records successfully inserted!");
			} catch (SQLException e) {
				e.printStackTrace();
				conn.rollback();
			}
			
			
		}
		
	}

}

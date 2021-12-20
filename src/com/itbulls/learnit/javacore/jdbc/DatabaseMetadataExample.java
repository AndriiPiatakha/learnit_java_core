package com.itbulls.learnit.javacore.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseMetadataExample {
	
	public static void main(String[] args) throws SQLException {
		try (var conn = DBUtils.getConnection()) {
			DatabaseMetaData metaData = conn.getMetaData();

			System.out.println("===== TABLE NAMES =====");
			ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"}); 
			while(resultSet.next()) { 
			    String tableName = resultSet.getString("TABLE_NAME"); 
			    System.out.println("Table name:\t" + tableName);
			}
			
			System.out.println("===== COLUMN VALUES =====");
			ResultSet tableTypes = metaData.getTableTypes();
			ResultSetMetaData metaDataTableTypes = tableTypes.getMetaData();
			int columnCount = metaDataTableTypes.getColumnCount();
			while (tableTypes.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.println(tableTypes.getString(i));
				}
			}
			
		}
	}

}

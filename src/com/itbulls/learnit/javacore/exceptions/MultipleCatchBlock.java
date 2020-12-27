package com.itbulls.learnit.javacore.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class MultipleCatchBlock {

	public static void main(String[] args) {
		try {
			Files.readAllLines(Paths.get("path to non existing file.txt"));
			Connection conn = DriverManager.getConnection("");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		try {
			Files.readAllLines(Paths.get("path to non existing file.txt"));
			Connection conn = DriverManager.getConnection("");
		} catch (IOException e) {
			System.out.println("Notify user that file doesn't exist and " 
						+ "ask user to provide new file.");
		} catch (SQLException e) {
			System.out.println("Notify user that there are an error with Database.");
		}

		try {
			Files.readAllLines(Paths.get("path to non existing file.txt"));
			var fr = new FileReader("fileName.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");

		} catch (IOException e) {
			System.out.println("Notify user that file doesn't exist and " 
						+ "ask user to provide new file.");
		}
		
		
		// ========== Unreachable catch block demo
//		try {
//			Files.readAllLines(Paths.get("path to non existing file.txt"));
//			var fr = new FileReader("fileName.txt");
//		} catch (IOException e) {
//			System.out.println("Notify user that file doesn't exist and " 
//						+ "ask user to provide new file.");
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found error");
//		}
		
	}

}

package com.itbulls.learnit.javacore.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FinallyBlockDemo {
	
	public static void main(String[] args) {
		try {
			Files.readAllLines(Paths.get("path to non existing file.txt"));
		} catch (IOException e) {
			System.out.println("*** We are in catch block ***");
			System.out.println("*** We can log stack trace: " + 
								Arrays.toString(e.getStackTrace()));
			e.getCause(); // get original exception
			e.getMessage(); // get message that is associated with this exception
			e.printStackTrace();
		} finally {
//			System.exit(0);
//			throw new RuntimeException();
			System.out.println("Finally block will be executed "
					+ "with and without exception");
		}
	}

}

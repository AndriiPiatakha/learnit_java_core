package com.itbulls.learnit.javacore.methods.hw;

public class StringProcessor {
	
	// TODO: mention StringBuilder 
	
	public static final String INPUT_DATA = "Login;Name;Email" + System.lineSeparator() +
			"peterson;Chris Peterson;peterson@outlook.com" + System.lineSeparator() +
			"james;Derek James;james@gmail.com" + System.lineSeparator() +
			"jackson;Walter Jackson;jackson@gmail.com" + System.lineSeparator() +
			"gregory;Mike Gregory;gregory@yahoo.com";
	
	public static void main(String[] args) {
		System.out.println("===== Convert 1 demo =====");
		System.out.println(convert1(INPUT_DATA));
		
		System.out.println("===== Convert 2 demo =====");
		System.out.println(convert2(INPUT_DATA));
		
	}
	
	public static String convert1(String input) {
		String result = "";
		String[] lines = input.split(System.lineSeparator());
		for (int i = 1; i < lines.length; i++) {
			String[] wordsInLine = lines[i].split(";");
			result += wordsInLine[0] + " ==> " + wordsInLine[2] + System.lineSeparator();
		}
		return result;
	
	}
	
	
	public static String convert2(String input) {
		String result = new String();
		String[] lines = input.split(System.lineSeparator());
		for (int i = 1; i < lines.length; i++) {
			String[] wordsInLine = lines[i].split(";");
			result += wordsInLine[1] + " (email: " + wordsInLine[2] + ")" + System.lineSeparator();
		}
		return result;
	
	}

}

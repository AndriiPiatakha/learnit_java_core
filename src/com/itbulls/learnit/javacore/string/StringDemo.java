package com.itbulls.learnit.javacore.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo {
	
	public static void main(String[] args) {
		System.out.println();
		System.out.println("===== String methods =====");
		System.out.println();
		
		String s = " hello ";
		System.out.println("s.length(): " + s.length());					// 7
		System.out.println("s.contains(\"he\"): " + s.contains("he"));		// true
		System.out.println("s.isEmpty: " + s.isEmpty());					// false
		System.out.println("s.toUpperCase(): " + s.toUpperCase());			//  HELLO
		System.out.println("s.startsWith(\"h\"): " + s.startsWith("h"));	// false
		System.out.println("s.endsWith(\" \"): "+ s.endsWith(" "));			// true
		System.out.println("s.replace(\"ll\", \"LL\"): " + s.replace("ll", "LL"));	// heLLo
		System.out.println("s.trim(): " + s.trim());						// hello
		System.out.println("s.strip(): " + s.strip());						// hello
		System.out.println("s.substring(0, 3): " + s.substring(0, 3));		//  he
		System.out.println("Arrays.toString(s.getBytes()): " 
						+ Arrays.toString(s.getBytes()));	// [32, 104, 101, 108, 108, 111, 32]
		System.out.println("Arrays.toString(s.toCharArray()): " 
						+ Arrays.toString(s.toCharArray()));	// [ , h, e, l, l, o,  ]
		System.out.println("s.charAt(1): " + s.charAt(1));					// h
		System.out.println("Arrays.toString(s.split(\"e\")): " 
						+ Arrays.toString(s.split("e")));					// [ h, llo ]
		System.out.println(s);												// hello 
		
		System.out.println();
		System.out.println("===== String comparison =====");
		System.out.println();
		
		String s2 = " hello ";
		System.out.println("s == s2: " + (s == s2));					// true
		
		String s3 = new String(" hello ");
		System.out.println("s == s3: " + (s == s3));					// false
		System.out.println("s.equals(s3): " + s.equals(s3)); 			// true
		System.out.println("s == s3.intern(): " + (s == s3.intern()));	// true
		
		String firstName = "Andrii";
		String firstName2 = "andrii";
		System.out.println("firstName.equals(firstName2): " 
							+ firstName.equals(firstName2));			// false
		System.out.println("firstName.equalsIgnoreCase(firstName2): " 
							+ firstName.equalsIgnoreCase(firstName2)); 	// true
		
		
		System.out.println();
		System.out.println("===== Escape sequences =====");
		System.out.println();
		
		System.out.println("My favourite book is \"The one thing\" by Gary Keller.");
		System.out.println("Path to the source code: D:\\Java\\sources");
		
		/*
		 	\t - tab.
			\b - backspace (a step backward in the text or deletion of a single character).
			\n - new line.
			\r - carriage return. ()
			\f - form feed.
			\' single quote.
			\" double quote.
			\\ backslash.
		 */
		
		System.out.println("some text line 1\nsome text line 2");
		
		System.out.println("Unicode characters, \u00A9 IT-Bulls.com");
		
		
		System.out.println();
		System.out.println("===== String formatting =====");
		System.out.println();
		
		
		String greetingsTemplate = "Hello, dear %s! Good %s!";
		
		String morning = "morning";
		String afternoon = "afternoon";
		String evening = "evening";
		String formattedString = String.format(greetingsTemplate, firstName, morning);
		System.out.println(formattedString);
		
		System.out.printf("You have %d computers available at store\n", 10);
		
		
		
		System.out.println();
		System.out.println("===== Regular expressions =====");
		System.out.println();
		
		String gmailPattern = "[a-zA-Z-\\d]+@gmail\\.com";
		Pattern p = Pattern.compile(gmailPattern);
		String sampleText = "Some random text that contains gmail addresses "
				+ "like this one some-email@gmail.com. And some other random text.";
		Matcher m = p.matcher(sampleText);
		
		m.find();
		String gmailAddress = m.group();
		System.out.println(gmailAddress);
		
		String sampleText2 = "There are three sentences in this string. Are you sure? Yes!";
		String[] sentences = sampleText2.split("[\\.!?]");
		System.out.println(Arrays.toString(sentences));
		
		
	}

}

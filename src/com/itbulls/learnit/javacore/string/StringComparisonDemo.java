package com.itbulls.learnit.javacore.string;

public class StringComparisonDemo {
	
	public static void main(String[] args) {
		System.out.println("===== String comparison =====");
		System.out.println();
		
		String s = " hello ";
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
		
		
	}

}

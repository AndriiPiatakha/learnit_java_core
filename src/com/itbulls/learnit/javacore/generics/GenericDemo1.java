package com.itbulls.learnit.javacore.generics;

public class GenericDemo1 {
	
	public static void main(String[] args) {
		String[] strings = {"one", "two", "three"};
		
		printArray(strings);
		
		
		Integer[] ints = {1, 2, 3};
		
		// compilation error, because printArray(String[] arr) works only with String arrays, 
		// but not with other arrays. 
		printArray(ints); 
	}

//	private static void printArray(String[] arr) {
//		for (String string : arr) {
//			System.out.println("Element: " + string);
//		}
//	}
	
	private static <E> void printArray(E[] arr) {
		// Display array elements
		for (E element : arr) {
			System.out.println("Element: " + element);
		}
	}

}

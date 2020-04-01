package com.itbulls.learnit.javacore.misc;

public class RefactoringDemo2 {

	public static void main(String[] args) {

		printToConsole();

	}

	private static void printToConsole() {
		int i = 10;
		System.out.println("Some code that are not aligned");
		int sum = 10 + 5;
		System.out.println(sum);
		System.out.println(sum);
	}

}

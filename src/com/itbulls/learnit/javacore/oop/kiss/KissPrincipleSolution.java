package com.itbulls.learnit.javacore.oop.kiss;

import java.util.Scanner;

public class KissPrincipleSolution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		scanner.close();

		if (number < 0) {
			System.out.println("Factorial is not defined for negative numbers.");
		} else {
			long result = calculateFactorial(number);
			System.out.println("The factorial of " + number + " is " + result);
		}
	}

	private static long calculateFactorial(int n) {
		long factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}
}

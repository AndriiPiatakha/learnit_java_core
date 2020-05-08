package com.itbulls.learnit.javacore.controlstatements.loops.hw;

import java.util.Scanner;

public class NewLineForDigit {

	public static void main(String[] args) {
		System.out.print("Please, enter any integer: ");
		Scanner sc = new Scanner(System.in);
		String intString = sc.next();
		for (char digit : intString.toCharArray()) {
			System.out.println(digit);
		}
	}
}

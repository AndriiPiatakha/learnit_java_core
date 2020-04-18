package com.itbulls.learnit.javacore.methods.hw;

import java.util.Scanner;

public class AmountOfWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any text: ");
		String userInput = sc.nextLine();
		
		int amountOfWords = getWordsAmount(userInput);
		System.out.println("Amount of words in your text: " + amountOfWords);
	}

	public static int getWordsAmount(String text) {
		return text.split("[\\p{P}\\s]+").length;
	}
}

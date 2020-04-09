package com.itbulls.learnit.javacore.string.hw;

import java.util.Arrays;
import java.util.Scanner;

public class SplitWords {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any text: ");
		String userInput = sc.nextLine();
		System.out.print("You entered these words: ");
		System.out.println(Arrays.toString(userInput.split("[\\p{P}\\s]+"))); // POSIX character classes
	
		/*
				\p{Lower}   A lower-case alphabetic character: [a-z]
				\p{Upper}   An upper-case alphabetic character:[A-Z]
				\p{ASCII}   All ASCII:[\x00-\x7F]
				\p{Alpha}   An alphabetic character:[\p{Lower}\p{Upper}]
				\p{Digit}   A decimal digit: [0-9]
				\p{Alnum}   An alphanumeric character:[\p{Alpha}\p{Digit}]
				\p{Punct}   Punctuation: One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
				\p{Graph}   A visible character: [\p{Alnum}\p{Punct}]
				\p{Print}   A printable character: [\p{Graph}\x20]
				\p{Blank}   A space or a tab: [ \t]
				\p{Cntrl}   A control character: [\x00-\x1F\x7F]
				\p{XDigit}  A hexadecimal digit: [0-9a-fA-F]
				\p{Space}   A whitespace character: [ \t\n\x0B\f\r]
				
		*/
	}

}

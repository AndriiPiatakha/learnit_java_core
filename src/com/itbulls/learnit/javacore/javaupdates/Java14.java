package com.itbulls.learnit.javacore.javaupdates;

import java.text.NumberFormat;
import java.util.*;

public class Java14 {

	public static void main(String[] args) {
		System.out.println("===== Switch Expressions =====");
		
		int day = 3;
		
		String dayName = switch (day) {
			case 1 -> "Monday";
			case 2 -> "Tuesday";
			case 3 -> "Wednesday";
			case 4 -> "Thursday";
			case 5 -> "Friday";
			case 6 -> "Saturday";
			case 7 -> "Sunday";
			default -> "Invalid day";
		};

		dayName = switch (day) {
			case 1, 2, 3, 4, 5 -> "Weekday";
			case 6, 7 -> "Weekend";
			default -> "Invalid day";
		};
		
		System.out.println(dayName);

		
		System.out.println();
		System.out.println("===== Helpful NullPointerExceptions =====");
		
		String nullString = null;
//		System.out.println(nullString.length());
		
		List<String> list = new ArrayList<>();
		list.add(nullString);
		
//		System.out.println(list.get(0).length());
		
		System.out.println();
		System.out.println("===== Currency format support =====");
		// Create a Locale for the United States
        Locale usLocale = new Locale("en", "US");

        // Create a Currency instance for the US Dollar
        Currency usd = Currency.getInstance("USD");

        // Create a NumberFormat instance for accounting currency formatting
        NumberFormat accountingFormat = NumberFormat.getCurrencyInstance(usLocale);

        // Set the currency to USD and enable accounting formatting
        accountingFormat.setCurrency(usd);
        accountingFormat.setMaximumFractionDigits(2); // Set maximum fraction digits

        // Sample monetary value
        double amount = 1234567.89;

        // Format and display the amount using accounting currency format
        String formattedAmount = accountingFormat.format(amount);
        System.out.println("Accounting Currency Format: " + formattedAmount);
	}

}

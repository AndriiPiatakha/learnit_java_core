package com.itbulls.learnit.javacore.l18ni10n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class LocaleDemo {
	
	public static void main(String[] args) {
		Locale l1 = new Locale("hi", "IN");
		Locale l2 = new Locale("en", "IN");
		
		Locale l3 = new Locale("ru", "UA");
		Locale l4 = new Locale("ua", "UA");
		
		Locale l5 = new Locale.Builder()
								.setLanguage("en")
								.setRegion("US")
								.build();
		
		Locale l6 = Locale.forLanguageTag("en-US");
		
		printAllAvailableLocales();
		printAllNumberFormatLocales();
		printAllDateFormatLocales();
		
		Locale default1Locale = Locale.getDefault();
		System.out.println("Default Locale:" + default1Locale);
		Locale.setDefault(Locale.US);
		
	}

	private static void printAllDateFormatLocales() {
		System.out.println("===== DATE FORMAT AVAILABLE LOCALES =====");
		for (Locale locale : DateFormat.getAvailableLocales()) {
			System.out.println(locale);
		}
		
	}

	private static void printAllNumberFormatLocales() {
		System.out.println("===== NUMBER FORMAT AVAILABLE LOCALES =====");
		for (Locale locale : NumberFormat.getAvailableLocales()) {
			System.out.println(locale);
		}
		
	}

	private static void printAllAvailableLocales() {
		System.out.println("===== ALL AVAILABLE LOCALES =====");
		for (Locale locale : Locale.getAvailableLocales()) {
			System.out.println(locale);
		}
	}

}

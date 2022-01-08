package com.itbulls.learnit.javacore.l18ni10n;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class L10NDemo {
	
	public static void main(String[] args) {
		double randomDoubleValue = 1236.45;
		
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		System.out.println("Number in USA:\t\t" + nf.format(randomDoubleValue));
		
		nf = NumberFormat.getInstance(new Locale("ru", "RU"));
		System.out.println("Number in Russia:\t" + nf.format(randomDoubleValue));
		
		nf = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println("Number in Germany:\t" + nf.format(randomDoubleValue));
		
		System.out.println("Money in USA:\t\t" + NumberFormat.getCurrencyInstance(Locale.US).format(randomDoubleValue));
		System.out.println("Money in Germany:\t" + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(randomDoubleValue));
		System.out.println("Money in Russia:\t" + NumberFormat.getCurrencyInstance(new Locale("ru", "RU")).format(randomDoubleValue));
		System.out.println("Money in India:\t\t" + NumberFormat.getCurrencyInstance(new Locale("hi", "IN")).format(randomDoubleValue));
		System.out.println("Money in UK:\t\t" + NumberFormat.getCurrencyInstance(Locale.UK).format(randomDoubleValue));
		
	    ZonedDateTime zoned = ZonedDateTime.now();
	    
	    DateTimeFormatter pattern = DateTimeFormatter
	    		.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
	    System.out.println("Date in USA:\t\t" + zoned.format(pattern));
	    
	    pattern = DateTimeFormatter
	    		.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMANY);
	    System.out.println("Date in Germany:\t" + zoned.format(pattern));
	    
	    pattern = DateTimeFormatter
	    		.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("ru", "RU"));
	    System.out.println("Date in Russia:\t\t" + zoned.format(pattern));
		
	}

}

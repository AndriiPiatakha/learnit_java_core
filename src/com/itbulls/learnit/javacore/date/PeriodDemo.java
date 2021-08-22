package com.itbulls.learnit.javacore.date;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {
	
	public static void main(String[] args) {
		LocalDate startDate = LocalDate.of(1995, 4, 11);
		LocalDate endDate = LocalDate.of(2000, 3, 18);

		Period period = Period.between(startDate, endDate);
		System.out.println("Period years: " + period.getYears() + ", months: " 
				+ period.getMonths() + ", days: " + period.getDays());
		
		
		Period fromUnits = Period.of(3, 10, 10);
		Period fromDays = Period.ofDays(50);
		Period fromMonths = Period.ofMonths(5);
		Period fromYears = Period.ofYears(10);
		Period fromWeeks = Period.ofWeeks(40);
		
		Period years = Period.parse("P5Y");
		System.out.println("years: " + years.getYears());

		Period days = Period.parse("P5Y2M10D");
		System.out.println("days: " + days.getDays());
	}

}

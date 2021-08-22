package com.itbulls.learnit.javacore.date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitDemo {

	public static void main(String[] args) {
		LocalDateTime oldDate = LocalDateTime.of(1982, Month.AUGUST, 31, 10, 20, 55);
		LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

		System.out.println(oldDate);
		System.out.println(newDate);

		// count between dates
		long years = ChronoUnit.YEARS.between(oldDate, newDate);
		long months = ChronoUnit.MONTHS.between(oldDate, newDate);
		long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
		long days = ChronoUnit.DAYS.between(oldDate, newDate);
		long hours = ChronoUnit.HOURS.between(oldDate, newDate);
		long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
		long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
		long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
		long nano = ChronoUnit.NANOS.between(oldDate, newDate);
	}

}

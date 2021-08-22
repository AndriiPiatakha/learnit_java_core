package com.itbulls.learnit.javacore.date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;


// 2016-05-16T10:15:30
public class LocalDateTimeDemo {

	public static void main(String[] args) {
		localDateTimeInstantiationExample();
		gettingInformationExample();
		addSubtractTimeExample();
	}

	private static void addSubtractTimeExample() {
		LocalDateTime localDT = LocalDateTime.parse("1981-10-18T10:20:45");
		System.out.println("LocalDateTime       : " + localDT);

		// Adding/subtracting days
		System.out.println("10 days before      : " + localDT.minusDays(10));
		System.out.println("15 days later       : " + localDT.plusDays(15));

		// Adding/subtracting months
		System.out.println("Minus 4 months      : " + localDT.minusMonths(4));
		System.out.println("Plus 5 months       : " + localDT.plusMonths(5));

		// Adding/subtracting weeks
		System.out.println("Minus 20 weeks      : " + localDT.minusWeeks(20));
		System.out.println("Plus 30 weeks       : " + localDT.plusWeeks(30));

		// Adding/subtracting years
		System.out.println("Minus 12 years      : " + localDT.minusYears(12));
		System.out.println("Plus 4 years        : " + localDT.plusYears(4));

		// Adding/subtracting hours
		System.out.println("12 hours before     : " + localDT.minusHours(12));
		System.out.println("6 hours later       : " + localDT.plusHours(6));

		// Adding/subtracting minutes
		System.out.println("Minus 40 minutes    : " + localDT.minusMinutes(40));
		System.out.println("Plus 15 minutes     : " + localDT.plusMinutes(15));

		// Adding/subtracting seconds
		System.out.println("Minus 30 seconds    : " + localDT.minusSeconds(30));
		System.out.println("Plus 20 seconds     : " + localDT.plusSeconds(20));

		// Adding/subtracting Nanos
		System.out.println("Minus 20000 nanos   : " + localDT.minusNanos(20000));
		System.out.println("Plus 340000 nanos   : " + localDT.plusNanos(340000));

		// Using DAYS
		System.out.println("30 days before      : " + localDT.minus(30, ChronoUnit.DAYS));
		// Using WEEKS
		System.out.println("3 weeks before      : " + localDT.minus(3, ChronoUnit.WEEKS));
		// Using MONTHS
		System.out.println("6 months later      : " + localDT.plus(6, ChronoUnit.MONTHS));
		// Using YEARS
		System.out.println("2 years later       : " + localDT.plus(2, ChronoUnit.YEARS));

		// Using HOURS
		System.out.println("8 hours before      : " + localDT.minus(8, ChronoUnit.HOURS));
		// Using MINUTES
		System.out.println("35 minutes before   : " + localDT.minus(35, ChronoUnit.MINUTES));
		// Using SECONDS
		System.out.println("125 seconds later   : " + localDT.plus(125, ChronoUnit.SECONDS));
		// Using NANOS
		System.out.println("42357500 nanos later: " + localDT.plus(42357500, ChronoUnit.NANOS));

		// Using TemporalAmount - Period
		System.out.println("5 years later       : " + localDT.plus(Period.ofYears(5)));
		// Using TemporalAmount - Duration
		System.out.println("60 days before      : " + localDT.minus(Duration.ofDays(60)));
		System.out.println("160 minutes before  : " + localDT.minus(Duration.ofMinutes(160)));
		System.out.println("2 hours later       : " + localDT.plus(Duration.ofHours(2)));
	}

	private static void gettingInformationExample() {
		LocalDateTime localDT = LocalDateTime.now();
		System.out.println("LocalDateTime   : " + localDT);
		System.out.println("DayOfMonth      : " + localDT.getDayOfMonth());
		System.out.println("MonthValue      : " + localDT.getMonthValue());
		System.out.println("Year            : " + localDT.getYear());

		System.out.println("Hour            : " + localDT.getHour());
		System.out.println("Minute          : " + localDT.getMinute());
		System.out.println("Second          : " + localDT.getSecond());
		System.out.println("Nano            : " + localDT.getNano());

		System.out.println("DayOfWeek       : " + localDT.getDayOfWeek());
		System.out.println("Month           : " + localDT.getMonth());
		System.out.println("DayOfYear       : " + localDT.getDayOfYear());

		System.out.println("DAY_OF_MONTH    : " + localDT.get(ChronoField.DAY_OF_MONTH));
		System.out.println("MONTH_OF_YEAR   : " + localDT.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("YEAR            : " + localDT.get(ChronoField.YEAR));

		System.out.println("HOUR_OF_DAY     : " + localDT.get(ChronoField.HOUR_OF_DAY));
		System.out.println("MINUTE_OF_HOUR  : " + localDT.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println("SECOND_OF_MINUTE: " + localDT.get(ChronoField.SECOND_OF_MINUTE));

		System.out.println("MINUTE_OF_DAY   : " + localDT.getLong(ChronoField.MINUTE_OF_DAY));
		System.out.println("SECOND_OF_DAY   : " + localDT.getLong(ChronoField.SECOND_OF_DAY));

		System.out.println("Chronology      : " + localDT.getChronology());

		System.out.println("toEpochSecond() : " + localDT.toEpochSecond(ZoneOffset.UTC));
	}

	private static void localDateTimeInstantiationExample() {
		LocalDateTime localDT1 = LocalDateTime.now();
		System.out.println("LocalDateTime1 : " + localDT1);

		LocalDateTime localDT2 = LocalDateTime.now(Clock.systemUTC());
		System.out.println("LocalDateTime2 : " + localDT2);

		LocalDateTime localDT3 = LocalDateTime.now(ZoneId.systemDefault());
		System.out.println("LocalDateTime3 : " + localDT3);

		LocalDateTime localDT4 = LocalDateTime.of(1980, 4, 9, 20, 15);
		System.out.println("LocalDateTime4 : " + localDT4);

		LocalDateTime localDT5 = LocalDateTime.of(1979, 12, 9, 18, 5, 50);
		System.out.println("LocalDateTime6 : " + localDT5);

		LocalDateTime localDT6 = LocalDateTime.of(1983, 7, 12, 20, 15, 50, 345678900);
		System.out.println("LocalDateTime8 : " + localDT6);

		LocalDateTime localDT7 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 50));
		System.out.println("LocalDateTime10: " + localDT7);

		LocalDateTime localDT8 = LocalDateTime.ofEpochSecond(1555552018, 456789500, ZoneOffset.UTC);
		System.out.println("LocalDateTime11: " + localDT8);

		LocalDateTime localDT9 = LocalDateTime.ofInstant(Instant.ofEpochMilli(324142255123L), ZoneId.systemDefault());
		System.out.println("LocalDateTime12: " + localDT9);

		LocalDateTime localDT10 = LocalDateTime.parse("1945-08-17T10:20:45");
		System.out.println("LocalDateTime13: " + localDT10);

		LocalDateTime localDT11 = LocalDateTime.parse("20190824155025", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		System.out.println("LocalDateTime14: " + localDT11);
	}

}

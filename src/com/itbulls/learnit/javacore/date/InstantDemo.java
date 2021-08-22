package com.itbulls.learnit.javacore.date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InstantDemo {

	public static void main(String[] args) {
		Instant instant1 = Instant.now();
		System.out.println("Instant1: " + instant1);

		Instant instant2 = Instant.now(Clock.systemUTC());
		System.out.println("Instant2: " + instant2);

		long now = System.currentTimeMillis();
		Instant instant3 = Instant.ofEpochMilli(now);
		System.out.println("Instant3: " + instant3);

		now = now / 1000;
		Instant instant4 = Instant.ofEpochSecond(now);
		System.out.println("Instant4: " + instant4);

		Instant instant5 = Instant.ofEpochSecond(now, 345000000);
		System.out.println("Instant5: " + instant5);

		// DateTimeFormatter.ISO_INSTANT - is used for parsing
		Instant instant6 = Instant.parse("1994-07-08T11:16:42.08Z");
		System.out.println("Instant6: " + instant6);

		Instant instant7 = new Date().toInstant();

		System.out.println("Convert instant to milliseconds: " + instant6.toEpochMilli());
		System.out.println("getEpochSecond(): " + instant1.getEpochSecond());
		System.out.println("getNano(): " + instant1.getNano());
		System.out.println("EpochSecond: " + instant1.getLong(ChronoField.INSTANT_SECONDS));
		System.out.println("Nano: " + instant1.get(ChronoField.NANO_OF_SECOND));

		addSubtractDemo();
		dateComparison();
		instantConversionExample();

	}

	private static void instantConversionExample() {
		Instant instant = Instant.parse("1997-05-07T10:15:30.00Z");

		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println("LocalDateTime : " + localDateTime);

		ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println("ZonedDateTime1: " + zonedDateTime1);

		ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println("ZonedDateTime2: " + zonedDateTime2);

		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.UTC);
		System.out.println("OffsetDateTime: " + offsetDateTime);

	}

	private static void dateComparison() {
		Instant instant1 = Instant.parse("1994-07-08T11:16:43.08Z");
		Instant instant2 = Instant.parse("1994-07-08T11:16:44.08Z");
		System.out.println("Instant1\t: " + instant1);
		System.out.println("Instant2\t: " + instant2);

		System.out.println("Instant1 after Instant2\t\t: " + instant1.isAfter(instant2));
		System.out.println("Instant1 before Instant2\t: " + instant1.isBefore(instant2));

		System.out.println("Instant1 compareTo Instant2:\t" + instant1.compareTo(instant2));
		System.out.println("Instant2 compareTo Instant1:\t" + instant2.compareTo(instant1));

		Calendar calendar1 = new GregorianCalendar(1013, 1, 28, 13, 24, 55);
		Calendar calendar2 = new GregorianCalendar(1013, 1, 28, 13, 24, 56);
		System.out.println("Calendar1 after Calendar2:\t" + calendar1.after(calendar2));
		System.out.println("Calendar1 before Calendar2:\t" + calendar1.before(calendar2));

		Date date1 = new Date(1090215021581L);
		Date date2 = new Date(1090215021582L);
		System.out.println("Date1 after Date2:\t" + date1.after(date2));
		System.out.println("Date1 before Date2:\t" + date1.before(date2));

	}

	private static void addSubtractDemo() {
		Instant instant = Instant.parse("1984-08-13T10:15:30.345Z");
		System.out.println("Instant             : " + instant);

		// Adding/subtracting seconds
		System.out.println("15 seconds before   : " + instant.minusSeconds(15));
		System.out.println("10 seconds after    : " + instant.plusSeconds(10));

		// Adding/subtracting millis
		System.out.println("Minus 45000 millis  : " + instant.minusMillis(45000));
		System.out.println("Plus 10000 millis   : " + instant.plusMillis(10000));

		// Adding/subtracting nanos
		System.out.println("Minus 45123456 nanos: " + instant.minusNanos(45123456));
		System.out.println("Plus 111234567 nanos: " + instant.plusNanos(111234567));

		// Using MINUTES
		System.out.println("45 minutes before   : " + instant.minus(45, ChronoUnit.MINUTES));
		// Using HOURS
		System.out.println("3 hours before      : " + instant.minus(3, ChronoUnit.HOURS));
		// Using MILLIS also supported
		System.out.println("30000 millis later  : " + instant.plus(30000, ChronoUnit.MILLIS));
		// Using DAYS
		System.out.println("10 days later       : " + instant.plus(10, ChronoUnit.DAYS));

		// Using TemporalAmount - Duration
		System.out.println("10 seconds before   : " + instant.minus(Duration.ofSeconds(10)));
		// Using TemporalAmount - Period
		System.out.println("5 days later        : " + instant.plus(Period.ofDays(5)));
	}

}

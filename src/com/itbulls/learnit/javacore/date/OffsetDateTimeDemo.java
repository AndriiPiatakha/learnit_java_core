package com.itbulls.learnit.javacore.date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

// 1980-04-09T10:15:30+07:00
public class OffsetDateTimeDemo {

	public static void main(String[] args) {
		offsetDateTimeInstantiationExample();
		gettingInformationExample();
		conversionExample();
		addSubtractTimeExample();
	}

	private static void addSubtractTimeExample() {
		OffsetDateTime offsetDT = OffsetDateTime.parse("1983-07-12T06:30:15+07:00");
        System.out.println("OffsetDateTime      : " + offsetDT);
        
        // Adding/subtracting days
        System.out.println("10 days before      : " + offsetDT.minusDays(10));
        System.out.println("15 days later       : " + offsetDT.plusDays(15));
        
        // Adding/subtracting months
        System.out.println("Minus 4 months      : " + offsetDT.minusMonths(4));
        System.out.println("Plus 5 months       : " + offsetDT.plusMonths(5));
        
        // Adding/subtracting weeks
        System.out.println("Minus 20 weeks      : " + offsetDT.minusWeeks(20));
        System.out.println("Plus 30 weeks       : " + offsetDT.plusWeeks(30));
        
        // Adding/subtracting years
        System.out.println("Minus 12 years      : " + offsetDT.minusYears(12));
        System.out.println("Plus 4 years        : " + offsetDT.plusYears(4));
        
        // Adding/subtracting hours
        System.out.println("12 hours before     : " + offsetDT.minusHours(12));
        System.out.println("6 hours later       : " + offsetDT.plusHours(6));
        
        // Adding/subtracting minutes
        System.out.println("Minus 40 minutes    : " + offsetDT.minusMinutes(40));
        System.out.println("Plus 15 minutes     : " + offsetDT.plusMinutes(15));
        
        // Adding/subtracting seconds
        System.out.println("Minus 30 seconds    : " + offsetDT.minusSeconds(30));
        System.out.println("Plus 20 seconds     : " + offsetDT.plusSeconds(20));
        
        // Adding/subtracting Nanos
        System.out.println("Minus 20000 nanos   : " + offsetDT.minusNanos(20000));
        System.out.println("Plus 340000 nanos   : " + offsetDT.plusNanos(340000));
        
        // Using DAYS
        System.out.println("30 days before      : " + offsetDT.minus(30, ChronoUnit.DAYS));
        // Using WEEKS
        System.out.println("3 weeks before      : " + offsetDT.minus(3, ChronoUnit.WEEKS));
        // Using MONTHS
        System.out.println("6 months later      : " + offsetDT.plus(6, ChronoUnit.MONTHS));
        // Using YEARS
        System.out.println("2 years later       : " + offsetDT.plus(2, ChronoUnit.YEARS));
        
        // Using HOURS
        System.out.println("8 hours before      : " + offsetDT.minus(8, ChronoUnit.HOURS));
        // Using MINUTES
        System.out.println("35 minutes before   : " + offsetDT.minus(35, ChronoUnit.MINUTES));
        // Using SECONDS
        System.out.println("125 seconds later   : " + offsetDT.plus(125, ChronoUnit.SECONDS));
        // Using NANOS
        System.out.println("42357500 nanos later: " + offsetDT.plus(42357500, ChronoUnit.NANOS));
        
        // Using TemporalAmount - Duration 
        System.out.println("60 days before      : " + offsetDT.minus(Duration.ofDays(60)));
        System.out.println("160 minutes before  : " + offsetDT.minus(Duration.ofMinutes(160)));
        System.out.println("2 hours later       : " + offsetDT.plus(Duration.ofHours(2)));
        
        // Using TemporalAmount - Period 
        System.out.println("5 years before      : " + offsetDT.minus(Period.ofYears(5)));
        System.out.println("8 months later      : " + offsetDT.plus(Period.ofMonths(8)));
	}

	private static void conversionExample() {
		OffsetDateTime offsetDT = OffsetDateTime.now();
		
		System.out.println("toEpochSecond()  : " + offsetDT.toEpochSecond());
		System.out.println("toInstant()      : " + offsetDT.toInstant());
		System.out.println("toLocalDate()    : " + offsetDT.toLocalDate());
		System.out.println("toLocalDateTime(): " + offsetDT.toLocalDateTime());
		System.out.println("toLocalTime()    : " + offsetDT.toLocalTime());
		System.out.println("toZonedDateTime(): " + offsetDT.toZonedDateTime());		
	}

	private static void gettingInformationExample() {
		OffsetDateTime offsetDT = OffsetDateTime.now();
		System.out.println("OffsetDateTime   : " + offsetDT);
		System.out.println("DayOfMonth       : " + offsetDT.getDayOfMonth());
		System.out.println("MonthValue       : " + offsetDT.getMonthValue());
		System.out.println("Year             : " + offsetDT.getYear());

		System.out.println("Hour             : " + offsetDT.getHour());
		System.out.println("Minute           : " + offsetDT.getMinute());
		System.out.println("Second           : " + offsetDT.getSecond());
		System.out.println("Nano             : " + offsetDT.getNano());

		System.out.println("DayOfWeek        : " + offsetDT.getDayOfWeek());
		System.out.println("Month            : " + offsetDT.getMonth());
		System.out.println("DayOfYear        : " + offsetDT.getDayOfYear());

		System.out.println("DAY_OF_MONTH     : " + offsetDT.get(ChronoField.DAY_OF_MONTH));
		System.out.println("MONTH_OF_YEAR    : " + offsetDT.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("YEAR             : " + offsetDT.get(ChronoField.YEAR));

		System.out.println("HOUR_OF_DAY      : " + offsetDT.get(ChronoField.HOUR_OF_DAY));
		System.out.println("MINUTE_OF_HOUR   : " + offsetDT.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println("SECOND_OF_MINUTE : " + offsetDT.get(ChronoField.SECOND_OF_MINUTE));

		System.out.println("MINUTE_OF_DAY    : " + offsetDT.getLong(ChronoField.MINUTE_OF_DAY));
		System.out.println("SECOND_OF_DAY    : " + offsetDT.getLong(ChronoField.SECOND_OF_DAY));

		System.out.println("Offset           : " + offsetDT.getOffset());


	}

	private static void offsetDateTimeInstantiationExample() {
		OffsetDateTime offsetDT1 = OffsetDateTime.now();
		System.out.println("OffsetDateTime1: " + offsetDT1);

		OffsetDateTime offsetDT2 = OffsetDateTime.now(Clock.systemUTC());
		System.out.println("OffsetDateTime2: " + offsetDT2);

		OffsetDateTime offsetDT3 = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
		System.out.println("OffsetDateTime3: " + offsetDT3);

		OffsetDateTime offsetDT4 = OffsetDateTime.of(1980, 4, 9, 20, 15, 45, 345875000, ZoneOffset.of("+07:00"));
		System.out.println("OffsetDateTime4: " + offsetDT4);

		OffsetDateTime offsetDT5 = OffsetDateTime.of(LocalDate.now(), LocalTime.of(15, 50, 25),
				ZoneOffset.of("+07:00"));
		System.out.println("OffsetDateTime5: " + offsetDT5);

		OffsetDateTime offsetDT6 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+07:00"));
		System.out.println("OffsetDateTime6: " + offsetDT6);

		OffsetDateTime offsetDT7 = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println("OffsetDateTime7: " + offsetDT7);

		OffsetDateTime offsetDT8 = OffsetDateTime.parse("2019-08-31T15:20:30+08:00");
		System.out.println("OffsetDateTime8: " + offsetDT8);

		OffsetDateTime offsetDT9 = OffsetDateTime.parse("1980-04-09T08:20:45+07:00",
				DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		System.out.println("OffsetDateTime9: " + offsetDT9);
	}

}

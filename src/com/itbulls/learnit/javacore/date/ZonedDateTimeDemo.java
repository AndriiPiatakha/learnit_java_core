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
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

// 2016-05-16T10:15:30+01:00 Asia/Singapore
public class ZonedDateTimeDemo {

	public static void main(String[] args) {
		zonedDateTimeInstantiationExample();
		gettingInformationExample();
		conversionExample();
		addSubtractTimeExample();
	}

	private static void addSubtractTimeExample() {
		ZonedDateTime zonedDT = ZonedDateTime.parse("1984-08-13T18:30:15+08:00[Asia/Singapore]");
        System.out.println("ZonedDateTime       : " + zonedDT);
        
        // Adding/subtracting days
        System.out.println("10 days before      : " + zonedDT.minusDays(10));
        System.out.println("15 days later       : " + zonedDT.plusDays(15));
        
        // Adding/subtracting months
        System.out.println("Minus 4 months      : " + zonedDT.minusMonths(4));
        System.out.println("Plus 5 months       : " + zonedDT.plusMonths(5));
        
        // Adding/subtracting weeks
        System.out.println("Minus 20 weeks      : " + zonedDT.minusWeeks(20));
        System.out.println("Plus 30 weeks       : " + zonedDT.plusWeeks(30));
        
        // Adding/subtracting years
        System.out.println("Minus 12 years      : " + zonedDT.minusYears(12));
        System.out.println("Plus 4 years        : " + zonedDT.plusYears(4));
        
        // Adding/subtracting hours
        System.out.println("12 hours before     : " + zonedDT.minusHours(12));
        System.out.println("6 hours later       : " + zonedDT.plusHours(6));
        
        // Adding/subtracting minutes
        System.out.println("Minus 40 minutes    : " + zonedDT.minusMinutes(40));
        System.out.println("Plus 15 minutes     : " + zonedDT.plusMinutes(15));
        
        // Adding/subtracting seconds
        System.out.println("Minus 30 seconds    : " + zonedDT.minusSeconds(30));
        System.out.println("Plus 20 seconds     : " + zonedDT.plusSeconds(20));
        
        // Adding/subtracting Nanos
        System.out.println("Minus 20000 nanos   : " + zonedDT.minusNanos(20000));
        System.out.println("Plus 340000 nanos   : " + zonedDT.plusNanos(340000));
        
        // Using DAYS
        System.out.println("30 days before      : " + zonedDT.minus(30, ChronoUnit.DAYS));
        // Using WEEKS
        System.out.println("3 weeks before      : " + zonedDT.minus(3, ChronoUnit.WEEKS));
        // Using MONTHS
        System.out.println("6 months later      : " + zonedDT.plus(6, ChronoUnit.MONTHS));
        // Using YEARS
        System.out.println("2 years later       : " + zonedDT.plus(2, ChronoUnit.YEARS));
        
        // Using HOURS
        System.out.println("8 hours before      : " + zonedDT.minus(8, ChronoUnit.HOURS));
        // Using MINUTES
        System.out.println("35 minutes before   : " + zonedDT.minus(35, ChronoUnit.MINUTES));
        // Using SECONDS
        System.out.println("125 seconds later   : " + zonedDT.plus(125, ChronoUnit.SECONDS));
        // Using NANOS
        System.out.println("42357500 nanos later: " + zonedDT.plus(42357500, ChronoUnit.NANOS));
        
        // Using TemporalAmount - Period 
        System.out.println("5 years later       : " + zonedDT.plus(Period.ofYears(5)));
        // Using TemporalAmount - Duration 
        System.out.println("60 days before      : " + zonedDT.minus(Duration.ofDays(60)));
        System.out.println("160 minutes before  : " + zonedDT.minus(Duration.ofMinutes(160)));
        System.out.println("2 hours later       : " + zonedDT.plus(Duration.ofHours(2)));        
    }
		
	private static void conversionExample() {
		ZonedDateTime zonedDT = ZonedDateTime.now();
		
		System.out.println("toEpochSecond()   : " + zonedDT.toEpochSecond());
		System.out.println("toInstant()       : " + zonedDT.toInstant());
		System.out.println("toLocalDate()     : " + zonedDT.toLocalDate());
		System.out.println("toLocalDateTime() : " + zonedDT.toLocalDateTime());
		System.out.println("toLocalTime()     : " + zonedDT.toLocalTime());
		System.out.println("toOffsetDateTime(): " + zonedDT.toOffsetDateTime());
	}
	
	private static void gettingInformationExample() {
		ZonedDateTime zonedDT = ZonedDateTime.now();
		System.out.println("ZonedDateTime     : " + zonedDT);
		System.out.println("DayOfMonth        : " + zonedDT.getDayOfMonth());
		System.out.println("MonthValue        : " + zonedDT.getMonthValue());
		System.out.println("Year              : " + zonedDT.getYear());

		System.out.println("Hour              : " + zonedDT.getHour());
		System.out.println("Minute            : " + zonedDT.getMinute());
		System.out.println("Second            : " + zonedDT.getSecond());
		System.out.println("Nano              : " + zonedDT.getNano());

		System.out.println("DayOfWeek         : " + zonedDT.getDayOfWeek());
		System.out.println("Month             : " + zonedDT.getMonth());
		System.out.println("DayOfYear         : " + zonedDT.getDayOfYear());

		System.out.println("DAY_OF_MONTH      : " + zonedDT.get(ChronoField.DAY_OF_MONTH));
		System.out.println("MONTH_OF_YEAR     : " + zonedDT.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("YEAR              : " + zonedDT.get(ChronoField.YEAR));

		System.out.println("HOUR_OF_DAY       : " + zonedDT.get(ChronoField.HOUR_OF_DAY));
		System.out.println("MINUTE_OF_HOUR    : " + zonedDT.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println("SECOND_OF_MINUTE  : " + zonedDT.get(ChronoField.SECOND_OF_MINUTE));

		System.out.println("MINUTE_OF_DAY     : " + zonedDT.getLong(ChronoField.MINUTE_OF_DAY));
		System.out.println("SECOND_OF_DAY     : " + zonedDT.getLong(ChronoField.SECOND_OF_DAY));

		System.out.println("Chronology        : " + zonedDT.getChronology());

	}

	private static void zonedDateTimeInstantiationExample() {
		ZonedDateTime zonedDT1 = ZonedDateTime.now();
		System.out.println("ZonedDateTime1 : " + zonedDT1);

		ZonedDateTime zonedDT2 = ZonedDateTime.now(Clock.systemUTC());
		System.out.println("ZonedDateTime2 : " + zonedDT2);

		ZonedDateTime zonedDT3 = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
		System.out.println("ZonedDateTime3 : " + zonedDT3);

		ZonedDateTime zonedDT4 = ZonedDateTime.of(1980, 4, 9, 20, 15, 45, 345875000, ZoneId.systemDefault());
		System.out.println("ZonedDateTime4 : " + zonedDT4);

		ZonedDateTime zonedDT5 = ZonedDateTime.of(LocalDate.now(), LocalTime.of(15, 50, 25), ZoneId.systemDefault());
		System.out.println("ZonedDateTime5 : " + zonedDT5);

		ZonedDateTime zonedDT6 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
		System.out.println("ZonedDateTime6 : " + zonedDT6);

		ZonedDateTime zonedDT7 = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println("ZonedDateTime7 : " + zonedDT7);

		ZonedDateTime zonedDT8 = ZonedDateTime.ofInstant(LocalDateTime.now(), ZoneOffset.UTC, ZoneId.systemDefault());
		System.out.println("ZonedDateTime8 : " + zonedDT8);

		ZonedDateTime zonedDT9 = ZonedDateTime.ofLocal(LocalDateTime.now(), ZoneId.systemDefault(), ZoneOffset.UTC);
		System.out.println("ZonedDateTime9 : " + zonedDT9);

		ZonedDateTime zonedDT10 = ZonedDateTime.ofStrict(LocalDateTime.now(), ZoneOffset.ofHours(8),
				ZoneId.of("Asia/Singapore"));
		System.out.println("ZonedDateTime10: " + zonedDT10);

		ZonedDateTime zonedDT11 = ZonedDateTime.parse("2017-10-10T18:30:45+01:00[Europe/London]");
		System.out.println("ZonedDateTime11: " + zonedDT11);

		ZonedDateTime zonedDT12 = ZonedDateTime.parse("2018-04-22T08:40:15+10:00[Australia/Sydney]",
				DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("ZonedDateTime12: " + zonedDT12);
	}

}

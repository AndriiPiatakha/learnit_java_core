package com.itbulls.learnit.javacore.date;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationDemo {
	
	public static void main(String[] args) {
		Instant start = Instant.parse("1995-04-11T12:27:42.00Z");
		Instant end = Instant.parse("2000-03-18T04:37:12.00Z");
		        
		Duration duration = Duration.between(start, end);
		System.out.println("duration seconds: " + duration.getSeconds());
		
		Duration fromDays = Duration.ofDays(1);
		System.out.println(fromDays.getSeconds());
		       
		Duration fromMinutes = Duration.ofHours(60);
		System.out.println(fromMinutes.get(ChronoUnit.SECONDS));
		
		Duration fromChar1 = Duration.parse("P1DT1H10M10.5S");
		Duration fromChar2 = Duration.parse("PT10M");
		System.out.println(fromChar1.getSeconds());
		System.out.println(fromChar2.getSeconds());
		
	}

}

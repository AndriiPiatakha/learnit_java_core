package com.itbulls.learnit.javacore.date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class ClockDemo {

	public static void main(String[] args) {
		Clock clock = Clock.systemDefaultZone();
		Instant instant = clock.instant();
		System.out.println(instant);

		Clock clock2 = Clock.systemUTC();
		System.out.println("UTC time: " + clock2.instant());

		Clock clock3 = Clock.system(ZoneId.of("America/Los_Angeles"));
		System.out.println(clock3.instant());

		Clock clock4 = Clock.systemDefaultZone();
		System.out.println(clock4);
		System.out.println(clock4.millis());

		Clock clock5 = Clock.system(ZoneId.systemDefault());
		System.out.println(clock5);

		Clock fixedClock = Clock.fixed(Instant.parse("2000-07-25T11:16:24.00Z"), 
				ZoneId.of("America/Los_Angeles"));
		System.out.println(fixedClock);

		Clock baseClock = Clock.systemDefaultZone();

		// result clock will be later than baseClock
		Clock clock6 = Clock.offset(baseClock, Duration.ofHours(72));
		System.out.println(clock6.instant());

		// result clock will be same as baseClock
		clock6 = Clock.offset(baseClock, Duration.ZERO);
		System.out.println(clock6.instant());

		// result clock will be earlier than baseClock
		clock6 = Clock.offset(baseClock, Duration.ofHours(-72));
		System.out.println(clock6.instant());
	}

}

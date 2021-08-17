package com.itbulls.learnit.javacore.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Demo {

	public static void main(String[] args) throws ParseException {
		calendarExample();
		
		System.out.println("================================");
		
		simpleDateFormatExample();
		
		System.out.println("================================");
		
		dateExample();
		
		System.out.println("================================");
		
		timeZoneExample();
		
		System.out.println("================================");
		
		zoneIdExample();
		
		System.out.println("================================");
		
		convertDateCalender();
		
	}

	


	private static void dateExample() throws ParseException {
		Date date = new Date(1988, 2, 1);
		Date date2 = new Date();
		Date date3 = new Date(1895215322137621581L);
	
		System.out.println(date3);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		Date dateParsed = sdf.parse("1999/01/10 10:02:02");
		System.out.println(dateParsed);
		
		String dateString = sdf.format(dateParsed);
		System.out.println(dateString);
		
	}


	public static void simpleDateFormatExample() throws ParseException {
		Calendar calendar = new GregorianCalendar(1013, 1, 28, 13, 24, 56);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		System.out.println(sdf.format(calendar.getTime()));
		
		sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss", Locale.US);
		System.out.println(sdf.format(calendar.getTime()));
		
		sdf = new SimpleDateFormat("yy M dd HH:mm:ss", Locale.US);
		System.out.println(sdf.format(calendar.getTime()));
	}
	
	
	public static void timeZoneExample() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date date = new Date(1090215021581L);
		System.out.println(sdf.format(date));
		
		sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("+1")));
		System.out.println(sdf.format(date));
	}
	


	public static void calendarExample() {
		
		Calendar calendar = new GregorianCalendar(1988, 1, 28, 13, 24, 56);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR); // 12 hour clock
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		
		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);
		
	}
	
	
	public static void zoneIdExample() {
		ZoneId.getAvailableZoneIds().stream()
				.forEach(System.out::println);
	}

	
	public static void convertDateCalender() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "22-01-2015 10:20:56";
		Date date = sdf.parse(dateInString);
		System.out.println("Date: " + date);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		date = calendar.getTime();
		System.out.println("Date converted from Calendar: " + date);
	}

}

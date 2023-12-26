package com.zettamine.day07;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DataTimeDemo {
	
	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis());
		
		LocalDate localDate = LocalDate.parse("2012-12-20");
		System.out.println("Local date formatting "+localDate.format(DateTimeFormatter.ofPattern("dd/MMMM/yy")));
		System.out.println(localDate);
		System.out.println(LocalDate.MIN);
		System.out.println(LocalDate.MAX);
		System.out.println(LocalDate.EPOCH); 
		System.out.println(LocalDate.of(99, 2,1));
		System.out.println("plus operation "+LocalDate.now().plusDays(60));
		System.out.println("period operation "+LocalDate.now().plus(Period.ofDays(15)));
		System.out.println("minus opearation"+LocalDate.now().plus(1,ChronoUnit.CENTURIES));
		System.out.println("day of month "+LocalDate.now().getDayOfMonth());
		System.out.println("day of week "+LocalDate.now().getDayOfWeek());
		System.out.println("is leap year "+LocalDate.now().plusDays(30).isLeapYear());
		System.out.println("is befor "+LocalDate.now().isBefore(LocalDate.now().minus(1,ChronoUnit.DAYS)));
		System.out.println("is After "+LocalDate.now().isAfter(LocalDate.now().minus(1,ChronoUnit.DAYS)));
		LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
		LocalDate firstDayOfMonth = LocalDate.parse("2016-12-12")
		  .with(TemporalAdjusters.firstDayOfMonth());
		
		System.out.println(beginningOfDay);
		System.out.println(firstDayOfMonth);
		System.out.println("-".repeat(30));
		
		//Difference Between Two Dates
		
		LocalDate localD = LocalDate.of(2021, 03, 20);
		LocalDate dateInNextWeek = localD.plusDays(7)
											//.plus(7,ChronoUnit.DAYS)
											//.plus(Period.ofDays(7))
												;
		int dateDiff = Period.between(localD, dateInNextWeek).getDays();
		System.out.println(dateDiff);
		
		//OR
		
		long dayDiff = ChronoUnit.DAYS.between(localD, dateInNextWeek);
		System.out.println(dayDiff);
		
		//Get Specific Dates
		LocalDate localDateWithFirstDate = localD.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(localDateWithFirstDate);
		localDateWithFirstDate = localD.with(TemporalAdjusters.lastDayOfYear())
										.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(localDateWithFirstDate);
		localDateWithFirstDate = localD.withDayOfMonth(20);
		System.out.println(localDateWithFirstDate);
		
		// Local Time
		System.out.println("Local Time now "+LocalTime.now());
		System.out.println("Local time with of "+LocalTime.of(23,59,0));
		System.out.println("Local time with parse "+LocalTime.parse("06:00:07").plus(1,ChronoUnit.HOURS));
		
		//LocalTime Format into Custom Pattern
		
		LocalTime localTime = LocalTime.of(00,2,3);
		System.out.println("local time in format : "+localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
		
		
		//Time After Specific Time Period
		System.out.println("plus operation on time : "+localTime.plus(Duration.ofHours(3))
																//.plusHours(3)
																//.plus(3,ChronoUnit.HOURS)
																);
		
		//Local DateTime
		
		LocalDateTime localDateTime = LocalDateTime.of(2021, Month.MARCH, 27, 9, 30);
		System.out.println("localDateTime : " + localDateTime);
		
		LocalDateTime localDateTimeParsed = LocalDateTime.parse("2021-03-20T09:30:00");
		System.out.println("localDateTimeParsed : " + localDateTimeParsed);
		
		//Format into Custom Format
		String localDateTimeFormatted = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"));
		System.out.println("localDateTimeFormatted : " + localDateTimeFormatted);
		
		
		
		
	}

}

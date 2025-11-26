package com.nov_25.nov_25;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DemoOnZonedDateAndTime {

	public static void main(String[] args) {
		ZonedDateTime dateTime = ZonedDateTime.now();
		System.out.println(dateTime);
		System.out.println(dateTime.getOffset());
		System.out.println(dateTime.getZone());
		ZonedDateTime usaDate = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(usaDate);

		int secondDiff = dateTime.getOffset().getTotalSeconds() - usaDate.getOffset().getTotalSeconds();
		int hours = secondDiff / 3600;
		int min = (secondDiff % 3600) / 60;
		System.out.println("Diff is : " + hours + " : " + min + "minutes");
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Kolkata"));
		System.out.println(zonedDateTime);

		// convert Indian Time to USA
		ZonedDateTime indiaTimeZone = ZonedDateTime.now();
		ZonedDateTime usaTimeZone = indiaTimeZone.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(indiaTimeZone);
		System.out.println(usaTimeZone);

		// print zonedatetime in the specific pattern

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a z");
		String formatedZonedDateTime = indiaTimeZone.format(df);
		System.out.println(formatedZonedDateTime);

		System.out.println(dateTime.format(df));

	}

}

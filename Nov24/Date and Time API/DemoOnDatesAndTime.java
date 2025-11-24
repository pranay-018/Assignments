
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
//import java.util.Date;

public class DemoOnDatesAndTime {
	public static void main(String[] args) {
		// first Date = 1-1-1970;
		// Localdate from    https://www.baeldung.com/java-8-date-time-intro#bd-formatting
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate tommorrow = LocalDate.now().plusDays(1);
		System.out.println(tommorrow);

		LocalDate previosMonthSameDate = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println(previosMonthSameDate);

		DayOfWeek day = LocalDate.parse("2016-06-12").getDayOfWeek();
		System.out.println(day);

		int date = LocalDate.parse("2025-04-08").getDayOfMonth();
		System.out.println(date);

		System.out.println(LocalDate.now().isLeapYear());

		System.out.println(LocalDate.parse("2023-10-25").isAfter(LocalDate.parse("2025-11-24")));

		LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
		System.out.println(beginningOfDay); // 00:00 as time for date 2016-06-12

		LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDayOfMonth); // get first Day of Month
		// local time
		LocalTime now = LocalTime.now();
		System.out.println(now);

		LocalTime sixThirty = LocalTime.parse("06:30");

		System.out.println(sixThirty);
		LocalTime sixThirty2 = LocalTime.of(6, 30);
		System.out.println(sixThirty2);
		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		System.out.println(sevenThirty);

		int six = LocalTime.parse("06:30").getHour();
		System.out.println(six);

		System.out.println(LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30")));

		LocalTime maxTime = LocalTime.MAX;
		System.out.println(maxTime);
		// localDateTime
		System.out.println(LocalDateTime.now());
		LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
		LocalDateTime.parse("2015-02-20T06:30:00");
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime.plusDays(1);
		localDateTime.minusHours(2);
		localDateTime.getMonth();

		ZoneId zoneId = ZoneId.of("Europe/Paris");
		System.out.println(zoneId);
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds);

		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println(zonedDateTime);
		
		
		ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
		
		
//		https://www.tpointtech.com/java-date -- check refernces
//		Date currDate = new Date();
//		long ms = System.currentTimeMillis();
//		System.out.println(ms);
//		Date currDateOfMS = new Date(ms);
//		System.out.println(currDateOfMS);
//
//		long msl = 1839569990123l;
//		Date dateWithMSL = new Date(msl);
//		System.out.println(dateWithMSL);
//
//		Date newDate = new Date(2025 - 1900, 10, 24);
//		System.out.println(newDate); // doubt
//
//		// adding date
//		System.out.println(currDate.getDate() + 3);
//		System.out.println(currDate.getDay());
//		System.out.println(currDate.getYear() + 1900);
//
//		Date d1 = new Date(2025, 01, 24);
//		Date d2 = new Date(2023, 01, 24);
//		System.out.println(d2.after(d1)); // false reverse is true
//
//		// formating date
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//
//		System.out.println(sdf.format(currDate));
//
//		// converting string to date
//		String str = "24-11-2024";
//		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
////		Date d = sdf2.format(str);
////		System.out.println(d); error
//
//		Date dob = new Date(2002 - 1900, 10, 04);
//		Date today2 = new Date();
//		int ageInYears = today2.getYear() - dob.getYear();
//		System.out.println(ageInYears);

		// sqldate
//		Date date2 = new Date(2025 - 1900, 10, 24);
//		System.out.println(date2); // only date no time
//		System.out.println(new java.util.Date()); // print includeing with time
//		// conversion between util.date to sql.date
//		java.util.Date util_date = new java.util.Date();
//		Date sql_date = new Date(util_date.getDate()-1900);
//		System.out.println(util_date);
//		System.out.println(sql_date);

	}
}

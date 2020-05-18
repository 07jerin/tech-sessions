package com.jerin.presentation.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class FormatingDates {
	
	public static void main(String[] args) {
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
		System.out.println("DateTimeFormatter Date : " + df.format(currentDate));
		
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter dfTimeFormatter = DateTimeFormatter.ISO_TIME;
		System.out.println("DateTimeFormatter LocalTime : " + dfTimeFormatter.format(currentTime));
		
		
		LocalDateTime currentDT = LocalDateTime.now();
		DateTimeFormatter dtTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println("DateTimeFormatter LocalDateTime : " + dtTimeFormatter.format(currentDT));
		
		DateTimeFormatter f_long = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println("DateTimeFormatter LONG : " + f_long.format(currentDT));
			
		//Use the locales
		String fr_short = f_long.withLocale(Locale.FRANCE).format(currentDT);
		System.out.println("French locale formatted Date : " +fr_short);
		
		//Custom Date Time formatter using the builder
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
												.appendValue(ChronoField.DAY_OF_MONTH)
												.appendLiteral("-:-")
												.appendValue(ChronoField.MONTH_OF_YEAR)
												.appendLiteral("-:-")
												.appendValue(ChronoField.YEAR);
												
		DateTimeFormatter custom = builder.toFormatter(Locale.FRANCE);
		System.out.println("Custom Formatted Date : " +custom.format(currentDT));
		
												
	}
}

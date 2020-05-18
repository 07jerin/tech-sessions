package com.jerin.presentation.dateandtime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BasicClasses {

	public static void main(String[] args) {
		
		Instant start = Instant.now();
		System.out.println("Instant " + start);
		Instant end = Instant.now();
		
		Duration duration = Duration.between(start, end);
		System.out.println("Duration " + duration); // The format is ISO formatted
		System.out.println("Duration in ms : "+ duration.toMillis());
		
		
		
		/**LOCAL DATE. LOCAL TIME. LOCAL DATE TIME **/
		// There is consistency in the syntax for all these
		LocalDate date = LocalDate.now();
		System.out.println("Local Date : " + date);
		LocalTime time = LocalTime.now();
		System.out.println("LocalTime  : " + time);
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("LocalDateTime : " + dateTime);
		
		//Specific Date
		LocalDate specificDate = LocalDate.of(2000, 2, 20);  // here month starts from 1 and not from 0 
		System.out.println("Specfic Date : " + specificDate);
		
		LocalTime specificTime = LocalTime.of(2, 30);
		System.out.println("Specfic Time : " + specificTime);
		
		LocalDateTime specificDateTime = LocalDateTime.of(specificDate, specificTime);
		System.out.println("Specfic Date Time : " + specificDateTime);
	}
}

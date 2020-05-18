package com.jerin.presentation.stream;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.common.Utility;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class Aggregating {

	
	public static void main(String[] args) {
		
//		
//		Stream<Integer> stream =  Stream.of(Utility.integerArray());
//		stream.forEach(System.out :: println);
		
		
		
		/** COUNT **/
//		System.out.println(stream.count());
		
		//SUM 
//		System.out.println(stream
//				.mapToInt(val -> val).sum());
		
		Stream<Person> personStream = PersonInterface.getSamplePersons().stream();
//		Stream<Person> personStream = new ArrayList().stream();
		
//		/** SUM **/
//		int totalAge = personStream
//						.mapToInt( person -> person.getAge()) //Stream of integers
//						.sum();
//		System.out.println(totalAge);
		
		
		/** AVERAGE **/
		OptionalDouble average = personStream
				.mapToInt( person -> person.getAge()) //Stream of integers
				.average();
		System.out.println(average.orElse(0));
		
	}
}

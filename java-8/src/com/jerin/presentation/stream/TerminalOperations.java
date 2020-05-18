package com.jerin.presentation.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class TerminalOperations {
	
	static List<Person> persons = PersonInterface.getSamplePersons();
	public static void main(String[] args) {
		
		persons.forEach(System.out :: println);
		
		System.out.println("********************************************************************");
		
		matching();
		
		System.out.println("********************************************************************");
		finding();
		
		System.out.println("********************************************************************");
		reduce();
		
		
	}
	
	public static void matching(){
		
		Predicate<Person> ageGT50Predicate = (p) -> p.getAge() > 50; 
		
		Boolean anyMatch = persons.stream().anyMatch(ageGT50Predicate);
		Boolean allMatch = persons.stream().allMatch(ageGT50Predicate);
		Boolean noneMatch = persons.stream().noneMatch(ageGT50Predicate);
		
		System.out.println("Matching results  -- anyMatch : " +anyMatch+
							"     allMatch : " +allMatch+
							"     noneMatch : " +noneMatch);
		
	}
	
	public static void finding(){
		
		Stream<Person> personStream = persons.stream().parallel()
											.sorted((p1, p2) -> p1.getAge().compareTo(p2.getAge())); 
		Optional<Person> youngestPerson = personStream.findFirst();
		System.out.println("Youngest Person is : " + youngestPerson.get());
		
//		System.out.println( "Finding Any : " + persons.stream().parallel()
//				.findAny().get());
//		
		
	}
	
	public static void reduce(){
		
		Optional<Integer> sum1 = persons.stream()
				.map(p -> p.getAge())
				.reduce((age1, age2) -> age1 + age2);
		System.out.println("Sum of Ages without fold  " + sum1.get());
		
		
		Integer sum = persons.stream()
				.map(p -> p.getAge())
				.reduce(500,(age1, age2) -> age1 + age2);
		
		System.out.println("Sum of Ages with 500 as fold  " + sum);
		
//		sum = persons.stream()
//				.map(p -> p.getAge())
//				.filter(age -> age > 10000)
//				.reduce(500,(age1, age2) -> age1 + age2);
//		
//		System.out.println("Sum of Ages > 10000 with 500 as fold  " + sum);
		
		//If Value is not present and we do not provide  fold condition we will get error
//		sum1 = persons.stream()
//							.map(p -> p.getAge())
//							.filter(age -> age > 10000)
//							.reduce((age1, age2) -> age1 + age2);
//		
//		System.out.println("Sum of Ages " + sum1.orElse(0));
	}

	
	
	

}

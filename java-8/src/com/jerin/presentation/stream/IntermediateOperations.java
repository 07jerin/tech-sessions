package com.jerin.presentation.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class IntermediateOperations {
	
	static List<Person> persons = PersonInterface.getSamplePersons();
	
	
	public static void main(String[] args) {
	
		persons.forEach(System.out :: println);
		
		System.out.println("********************************************************************");
		
		mapOperation();
		
		System.out.println("********************************************************************");
		filterOperation();
		
		System.out.println("********************************************************************");
		distinctOperation();
		
		System.out.println("********************************************************************");
		limitOperation();
		
		System.out.println("********************************************************************");
		skipOperation();
		
		System.out.println("********************************************************************");
		sortOperation();
	}
	
	public static void mapOperation(){
		
		Stream<Person> personStream = persons.stream(); 
//		Stream<Integer> ageStream =  personStream.map((p) -> p.getAge());
		Stream<String> nameStream =  personStream.map((p) -> p.getName());
//		System.out.println("Age Stream : " + ageStream.collect(Collectors.toList()));
		System.out.println("Name Stream : " + nameStream.collect(Collectors.toList()));
	}
	
	public static void filterOperation(){
		
		Stream<Person> personStream = persons.stream();
		Stream<Person> filteredAgeStream =  personStream
												.filter((p) -> p.getAge() > 30);
		
		System.out.println("Filtered Age Stream : " + filteredAgeStream.collect(Collectors.toList()));
	}
	
	public static void distinctOperation(){
		
		Stream<Person> personStream = persons.stream();
//		Stream<String> nameStream =  personStream.map((p) -> p.getName());
//		Stream<String> distinctNames = nameStream.distinct();
		
		Stream<String> distinctNames =  personStream
											.map((p) -> p.getName())
											.distinct();
		
		System.out.println("Distinct Names " + distinctNames.collect(Collectors.toList()));
	}
	
	public static void limitOperation(){
		
		Stream<Person> personStream = persons.stream().limit(2);
		System.out.println("Two Persons Limited " + personStream.collect(Collectors.toList()));
	}
	
	public static void skipOperation(){
		
		Stream<Person> personStream = persons.stream().skip(2);
		System.out.println("Two Persons Skipped " + personStream.collect(Collectors.toList()));
	}
	
	public static void sortOperation(){
		
		Stream<String> sortedNames =  persons
										.stream()
										.map((p) -> p.getName())
										.sorted();
		System.out.println("Default Sort " + sortedNames.collect(Collectors.toList()));
		

		Stream<String> revrsesortedNames =  persons
												.stream()
												.map((p) -> p.getName())
												.sorted(Comparator.reverseOrder());
		System.out.println("Reverse Sorted Names " + revrsesortedNames.collect(Collectors.toList()));
		
		
		Stream<Person> sortByAge =  persons
									.stream()
//									.sorted((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
									.sorted(Person :: sort);
		System.out.println("Perons Sorted by age " + sortByAge.collect(Collectors.toList()));
		
	}
	
	
	

}

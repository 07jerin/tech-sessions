package com.jerin.presentation.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.common.Utility;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class CreatingStream {
	
	public static void main(String[] args) {
		Collection<Person> personsCollection = PersonInterface.getSamplePersons();
		
		personsCollection.stream();
		personsCollection.parallelStream();
		personsCollection.stream().parallel();
		personsCollection.parallelStream().sequential();
		
		
		Integer [] array =Utility.integerArray() ;
		
		Stream<Integer> stream = Stream.of(array);
//		Stream<Integer> stream = Stream.of(array).parallel();
//		Stream<Integer> stream = Arrays.stream(array);
		
		stream.forEach( str -> System.out.println(str));
	
		
		
		//The data get extracted from the source only after the terminal operation
		List<Person> persons = PersonInterface.getSamplePersons();
		Stream<Person> personStream = persons.stream();
		persons.add(new Person("Test", 100));
		
		personStream.forEach(System.out :: println);
		
		personStream.forEach(System.out :: println); // Error as stream was already used
		
	}

}

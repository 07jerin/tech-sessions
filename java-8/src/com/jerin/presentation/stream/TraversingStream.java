package com.jerin.presentation.stream;

import java.util.List;
import java.util.function.Predicate;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class TraversingStream {
	
	public static void main(String[] args) {

		List<Person>  personList = PersonInterface.getSamplePersons();
		
//		personList.stream().forEach( p -> System.out.println(p) );
		
		
		/** FILTERING USING STREAM **/
		Predicate<Person> pred = (person) -> person.getAge() > 40;
//		personList.forEach(person -> {
//			if(pred.test(person)){
//				System.out.println(person);
//			}
//		});
		
		personList.stream()
			.filter(pred)
			.forEach( p -> System.out.println(p) );
		
		
	}

}

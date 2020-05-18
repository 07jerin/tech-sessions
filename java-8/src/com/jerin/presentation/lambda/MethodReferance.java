package com.jerin.presentation.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class MethodReferance {

	public static void main(String[] args) {
		MethodReferance ref = new MethodReferance();
		ref.intro();
		
		ref.samples();
		
	}
	
	public void intro(){
		List<Person> persons = PersonInterface.getSamplePersons();
		persons.forEach(p -> { 
			System.out.println("Name : " + p.getName());
			System.out.println("Age : " + p.getAge());
		});
		
		persons.forEach(p -> printDetails(p));
		
		persons.forEach(this :: printDetails);
		
	}
	
	public void printDetails(Person p){
		System.out.println("Name : " + p.getName());
		System.out.println("Age : " + p.getAge());
	}
	
	public void samples(){
		List<Person> persons = PersonInterface.getSamplePersons();
		
		System.out.println("Sorted By AGE : ");
		// Static Method reference
		Collections.sort(persons, (p1, p2) -> p1.getAge().compareTo(p2.getAge()));
		Collections.sort(persons, MethodReferance :: sortByAge);
		persons.forEach((person) -> System.out.println(person));
		
		System.out.println("Sorted By Name : ");
		// Instance Method reference
		Collections.sort(persons, this :: sortByName);
		persons.forEach(System.out :: println);
			
		// Arbitrary  object of particular type
		System.out.println("Arbitary Method Referance ");
		Collections.sort(persons, Person::sort);
		persons.forEach(System.out :: println);
		
		// Constructor
		String[] strArray  = new String[] {"1","2","3","4"};
		List<String> intValues = Arrays.asList(strArray);
		intValues.forEach(Integer::new);
		
		
//		Collections.sort(persons, MethodReferance :: test);
	}
	
	public static int sortByAge (Person p1, Person p2){
		return p1.getAge().compareTo(p2.getAge());
	}
	

	public int sortByName (Person p1, Person p2){ // The signature is same as if it were used in compare to of cmparator
		return p1.getName().compareTo(p2.getName());
	}
	
	public static int test (String p1, String p2){
		return 0;
	}
	
	interface ReferenceTester{
		
	}
	
	
	
	
	
}

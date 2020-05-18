package com.jerin.presentation.interfacemethods;

import java.util.ArrayList;
import java.util.List;

import com.jerin.presentation.common.Person;

public interface PersonInterface {
	
	String getName();
	Integer getAge();
	
	default String getPersonInfo(){
		return getName() + " (" +getAge()+")";
	}
	
	static List<Person> getSamplePersons(){
		List <Person> persons = new ArrayList<>();
		persons.add(new Person("Thomas", 45));
		persons.add(new Person("Joe", 20));
		persons.add(new Person("James", 30));
		persons.add(new Person("Mary", 40));
		persons.add(new Person("Mike", 50));
		persons.add(new Person("Mike", 70));
		return persons;
	}
	

}

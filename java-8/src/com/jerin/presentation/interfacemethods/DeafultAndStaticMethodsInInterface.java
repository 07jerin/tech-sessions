package com.jerin.presentation.interfacemethods;

import java.util.List;

import com.jerin.presentation.common.Person;

public class DeafultAndStaticMethodsInInterface {

	public static void main(String[] args) {
		List<Person> persons = PersonInterface.getSamplePersons();
		for (Person person: persons ){
			System.out.println(person.getPersonInfo());
		} 
	}
}

package com.jerin.presentation.lambda;

import java.util.List;
import java.util.function.Predicate;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class CollectionFiltering {
	
	List<Person> persons = PersonInterface.getSamplePersons();
	
	public static void main(String[] args) {
		new CollectionFiltering().filterCollection();
	}
	
	public  void filterCollection(){
		
		for(Person person : persons){
			if(person.getAge() > 30){
				System.out.println(person);
			}
		}
		
		Predicate<Person> pred = new Predicate<Person>() {

			@Override
			public boolean test(Person person) {
				// TODO Auto-generated method stub
				return person.getAge() > 30;
			}
		};
		
//		Predicate<Person> pred = (person) -> person.getAge() > 30;
//		Predicate<Person> pred1 = (person) -> person.getAge() > 40;
		displayPersons(pred);
//		displayPersons(pred1);
		
	}
	
	public void displayPersons(Predicate<Person> pred){
		
		persons.forEach((person) ->{
			if(pred.test(person)){
				System.out.println(person.getPersonInfo());
			}
		});
	}

	
}

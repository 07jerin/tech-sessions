package com.jerin.presentation.lambda;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import com.jerin.presentation.common.Person;
import com.jerin.presentation.interfacemethods.PersonInterface;

public class CollectionTraversal {
	
	public static void main(String[] args) {
		List<Person> personList = PersonInterface.getSamplePersons();
		
//		for(Person person : personList){
//			System.out.println(person);
//		}
		
//		Iterator<Person> nameIterator = personList.iterator();
//		while (nameIterator.hasNext()) {
//			System.out.println(nameIterator.next());
//		}
		
		personList.forEach(new Consumer<Person>(){
			@Override
			public void accept(Person t) {
				System.out.println(t);
			}
		});
		
		
//		
		personList.forEach(person -> {
			System.out.println(person);
		});
		
//		new CollectionTraversal().print();
	}
	
	
//	public void print(){
//		List<Person> personList = PersonInterface.getSamplePersons();
//		personList.forEach(person -> {
//			System.out.println(person);
//		});
//	}

}

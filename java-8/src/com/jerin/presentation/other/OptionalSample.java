package com.jerin.presentation.other;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.OptionalInt;

import com.jerin.presentation.common.Person;

public class OptionalSample {

	public static void main(String[] args) {
		OptionalSample sample = new OptionalSample(); 
//		sample.printAge();
		sample.calc();	
		
	}
	
	
	public void printAge(){
		Optional<Person>  optionalPerson = getOptionalPerson();
		Person  person = getPerson();
		
		System.out.println(person.getAge());
		System.out.println(optionalPerson.get().getAge()); // To get the value we use .get() on optional object 
															// .get() is not so good as it will again return the null so do not use it
		
		
//		System.out.println(optionalPerson.orElse(new Person("Dummy", 0)));
	}
	
	public Optional<Person> getOptionalPerson(){ // The return type is optional means  there is a possibility of null being returned from this
		Person person = getPerson();
		return Optional.ofNullable(person);
	}
	
	
	public Person getPerson(){
		return new Person("Jerin", 27);
//		return null;
	}
	
	
	
	public void calc(){
		
		BigDecimal n1 = new BigDecimal(1);
		BigDecimal n2 = new BigDecimal(2);
//		BigDecimal n2 = null;
		
		add(n1, n2);
		addOptional(Optional.ofNullable(n1) ,Optional.ofNullable(n2));
	}
	
	public void add (BigDecimal  n1, BigDecimal n2 ){
		BigDecimal sum = n1.add(n2);
		System.out.println(sum.toPlainString());
	}
	

	public void addOptional (Optional<BigDecimal> n1, Optional<BigDecimal> n2 ){
		BigDecimal sum = n1.orElse(new BigDecimal(0))
							.add(n2.orElse(new BigDecimal(0)));
		System.out.println(sum.toPlainString());
	}
}

package com.jerin.presentation.other;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.jerin.presentation.common.Person;

public class TestClass {

	public static void main(String[] args) {
		print( () -> new Person("tes", 10));
		getPerson((name) -> new Person(name, 0));
		
		calc((a, b) -> a+b );
		calc((a, b) -> a*b );
		
	}
	
	static void print(PersonSupplier supplier)
	{
		System.out.println(supplier.get()); 
	}
	
	
	static void getPerson(Function<String, Person> p){
		Person newPerson =  p.apply("Jerin");
		System.out.println(newPerson);
	}
	
	
	static void calc(BinaryOperator<Integer> op){
		System.out.println(op.apply(10, 20));
	}
	
	public interface PersonSupplier {
		Person get();
	}


		
	
}

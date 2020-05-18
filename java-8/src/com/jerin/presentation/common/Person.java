package com.jerin.presentation.common;

import com.jerin.presentation.interfacemethods.PersonInterface;

public class Person implements PersonInterface {

	private String name;
	private Integer age;

	public Person(String name, Integer age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString(){
		return name + " Age: "+ age;
	}
	
	public int sort(Person p1){
		return p1.getAge().compareTo(this.getAge());
	}
	
//	public static int sort(Person p1, Person p2){
//		System.out.println("Static method");
//		return p1.getAge().compareTo(p2.getAge());
//	}

}

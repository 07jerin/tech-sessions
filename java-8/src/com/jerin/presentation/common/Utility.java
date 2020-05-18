package com.jerin.presentation.common;

public class Utility {

	public static Integer[] integerArray(){
		
		int count = 100000;
		Integer [] array = new Integer [count];
		
		int i = 0;
		while ( i<count){
			array[i] = i;
			i++;
		}
		return array;
	}
	
}

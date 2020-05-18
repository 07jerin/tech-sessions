package com.jerin.presentation.lambda;

import java.util.function.Predicate;

public class StrategyPatternUsingPredicate {


	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(sumOfAllNumbers(array));
		System.out.println(sumOfAllOdd(array));
		System.out.println(sumOfAllEven(array));
		
		Predicate<Integer> allNumbers = (n) -> true;
		Predicate<Integer> evenNumbers = (n) -> n % 2 == 0;
		Predicate<Integer> oddNumbers = (n) -> n % 2 != 0;
		
		System.out.println(sum(array, allNumbers));
		System.out.println(sum(array, oddNumbers));
		System.out.println(sum(array, evenNumbers));
	}
	
	private static int sumOfAllNumbers(Integer [] array ){
		int sum = 0;
		for(Integer val : array){
			sum += val;
		}
		return sum;
	}
	
	private static int sumOfAllOdd(Integer [] array ){
		int sum = 0;
		for(Integer val : array){
			if(val % 2 != 0)
				sum += val;
		}
		return sum;
	}
	
	private static int sumOfAllEven(Integer [] array ){
		int sum = 0;
		for(Integer val : array){
			if(val % 2 == 0)
				sum += val;
		}
		return sum;
	}
	
	private static int sum(Integer[] array, Predicate<Integer> pred) {
		int sum = 0;
		for(Integer val : array){
			if(pred.test(val))
				sum += val;
		}
		return sum;
	}
	
}

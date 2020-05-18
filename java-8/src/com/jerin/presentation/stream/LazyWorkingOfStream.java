package com.jerin.presentation.stream;

import java.util.Arrays;
import java.util.List;

public class LazyWorkingOfStream {

	public static void main(String[] args) {
		// double the first even number greater than 3 from the list
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

//		LazyWorkingOfStream.conventionalWay(numbers);
//		LazyWorkingOfStream.usingStream(numbers);

	}

	public static int conventionalWay(List<Integer> numbers) {

		int result = 0;
		for (Integer number : numbers) {
			if (isEven(number) && isGreaterThan2(number)) {
				result = doubleIt(number);
				break;
			}
		}
		return result;
	}

	public static void usingStream(List<Integer> numbers) {
		numbers.stream()
				.filter(LazyWorkingOfStream::isEven)
				.filter(LazyWorkingOfStream::isGreaterThan2)
				.mapToInt(LazyWorkingOfStream::doubleIt)
				.findFirst()
				.getAsInt();
		
//		System.out.println("End Stream processing!");
	}
	
	
	public static boolean isGreaterThan2(int number) {
		System.out.println("isGreater " + number);
		return number > 2;
	}

	public static boolean isEven(int number) {
		System.out.println("isEven " + number);
		return number % 2 == 0;
	}

	public static int doubleIt(int number) {
		System.out.println("doubleIt " + number);
		return number * 2;
	}
}

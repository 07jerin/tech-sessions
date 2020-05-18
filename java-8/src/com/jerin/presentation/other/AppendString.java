package com.jerin.presentation.other;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class AppendString {

	public static void main(String[] args) {

//		usingStringClass();
		usingStringJoiner();

	}

	private static void usingStringClass() {
		
		String fullName = String.join(" , ", "Jerin", "Joseph", "Mark");
		System.out.println(fullName);

		String route = String.join(" --> ", "Kochi", "Trivandrum", "Delhi", "Goa");
		System.out.println(route);

		// Using Array
		String[] places = { "Kochi", "Trivandrum", "Delhi", "Goa" }; // IN arrays and lists we dont have to manually iterate, 
		String place = String.join(" and ", places);
		System.out.println(place);
		
		// Using List
		List<String> placeList = Arrays.asList(places);
		place = String.join(" :: ", placeList);
		System.out.println(place);
	}
	
	
	private static void usingStringJoiner(){
		
		System.out.println();
		System.out.println("******************* Using String Joiner ***********");
		System.out.println();
		
		StringJoiner sj = new StringJoiner(" , ", "{ " , " }");
		sj.setEmptyValue("No cities");
		
		System.out.println("Empty :  "+ sj.toString());
		
		sj.add("Kochi");
		sj.add("Trivandrum");
		sj.add("Delhi");
		
		
		System.out.println("With Values :  "+sj.toString());
	}
}

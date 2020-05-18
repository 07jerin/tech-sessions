package com.jerin.presentation.lambda;


public class CustomFunctionalInterface {

	
	public static void main(String[] args) {
		printEmployeeDetails();
	}
	
	@FunctionalInterface
	interface EmployeeDetailsPrinter{
		
		public String printDetails(String name, long id);
		@Override
		public boolean equals(Object obj);
//		public boolean printDetails1(String name, long id, boolean returnValue);
//		public boolean printDetails1();
		
		public default void print(){
			System.out.println("Default Method");
		}
	}
	
	public static void printEmployeeDetails(){
		
		
		
//		EmployeeDetailsPrinter printan = new EmployeeDetailsPrinter() {
//			
//			@Override
//			public String printDetails(String name, long id) {
//				System.out.println("Employee Name : " +name);
//				System.out.println("Employee ID : " +id);
//				return "Printed : " + name;
//			}
//		};
		
		
		//No type declaration because the interface has only single abstract method so data types are already known
		EmployeeDetailsPrinter printer = (name, id) -> 
		{
			System.out.println("Employee Name : " +name);
			System.out.println("Employee ID : " +id);
			return "Printed : " + name;
		};
		
		
		String returnValue = printer.printDetails("Jerin", 100);
		System.out.println(returnValue);
	}
	
	@FunctionalInterface
	interface EmployeeDetailsPrinter1 extends EmployeeDetailsPrinter{
		
		public boolean equals(Object obj);
//		public String printDetails(String name, long id);
//		public boolean printDetails1();
	}
}

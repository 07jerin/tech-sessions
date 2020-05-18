package com.jerin.presentation.lambda;

import java.util.function.Consumer;

public class VariableScope {

	String classVariable = "Class variable";
	String var  = "Class Level scoped Variable";

	
	public void invoke(){
		String methodVar = "Method Variable";
		String var = "invoke Method Level";
		
		Consumer<String> con = new Consumer<String>() {

			String var = "Consumer Class Level"; // Creating instance variable that holds the state
			@Override
			public void accept(String t) {
				
				System.out.println("Class Level Variable : " + classVariable);
				System.out.println("Method Level Variable : " + methodVar);
				
				System.out.println(var);
				System.out.println(this.var); // Cannot access the outer class if it was shadowed 
//											even after using this keyword !
				
			}
		};
		
		classVariable = classVariable.toUpperCase();
		con.accept(null);
		
		
	}
	
	public void lambda(){
		String methodVar = "Method Variable";
		String var = "lambda Method Level";
		
		Consumer<String> con = (t)  -> {

//			String var = "Consumer Class Level"; // Duplicate local variable as var is already defined in method
			
			System.out.println("Class Level Variable : " + classVariable);
			System.out.println("Method Level Variable : " + methodVar);
			
			System.out.println(var);
			System.out.println(this.var); //  in lambda this points to the enclosing class
				
		};
		
		classVariable = classVariable.toUpperCase();
		con.accept(null);
		
	}
	
	public static void main(String[] args) {
		new VariableScope().invoke();
		
		System.out.println("******************* Using Lambda ***************** \n");

		
		new VariableScope().lambda();
	}
}

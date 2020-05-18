package com.jerin.presentation.lambda;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jerin.presentation.other.TestClass;

public class IntroToLambda {
	
	//Creating New Thread Using Separate Class
	class MyRunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("MyRunnable class");
		}
	}
	
	public void createThread(){
		MyRunnable myRunnable = new MyRunnable();
		new Thread(myRunnable).start();
	}
	
	
	
	//***********************************************************
	//***********************************************************
	

	//Creating New Thread Using Inner Class
	public void createThread1(){
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inner class");
				
			}
		};
		new Thread(myRunnable).start();
	}
	//***********************************************************
	//***********************************************************
		
	//Creating New Thread Using Anonymous Class
		public void createThread2(){
		
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("Anonymous class");
				}
			}).start();
		}
			
	//***********************************************************
	//***********************************************************
	
	
		
		
	//Creating New Thread Using Lambda Class
		public void createThreadLambda(){
		
		
			Runnable r = () -> {
				System.out.println("Lambda!!");
				
			};
			new Thread(r).start();
			
			//Or Even Better
			Thread t =  new Thread(() -> System.out.println("New Thread in Lambda!!"));
			
		}
			
	//***********************************************************
	//***********************************************************
		
		
	/*
	 * Runnable r = 
	 * () -- Method signature (Of the abstract method in the functional interface).  
	 * -> -- Lambda Expression also known as arrow token
	 * System.out.println("Lambda!!"); -- Single line implementation
	 */
	
	
		public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			new IntroToLambda().printAllDeclaredmethods();
		}
		
		public void printAllDeclaredmethods() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			for(Method method :  IntroToLambda.class.getDeclaredMethods()){
				System.out.println(method.getName());
				if (method.getName().contains("lambda")){
						method.invoke(IntroToLambda.class);
					}
				}
			}
	
}

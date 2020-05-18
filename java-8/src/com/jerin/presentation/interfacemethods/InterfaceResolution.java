package com.jerin.presentation.interfacemethods;

public class InterfaceResolution {

	interface Fly {
		  default void takeOff() { System.out.println("Fly::takeOff"); }
		  default void land() { System.out.println("Fly::land"); }
		  default void turn() { System.out.println("Fly::turn"); }
		  default void cruise() { System.out.println("Fly::cruise"); }
	}
	
	interface FastFly extends Fly {
		  @Override
		  default void takeOff() { System.out.println("FastFly::takeOff"); }
	}
		
	
	interface Sail {
		  default void cruise() { System.out.println("Sail::Cruise"); }
		  default void turn() { System.out.println("Sail::turn"); }
	}
	
	class Vehicle {
		  public void turn() { System.out.println("Vehicle::turn"); }
	}
	
	class SeaPlane extends Vehicle implements FastFly, Sail {
		 @Override
		 public void cruise() { System.out.println("SeaPlane::cruise"); }

//		@Override
//		public void turn() {
//			FastFly.super.turn();
//		} 
	}
	
	

	public void run(){
	 	SeaPlane seaPlane = new SeaPlane();
	    seaPlane.takeOff();
	    seaPlane.turn();
	    seaPlane.cruise();
	    seaPlane.land();
	}
	
	 public static void main(String[] args) {
		   new InterfaceResolution().run();
	 }	   
}

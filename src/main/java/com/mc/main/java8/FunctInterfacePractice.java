package com.mc.main.java8;

import com.mc.main.java8.streams.Printable;
import com.mc.main.java8.streams.PrintableParam;
import com.mc.main.util.Practice;

public class FunctInterfacePractice extends Practice {

	private FunctInterfacePractice() {
		super();
	}
	
	// Functional interfaces is an unusual example of java syntax
	// that appears more akin to functional programming.
	//
	// When we declare a special interface type, we can use that type to store
	// method implementation by promising to fulfil the action of the interface.
	public static void start() {
		printHeader("Functional Interfaces");
		
		// Functional interfaces allow us to pass a method as an object
		// we do not need to provide accessors, return types(as it's inferred by the compiler).
		//
		// To inform java that our implementation is a method that is part of a functional interface
		// we provide the arrow "->" keyword.
		//
		// We can use the return keyword, but it isn't needed if it's a void returning method
		// we can have multiple lines of instructions, but the instructions must be
		// enclosed in scope in order to encapsulate the instructions.
		
		// The method implementation as an example of our functional interface
		Printable printVoid = () -> System.out.println("result");
		
		// We can pass our implementation of the functional interface as an
		// object, allowing that method to take our implementation and handle/invoke
		// our provided implementation.
		print(printVoid);
		
		// Let's instead see an example of a method implementation that has a parameter
		PrintableParam printParam = (y) -> {
			// Our implementation here handles y as though a standard java object
			// type limitation is provided by the outline of the interface method.
			for(int i = 0 ; i < 5; i++) {
				System.out.println("result: " + y);
			}
		}; // even though we have a scope, we need to terminate the variable initialisation process
		
		print(printParam);
	}
	
	// A method that invokes our functional interface
	// by extension, invoking the implementation of x
	public static void print(Printable x){
		x.print(); // perform the functional interface method call
	}
	
	// As we can only have one abstract method in a functional interface
	// we need a separate method that expects to use that interface.
	//
	// because the interface outlines a parameter, we know that x.print can take in "Object x"
	// which we can use here to append Cat to the method implementation.
	public static void print(PrintableParam x){
		x.print("Cat"); // now this method can pass some parameter into the provided implementation
	}
}

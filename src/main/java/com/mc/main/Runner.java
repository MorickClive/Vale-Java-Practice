package com.mc.main;

import com.mc.main.procedural.Application;
import com.mc.main.procedural.StringPractice;

public class Runner {
	
	// the '//' symbol combination can be used to inform java to ignore instruction on the line
	// that come after its usage. It is particularly useful to write comments on code.
	// however comments are considered bad practice in the software industry.
	
	/*
	 * Multi-lined comments such as this also allow a block of code to be ignored.
	 * again, coding should primarily express itself clearly, writing comments means that
	 * there is a level of complexity that should be simplified.
	 * 
	 * This project is a refresher of Java coding for `Alan Davies`, comments 
	 * here are to express awareness of java coding concepts as well as the depth
	 * of understanding of coding principles.
	 */
	public static void main(String[] args) {
		// A simple print to console method
		System.out.println("HELLO WORLD");

		Application.PROCEDURAL.run();
		Application.OOP.run();
		Application.ADVANCED.run();
		Application.JAVA8.run();
		
		System.out.println("Application ENDS");
	}
	
	// We don't want to create an instance of this class
	private Runner() { super(); }
}

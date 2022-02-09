package com.mc.main;

import com.mc.main.procedural.ArraysPractice;
import com.mc.main.procedural.OperatorsPractice;
import com.mc.main.procedural.VariablesPractice;

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
		System.out.println("HELLO WORLD");
		
		VariablesPractice.start();
		ArraysPractice.start();
		OperatorsPractice.start();
	}
	
	// We don't want to create an instance of this class
	private Runner() { super(); }
}

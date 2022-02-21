package com.mc.main;

// Find FlowControlPractice.java to start!
public class Runner {
	
	/**
	 * <p>This project is a refresher of Java coding for `Alan Davies`, 
	 * comments here are to express awareness of java coding concepts as well as the depth
	 * of understanding of coding principles.</p>
	 * 
	 * <p>This project will read like a guide, exploring topics and moving
	 * onward to new concepts</p>
	 * 
	 * @param args - a list of parameters that can be passed during command prompt execution
	 * @author MorickClive
	 */
	public static void main(String[] args) {
		// A simple print function, outputting to console
		System.out.println("HELLO WORLD");
		
		// Continued:
		start();
		
		System.out.println("Application ENDS");
	}
	
	protected static void start() {
		System.out.println("=".repeat(40) + "\n");
		
		//Application.PROCEDURAL.run();
		//Application.OOP.run();
		Application.ADVANCED.run();
		//Application.JAVA8.run();
	}
	
}

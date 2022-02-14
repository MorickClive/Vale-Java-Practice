package com.mc.main;

import com.mc.main.procedural.Application;
import com.mc.main.procedural.StringPractice;

public class Runner {
	
	/**
	 * <p>This project is a refresher of Java coding for `Alan Davies`, 
	 * comments here are to express awareness of java coding concepts as well as the depth
	 * of understanding of coding principles.</p>
	 * 
	 * @param args - a list of parameters that can be passed during command prompt execution
	 * @author MorickClive
	 */
	public static void main(String[] args) {
		// A simple print function, outputting to console
		System.out.println("HELLO WORLD");

		Application.PROCEDURAL.run();
		Application.OOP.run();
		Application.ADVANCED.run();
		Application.JAVA8.run();
		
		System.out.println("Application ENDS");
	}
	
	/** We don't want to create an instance of this class */
	private Runner() { super(); }
}

package com.mc.main;

import com.mc.main.advanced.ConcurrencyPractice;
import com.mc.main.advanced.ui.scanner.Console;
import com.mc.main.util.ApplicationTime;
import com.mc.main.util.StringConst;

// Find FlowControlPractice.java to start!
public class Runner {
	
	/**
	 * <p>
	 * This project is a refresher of Java coding for `Alan Davies`, comments here
	 * are to express awareness of java coding concepts as well as the depth of
	 * understanding of coding principles.
	 * </p>
	 * 
	 * <p>
	 * This project will read like a guide, exploring topics and moving onward to
	 * new concepts
	 * </p>
	 * 
	 * @param args - a list of parameters that can be passed during command prompt
	 *             execution
	 * @author MorickClive
	 */
	public static void main(String[] args) {
		// A simple print function, outputting to console
		System.out.println("HELLO WORLD");
		
		// Continued:
		try {
			start();
		} finally {
			// SCANNER close method:
			// Clean up active resources at end of application
			// finally allows closure post-exception encounter - ensuring closure in most
			// if not all error cases
			Console.close();
			// Let's return to Console.input()!
			
			System.out.println("Application ENDS");
			ApplicationTime.printElapsedTime();
		}
	}
	
	private static final ApplicationTime time = new ApplicationTime();

	protected static void start() {
		System.out.println(StringConst.DIV + "\n");

		Application.PROCEDURAL.run();
		Application.OOP.run();
		Application.ADVANCED.run();
		// Application.JAVA8.run();
	}

}

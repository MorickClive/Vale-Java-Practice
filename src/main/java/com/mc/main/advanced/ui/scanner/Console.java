package com.mc.main.advanced.ui.scanner;

import java.util.Scanner;

// This is a bespoke console class, the purpose of this class is to ensure we only have
// one Scanner instance at any given time.
//
// Let's look at the `getScanner()` method:
public class Console extends ConsoleMock {
	
	// Our only Scanner:
	private static Scanner input;
	
	// We don't want instances of the Console, there should be one and only one Console in this application!
	private Console() { super(); }
	
	private static boolean hasScanner() {
		return input != null;
	}
	
	// Anywhere in our application can use this method
	// it's the way we'll initialise and access the Scanner object/instance!
	public static Scanner getScanner() {
		// `new Scanner(System.in);`
		// Above is the way we typically create a Scanner instance - much like any other object!
		// but you might be thinking - Why put it in a complex class like Console, what's the point?!?
		//
		// Scanners access a "universal resource" of your machine, the System.in - or input stream
		// This is obviously a very important aspect of your access to data entry so it must be treated with care!
		// As such, once we use a scanner, our first thought should be - when do we no longer need the system input?
		// as well as how is the system input used in our application!
		input = !hasScanner() ? new Scanner(System.in) : input;
		
		// We only store one instance of Scanner - to make more would be pointless - both separate instances
		// would access the singular input stream, so we ensure that console can only have 1 instance.
		return input;
		
		// Let's look at the close() method
	}
	
	// This method is the primary method we want to use, again, this is a static method
	// we won't need an instance of Console to call this method!
	//
	// The idea here is that we use the Scanner.next() method which freezes the application until the
	// user has input some kind of entry, once the user submits this message - the scanner will
	// read from an array/buffer that represents all user input - extracting the "next" collection of
	// bytes and translating them into a String.
	//
	// We can translate the user entry into other data types using .nextInt() or other methods
	// specific to a data value - however the user might not always conform to data entry limited
	// to numeric data - this can cause exceptions.
	//
	// With string data we can represent most if not all character data and handle that data in java.
	// In fact, we can use Wrapper classes to test if we can translate string data into numeric and handle
	// any exceptions after user entry, rather than relying on users to understand how our application works
	// before crashing it entirely!
	//
	// Let's return to ScannerPractice.start!
	public static String input() {
		return hasScanner() ? input.next() : getScanner().next();
	}

	// As a public static method, we can access this from any location in our application
	// and this is useful!
	//
	// The method Console.close allows us to access Scanner.close() - an important process in allowing
	// us to control when the system.in should be closed - once it is closed during the lifecycle of the
	// running application, not other instance, new or old of Scanner can use the System.in stream/
	// that is why when we close it - we close it for good.
	//
	// additionally we wouldn't want our input to be exploited, as such we should close this important
	// resource at the end of our application!
	// Please review the Runner.main method to observe this in use!
	public static void close() {
		if( hasScanner() ) {
			input.close();
		}
		System.out.println("Scanner access to input stream closed!");
	}
}

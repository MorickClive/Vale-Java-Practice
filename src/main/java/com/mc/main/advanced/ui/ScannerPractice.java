package com.mc.main.advanced.ui;

import com.mc.main.advanced.ui.scanner.Console;
import com.mc.main.util.Practice;

// To being, let's review the start method!
public class ScannerPractice extends Practice {
	
	// We'll use this as an example of several submissions by user entry via mocking
	// each space will separate a user submission.
	private static final String sampleStreamInput = "Cat Dog Penguin Bird Seagul";
	
	// In a basic explanation, Scanners are our best tool for asking users for their
	// feedback through user input.
	//
	// Before we dive in any further, let's look at the Console class!
	public static void start() {
		printHeader("Scanner: User Input");
		
		// Once you've reviewed the Console class, let's look at thi following
		try {
			// NOTE:
			// This redirects input and output streams, effectively allow us
			// to provide a stream of potential inputs from our user!
			// ~	You do not have to know how this works in order to appreciate that
			// 		we are faking user input.
			Console.mockSetup();
			Console.setMockInputStreamMessage(sampleStreamInput);

			// When a Scanner users .next() it attempts to reach into the System.in
			// to extract the next byte of information provided to the system input.
			// However this process will freeze the application and wait for the user submission
			// before proceeding past Scanner.next();!
			//
			// In this practice class, we have already run it as part of a collective set of practice applications
			// and in testing to see if the operation will perform correctly - however this is automated.
			// As such, and exclusively for this example, Console has been provided with a "Mock class"
			// that fakes user input.
			System.out.println("User Input 1: " + Console.input());
			System.out.println("User Input 3: " + Console.input());
			System.out.println("User Input 4: " + Console.input());
			
			// Whilst the above will be mocked to automatically run, Console.input() or Scanner.next()
			// would wait for a user to input a message and press enter to submit the result!
			// we can use System.out.println("message here:") to prompt users to provide data
			// then extract their response by saving the result of Scanner.next() into a String!
			//
			// This can allow us to create a truly interactive application - albeit, a console entry application
			// but now we have actual opportunities to create a reactive application, that enables us to
			// communicate with a user!
		}	finally {
			// NOTE:
			// This resets in/out stream, allowing for normal scanner read in and out
			// Should anything goes wrong during the mock, we always revert to our default
			// input and output streams!
			// ~ 	You do not have to know how this works in order to appreciate that
			// 		we are faking user input.
			Console.mockCleanUp();
		}
	}

}

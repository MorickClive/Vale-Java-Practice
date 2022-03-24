package com.mc.main.advanced.threads;

// Creating a thread is relatively simple, we can either
// create a new Thread and pass in a class that implements the "Runnable" interface
// or create a class that inherits functionality from the Thread class as part of a 
// is-a relationship.
public class PrintMessage extends Thread {
	
	private String message;
	
	public PrintMessage(String msg) {
		super();
		
		this.message = msg;
	}

	// When we want to execute a thread, we use the start method
	// this will then proceed to use the run method to execute instructions
	// in this unique "thread".
	//
	// One of the important things to recongise here is that a "thread" is a processing
	// term that has meaning to the compiler - but to us, it looks like we are simply performing
	// inheritance on a random class.
	//
	// This isn't just a simple java class anymore, but a "new thread" processing information
	// Separately from our entry class "Runner.main()".
	//
	// Infact, it might help to think of PrintMessage.start() similar to Runner.main()!
	// this is because they are both threads of the java application, executing lines
	// of code within the JVM!
	@Override
	public void run() {
		super.run();
		
		System.out.println(message);
	}
	
}

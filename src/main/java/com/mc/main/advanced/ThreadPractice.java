package com.mc.main.advanced;

import java.util.List;

import com.mc.main.advanced.threads.ArrayPrint;
import com.mc.main.advanced.threads.ArrayPrintWait;
import com.mc.main.advanced.threads.InterruptThread;
import com.mc.main.advanced.threads.MessageInterrupt;
import com.mc.main.advanced.threads.PrintMessage;
import com.mc.main.advanced.threads.ThreadLifeCycle;
import com.mc.main.util.Practice;
import com.mc.main.util.StringConst;

public class ThreadPractice extends Practice {
	// When dealing with programming in java, we've only really looked
	// at programming as a procedural process - there have been some exceptions to
	// the rule
	// but the idea is that our application runs through each line of code
	// sequentially.
	//
	// But imagine if all computers HAD to complete one task before doing another,
	// we'd
	// have no way of being able to perform multiple actions at the same time!
	//
	// Perhaps you've previously watched a video on your computer whilst
	// reading an interesting article or logging into your social media account!
	//
	// Computers have the means to break down instructions and process instructions
	// independently
	// of the lines of code that are written, this is because they have multiple
	// processes - either
	// in terms of hardware or "logical processors" which help perform calculations
	// independently of eachother.
	//
	// If you are on a windows machine, you can even see how active each "cpu" group
	// is by reviewing
	// your "resource monitor" on the cpu tab.

	private ThreadPractice() {
		super();
	}

	public static void start() {
		// When we discuss threading, there are two terms we want to ensure we are
		// familiar with before
		// we get into more specific details.
		//
		// Processes vs Threads
		// Processes are much like self-contained programs or applications, they set an
		// environment in which
		// code operations take place.
		//
		// Threads are like isolated "light-weight" programs that might exist within the
		// space of a process
		// or program, often a set of instructions that work towards breaking a larger
		// task
		// into several smaller tasks.
		//
		// Why use threading?
		// Threading has a massive benefit as part of your application, this comes back
		// to the notion
		// of using one processor on your machine VS using many processors on your
		// machine.
		//
		// Threading allows us to take a part of our java application and distribute the
		// task to available
		// resources the machine has to help process the task at hand. Coding is
		// resolved by a set of mathematical
		// calculations that are processed by a cpu core, each core can perform many,
		// many operations per second
		// but imagine trying to push all your tasks through one cpu calculator when you
		// have 3-7 free cores
		// not doing anything!
		//
		// When we break up instruction intense operations into threads, we can directly
		// benefit from multi-core processing and enhance the efficiency of our code by
		// making use of unutilised processing units.
		//
		// However the usage of benefiting from parallel processing will primarily be covered in
		// ConcurrencyPractice.
		//
		// First we need to appreciate the nuance of threads and their lifecycles.
		printHeader("Threads");

		// All threads have the capability of throwing an InterruptedException
		// as such we'll capture any throws here
		try {
			// Let's begin looking at a very basic example!
			startingThreads();

			// Let's understand the life cycle of a thread and how we can get the most out
			// of a thread!
			lifeCycle();

			// Now we will move on to how we can control thread behaviour and what to watch
			// out for during
			// invocation and execution of code with threading!
			threadControl();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void startingThreads() {
		// We create a thread much like we create any class instance.
		PrintMessage thread = new PrintMessage("Hello from ThreadPractice!");

		// The inheritance allows us to inform java that
		// we want this method to run its behaviour when we invoke the start() method.
		thread.start();

		// If you try this then you must understand that threads execute separately -
		// evaluating
		// when time and resources are allocated to the thread - rather than traditional
		// procedural code.
		//
		// Our public static void main() method that acts as our entry into the
		// application
		// is in fact a thread. When we create a method that is called within main - it
		// runs parallel to the
		// application at run time - meaning the order of output or execution is now
		// separate from the main application.
		//
		// We can control how threads operate and their respect to each-other - this is
		// in-fact hugely important in getting the most out of our application
		// and available hardware!
	}

	private static void lifeCycle() throws InterruptedException {

		// Threads have many different states that are outlined as part of a STATE Enum
		// State:
		// - NEW
		// - RUNNABLE
		// - BLOCKED
		// - WAITING
		// - TIMED_WAITING
		// - TERMINATED

		// Typically a Thread will be declared, started and then will complete
		// we typically start with:
		// - NEW state; ready to be started, ready to execute.
		// - RUNNABLE state; the thread is actively running and executing commands.
		// - TERMINATED state; the thread has concluded its instruction set and has
		// finished.
		//
		// Let's observe this in action below, with the simple ThreadLifeCycle thread:

		// Starting a thread - NEW
		ThreadLifeCycle thread = new ThreadLifeCycle();
		System.out.println("Thread State: " + thread.getState());

		// Running a thread - RUNNABLE, triggered within the
		thread.start();
		threadMessage(thread, StringConst.DIV.toString());

		// Let's have main wait on this thread, by using join() - we'll look at this
		// afterwards.
		thread.join();

		// Exit/termination of a thread - TERMINATED
		System.out.println("Thread State: " + thread.getState());

		// TODO: Explore BLOCKED, WAITING, TIME_WAITING

		// BLOCKED - is waiting on a monitor lock resolution, we'll investigate this a
		// little more
		// in the near future.

		// WAITING - this thread is actively waiting for another thread to complete a
		// task.
		// This typically manifests when the .wait or .join method has been utilised
		// without a timeout
		// period.

		// TIME_WAITING - this is waiting on a join, sleep, wait or some kind of
		// thread-related
		// that typically has some timeout element before it can proceed.

	}

	private static void threadMessage(Thread x, String msg) {
		String name = x.getName();
		System.out.format("%s : %s\n", name, msg);
	}

	private static void threadControl() throws InterruptedException {
		List<String> myList = List.of("Cat", "Dog", "Penguin", "Seagul");
		List<Integer> myIntList = List.of(15, 21, 32, 14);

		// Threads declared
		ArrayPrint<String> myThread = new ArrayPrint<>(myList);
		ArrayPrint<Integer> myIntThread = new ArrayPrint<>(myIntList);
		ArrayPrintWait<String> myThreadWaits = new ArrayPrintWait<>(myList);
		InterruptThread myThreadInterrupt = new InterruptThread();
		// This example shows that as long as a class implements the Runnable interface
		// we can use it as a thread by passing an instance into a new Thread constructor!
		Thread myLoopIterrupt = new Thread(new MessageInterrupt());

		// Joins
		// ========================================
		myThread.start();
		threadMessage(myThread, StringConst.DIV.toString());
		// Joining a thread
		myThread.join(); // Stops Main to complete this thread
		
		myIntThread.start();
		threadMessage(myIntThread, StringConst.DIV.toString());
		myIntThread.join(); // Stops Main to complete this thread

		// Waits
		// ========================================
		myThreadWaits.start();
		threadMessage(myThreadWaits, StringConst.DIV.toString());
		myThreadWaits.join();
		
		// Interrupts
		// ========================================
		myThreadInterrupt.start();
		threadMessage(myThreadInterrupt, StringConst.DIV.toString());
		myThreadWaits.join();
		
		// Interrupt due to failure on wait		
		long startTime = System.currentTimeMillis();
		long timeLimit = 100;
		
		myLoopIterrupt.start();
		threadMessage(myLoopIterrupt, StringConst.DIV.toString());
		
		// Let's keep track of our thread
		threadMessage(myLoopIterrupt, "Starting process....");
		
		while (myLoopIterrupt.isAlive()) {
			threadMessage(myLoopIterrupt, "Still waiting...");
			
			// Now we pause main for the thread to finish
			myLoopIterrupt.join(50);
			
			// If an iteration takes longer than expected and the thread is alive
			// request a interruption that'll terminate the thread.
			if (((System.currentTimeMillis() - startTime) > timeLimit) && myLoopIterrupt.isAlive()) {
				threadMessage(myLoopIterrupt, "exceeded time limit, requesting interrupt termination!");
				myLoopIterrupt.interrupt();
				
				// We'll wait until our thread terminates
				myLoopIterrupt.join();
			}
		}
		threadMessage(myLoopIterrupt, "State - " + myLoopIterrupt.getState());
		
		// So far we've looked at some examples of procedural threads, pausing main for the benefit
		// of expression of the application through a secondary thread before resuming
		// our main thread.
		//
		// In Concurrency there are conditions of control needed to be understood that require control
		// interactions beyond just joins, let's move onto Concurrency!
	}

}

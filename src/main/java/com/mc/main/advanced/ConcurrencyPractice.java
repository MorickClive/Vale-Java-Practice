package com.mc.main.advanced;

import com.mc.main.advanced.threads.concurrency.ClickerThread;
import com.mc.main.advanced.threads.concurrency.Consumer;
import com.mc.main.advanced.threads.concurrency.Counter;
import com.mc.main.advanced.threads.concurrency.CounterPOJO;
import com.mc.main.advanced.threads.concurrency.CounterSync;
import com.mc.main.advanced.threads.concurrency.Provider;
import com.mc.main.advanced.threads.concurrency.TradeExchange;
import com.mc.main.util.Practice;
import com.mc.main.util.ReportFormater;
import com.mc.main.util.StringConst;

public class ConcurrencyPractice extends Practice {
	
	private static int loops = 1500;

	private ConcurrencyPractice() {
		super();
	}

	public static void start() {
		printHeader("Multi-Threading");
		
		try {
			// When we attempt to access singluar resources with multiple threads, 
			// we can encounter strange behaviour with standard implementation.
			//
			// For the next section, please review CounterPOJO and the "concurrencyRace()" method.
			concurrencyRace(new CounterPOJO(loops));
			
			// To get the most out of having threads running parallel to each other
			// We must first respect the issues of:
			// - Thread Interference: 
			//		Where two or more threads attempt to access a single object attribute or resources
			// - Memory Consistency Issues:
			//		Where memory maybe accessed before reporting, showing a result influenced by
			//		an external thread before being exposed. (review "happens-before" relationships)
			// - The synchronise keyword
			//		- Intrinsic Locks:
			//			or Monitor lock, an Internal state of objects that helps inform
			//			thread ownership.
			//		- Atomic access:
			//			An action or state that happens once or not at all

			// For the next section, please review CounterSync and the "concurrencySynchronized()" method.
			concurrencySynchronized(new CounterSync(loops));
			
			
			// There are many ways we can use Synchronize to establish respect to intrinsic locks
			// Intrinsic or monitor locks are an internal state to objects that are handled.
			//
			// A thread should request exclusive and consistent access to an objects lock
			// in order to inform other threads that this object is being handled specifically by
			// a unique thread.
			//
			// We're not going to investigate additional ways of controlling Synchronization of
			// objects or the manual creation of locks in this project.
			
			// Liveliness 
			// ~ a state of how smooth a concurrent application runs based on continuous
			// running threads - rather than the traffic jam of stalled processes and
			// sluggish behaviour.
			// ========================================
			// Deadlock: 
			//		Thread pair or groups that rely on eachother to proceed internally and thus
			//		forever stuck!
			// Starvation:
			//		A resource that is accessed excessively by a singular thread
			//		as such that it's greed might lock out other threads accessing
			//		the resource and holding reserve thread processes up.
			// Livelock:
			//		Two Threads attempt to interact with eachother to the detriment of another
			//		they aren't stuck so much as they are too busy to proceed and
			//		might attempt to make way for another thread only to infact block it.
			// Immutable values:
			//		Concurrency often works best when threads access immutable values - change
			//		can present considerations for parallel access; immutability makes a value
			//		safer for a thread to utilise as a lookup reference. No doubt is placed on
			//		the variable nature of value shifting.

			// Guarded Block
			// ========================================
			// for those that program applications, you'll understand that most operations are often spun as a
			// result of a while loop iteration; continuously evaluating conditions to see if they are true.
			//
			// Then finally closing or resuming the intended functionality.
			// guarded blocks allow us to introduce reliance on thread change, rather than 
			// this reduces the stress a thread might have by reserving it stall until
			// another thread informs it is appropriate to continue operation.
			guardedBlock();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void guardedBlock() throws InterruptedException {
		// In our example we'll use a one-way trading system, the exchange takes place between
		// two types of thread/objects - a provider and consumer.
		//
		// They'll both need to interact with the TradeExchange Object, a consumer cannot take something
		// until our provider has produced data as part of the exchange.
		ReportFormater.reportHeader("\tGuarded Block");
		TradeExchange exchange = new TradeExchange();
		
		Thread factory = new Thread(new Provider(exchange));
		Thread customer = new Thread(new Consumer(exchange));

		factory.start();
		customer.start();
		
		factory.join();

		System.out.format("%s\n\n", StringConst.DIV);
	}

	private static void sharedCounter(Counter counter) throws InterruptedException {
		// We'll have a global thread with 2 child threads
		// this way the operation is completely seperate and unbias towards Main
		Thread testThread = new Thread() {
			
			public void run() {
				Thread myClickerTrue = new Thread(new ClickerThread(counter, true));
				Thread myClickerFalse = new Thread(new ClickerThread(counter, false));
		
				myClickerTrue.start();
				myClickerFalse.start();
				
				try {
					myClickerFalse.join();
					myClickerTrue.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		testThread.start();
		testThread.join();
		
		int result = (int) counter.value();
		boolean flag = result == 0 | result == loops;
		
		ReportFormater.reportDivided(
			String.format("%s Final Value: %s\n%s", 
					counter.getClass().getSimpleName(), counter.value(),
					flag ? "INFO: Operation Completed successfully!" : 
					"ERROR: An error occurred when accessing Counter")
		);
		System.out.format("Threads resolved!\n\n", StringConst.DIV);
	}
	
	private static void concurrencyRace(CounterPOJO counter) throws InterruptedException {
		// Both threads have an objective, either add 5000 or remove 5000
		// values from a shared resources - myCounter.count;
		//
		// However when we run threads accessing the shared memory location
		// strange behaviour can arise as a result of 2 threads accessing the same
		// resource.
		// because they do not rely on eachother - they don't inform eachother of what
		// they are doing to the shared space.
		ReportFormater.reportHeader("\tConcurrency Race");
		
		sharedCounter(counter);
	}

	private static void concurrencySynchronized(CounterSync counter) throws InterruptedException {
		// In this case, we are doing the same as concurrencyRace, however the Counter Object now
		// implements synchronized behaviour with object access.
		// 
		// This expands the respect of accessing shared resources by allowing us
		// to inform java that this object might be accessed by independent threads and to
		// respect the order of access to avoid unusual behaviour.
		ReportFormater.reportHeader("\tConcurrency Synchronized");
		
		sharedCounter(counter);
	}
	
}

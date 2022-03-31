package com.mc.main.advanced.threads.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClickerThreadUnitTEST {

	private static ClickerThread testClicker;
	private static CounterSync testCounter;
	private static final int iterations = 500;
	
	@BeforeEach
	public void testStart() {
		testCounter = new CounterSync(iterations);
		testClicker = new ClickerThread(testCounter, true);
	}
	
	@Test
	public void constructor() {
		assertTrue(testClicker instanceof ClickerThread);		
	}
	
	//TODO: Implement mocking/concurrency solution
	// Do not implement unit tests that rely on other objects - this is akin to a System test!!!
	@Test
	public void runIncrement() {
		Thread testThread = new Thread(testClicker);
		try {
			testThread.start();
			testThread.join();
			
			assertEquals(iterations, testCounter.value());			
		} catch (Exception e) {
			fail(e);
		}
	}
	
	@Test
	public void runDecrement() {
		testClicker = new ClickerThread(testCounter, false);
		
		Thread testThread = new Thread(testClicker);
		try {
			testThread.start();
			testThread.join();
			
			assertEquals(-iterations, testCounter.value());			
		} catch (Exception e) {
			fail(e);
		}
	}

}

package com.mc.main.advanced.threads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ThreadLifeCycleUnitTEST {
	
	private static ThreadLifeCycle testThread;
	
	@BeforeAll
	public static void setup() {
		testThread = new ThreadLifeCycle();
	}
	
	@Test
	public void constructor() {
		assertTrue(testThread instanceof ThreadLifeCycle);
	}
	
	@Test
	public void run() {
		try {
			testThread.run();
		}catch (Exception e) {
			fail();
		}
		assertTrue(testThread instanceof ThreadLifeCycle);		
	}
	
	@Test
	public void run_failure() throws InterruptedException {
		
		boolean expect;
		
		testThread.start();
		testThread.interrupt();
		expect = testThread.isInterrupted();
		testThread.join();

		assertTrue(expect);
		assertEquals(Thread.State.TERMINATED, testThread.getState());
		assertTrue(testThread instanceof ThreadLifeCycle);		
	}
	
}

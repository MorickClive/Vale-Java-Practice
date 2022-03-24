package com.mc.main.advanced.threads;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MessageInterruptUnitTEST {

	private static long startTime;
	private static long timeLimit = 50;
	private static MessageInterrupt testRunnable;
	
	@BeforeAll
	public static void setup() {
		testRunnable = new MessageInterrupt();
	}
	
	@Test
	public void constructor() {
		assertTrue(testRunnable instanceof MessageInterrupt);
	}
	
	@Test
	public void run() {
		try {
			testRunnable.run();
		}catch (Exception e) {
			fail();
		}
		assertTrue(testRunnable instanceof MessageInterrupt);		
	}
	
	//TODO: Improve failure capture, code refactor likely
	@Test
	public void runFailure() {
		try {
			Thread testThread = new Thread(new MessageInterrupt());
			
			startTime = System.currentTimeMillis();
			testThread.start();
			
			while (testThread.isAlive()) {
				testThread.join(200);
				
				// If an iteration takes longer than expected and the thread is alive
				// request a interruption that'll terminate the thread.
				if (((System.currentTimeMillis() - startTime) > timeLimit) && testThread.isAlive()) {
					testThread.interrupt();
					testThread.join();
				}
			}			
		}catch (Exception e) {
			fail();
		}
		
		assertTrue(testRunnable instanceof MessageInterrupt);		
	}
	
}

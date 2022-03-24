package com.mc.main.advanced.threads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArrayPrintWaitUnitTEST {
	
	private static ArrayPrintWait testThread;
	
	@BeforeAll
	public static void setup() {
		List<String> testList = List.of("cat", "dog", "seagul");
		
		testThread = new ArrayPrintWait(testList);
	}
	
	@Test
	public void constructor() {
		assertTrue(testThread instanceof ArrayPrintWait);
	}
	
	@Test
	public void run() {
		try {
			testThread.run();
		}catch (Exception e) {
			fail();
		}
		assertTrue(testThread instanceof ArrayPrintWait);		
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
		assertTrue(testThread instanceof ArrayPrintWait);		
	}

}

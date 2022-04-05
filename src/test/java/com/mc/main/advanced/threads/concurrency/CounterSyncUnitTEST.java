package com.mc.main.advanced.threads.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterSyncUnitTEST {

	private static CounterSync testCounter;
	private static final int iterations = 50;

	@BeforeEach
	public void testStart() {
		testCounter = new CounterSync(iterations);
	}
	
	@Test
	public void constructor() {
		assertTrue(testCounter instanceof Counter);
		assertTrue(testCounter instanceof CounterSync);
		assertEquals(0, testCounter.value());
	}
	
	@Test
	public void increment() {
		testCounter.increment();
		
		int result = testCounter.value();

		assertEquals(iterations, testCounter.value());	
	}
	
	@Test
	public void decrement() {
		testCounter.decrement();
		
		int result = testCounter.value();

		assertEquals(-iterations, testCounter.value());
	}
	
	@Test
	public void value() {
		int result = testCounter.value();

		assertEquals(0, testCounter.value());
	}

}
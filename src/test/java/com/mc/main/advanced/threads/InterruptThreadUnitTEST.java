package com.mc.main.advanced.threads;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class InterruptThreadUnitTEST {
	
	private static InterruptThread testThread;
	
	@BeforeAll
	public static void setup() {
		testThread = new InterruptThread();
	}
	
	@Test
	public void constructor() {
		assertTrue(testThread instanceof InterruptThread);
	}
	
	@Test
	public void run() {
		try {
			testThread.run();
		}catch (Exception e) {
			fail();
		}
		
		assertTrue(testThread instanceof InterruptThread);
	}
	
	//TODO: Mock crunchNumbers
	@Disabled
	public void crunchNumbers() {}
	
	//TODO: Mock algorithm
	@Disabled
	public void algorithm() {}

}

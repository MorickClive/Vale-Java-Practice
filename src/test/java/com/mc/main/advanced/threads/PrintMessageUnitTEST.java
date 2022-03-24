package com.mc.main.advanced.threads;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrintMessageUnitTEST {
	
	private static PrintMessage testThread;
	
	@BeforeAll
	public static void setup() {
		testThread = new PrintMessage("Standard Message");
	}
	
	@Test
	public void constructor() {
		assertTrue(testThread instanceof PrintMessage);
	}
	
	@Test
	public void run() {
		try {
			testThread.run();
		}catch (Exception e) {
			fail();
		}
		
		assertTrue(testThread instanceof PrintMessage);
	}
	
}

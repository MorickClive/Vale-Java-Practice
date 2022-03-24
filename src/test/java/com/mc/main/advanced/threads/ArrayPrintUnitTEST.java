package com.mc.main.advanced.threads;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArrayPrintUnitTEST {
	
	private static ArrayPrint testThread;
	
	@BeforeAll
	public static void setup() {
		List<String> testList = List.of("cat", "dog", "seagul");
		
		testThread = new ArrayPrint(testList);
	}
	
	@Test
	public void constructor() {
		assertTrue(testThread instanceof ArrayPrint);
	}
	
	@Test
	public void run() {
		try {
			testThread.run();
		}catch (Exception e) {
			fail();
		}
		
		assertTrue(testThread instanceof ArrayPrint);
	}

}

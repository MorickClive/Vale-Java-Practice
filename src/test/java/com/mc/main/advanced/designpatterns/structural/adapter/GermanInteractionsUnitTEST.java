package com.mc.main.advanced.designpatterns.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GermanInteractionsUnitTEST {
	
	private static GermanInteractions testIteraction;

	@BeforeAll
	public static void setup() {
		testIteraction = new GermanInteractions();
	}
	
	@Test
	public void allArgsConstructor() {
		testIteraction = new GermanInteractions();
		
		assertTrue(testIteraction instanceof GermanInteractions);
	}

	@Test
	public void accessGreeting() {
		String expect = "Hallo, willkommen!";
		
		assertEquals(expect, testIteraction.Gruﬂ());
	}

}

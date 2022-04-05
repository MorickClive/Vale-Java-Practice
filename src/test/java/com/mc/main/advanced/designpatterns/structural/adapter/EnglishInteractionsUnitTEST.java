package com.mc.main.advanced.designpatterns.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EnglishInteractionsUnitTEST {
	
	private static EnglishInteractions testIteraction;

	@BeforeAll
	public static void setup() {
		testIteraction = new EnglishInteractions();
	}
	
	@Test
	public void allArgsConstructor() {
		testIteraction = new EnglishInteractions();
		
		assertTrue(testIteraction instanceof EnglishInteractions);
	}

	@Test
	public void accessGreeting() {
		String expect = "Hello!";
		
		assertEquals(expect, testIteraction.greeting());
	}
}

package com.mc.main.advanced.designpatterns.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EnglishToGermanAdapterUnitTest {

	private static EnglishToGermanAdapter testAdapter;

	@BeforeAll
	public static void setup() {
		testAdapter = new EnglishToGermanAdapter(new GermanInteractions());
	}
	
	@Test
	public void allArgsConstructor() {
		testAdapter = new EnglishToGermanAdapter(new GermanInteractions());
		
		assertTrue(testAdapter instanceof EnglishToGermanAdapter);
	}

	@Test
	public void accessGreeting() {
		String expect = "Hallo, willkommen!";
		
		assertEquals(expect, testAdapter.greeting());
	}

}

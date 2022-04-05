package com.mc.main.advanced.threads.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TradeExchangeUnitTEST {

	private static TradeExchange testExchange;
	
	@BeforeEach
	public void testStart() {
		testExchange = new TradeExchange();
	}
	
	@Test
	public void constructor() {
		assertTrue(testExchange instanceof TradeExchange);		
	}

	@Test
	public void putRetrieve() {
		String result, expected;
		
		expected = "Expected";
		testExchange.put(expected);
		result = testExchange.retrieve();
		
		assertEquals(expected, result);
	}
	
	//TODO: add testing for condition where thread wait occurs.

}
package com.mc.main.advanced.threads.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class ConsumerUnitTEST {
	
	private static Consumer testConsumer;
	private static TradeExchange testTradeExchange;

	@BeforeEach
	public void testStart() {
		testTradeExchange = new TradeExchange();
		testConsumer = new Consumer(testTradeExchange);
	}
	
	@Test
	public void constructor() {
		assertTrue(testConsumer instanceof Runnable);
		assertTrue(testConsumer instanceof Consumer);
	}
	
	//TODO: Implement mocking/concurrency solution
	// Do not implement unit tests that rely on other objects - this is akin to a System test!!!
	@Test
	@Timeout(2500)
	public void runTest() {
		Thread testProvider, testConsumer;
		try {
			testConsumer = new Thread(new Consumer(testTradeExchange));
			testProvider = new Thread(new Provider(testTradeExchange));
			
			testProvider.start();
			testConsumer.start();
			
			testProvider.join();
			testConsumer.join();

			assertEquals(Thread.State.TERMINATED, testConsumer.getState());
			assertEquals(Thread.State.TERMINATED, testProvider.getState());
		}catch (Exception e) {
			fail();
		}
	}

}

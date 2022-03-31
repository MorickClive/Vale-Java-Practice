package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ConcurrencyPracticeUnitTEST {

	@Test
	public void concurrencyStart() {
		try {
			ConcurrencyPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
}

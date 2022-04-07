package com.mc.main.java8;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class StreamsPracticeUnitTEST {
	
	@Test
	public void streamsStart() {
		try {
			StreamsPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
}

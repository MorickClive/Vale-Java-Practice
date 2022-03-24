package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ThreadPracticeUnitTEST {

	@Test
	public void threadStart() {
		try {
			ThreadPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
}

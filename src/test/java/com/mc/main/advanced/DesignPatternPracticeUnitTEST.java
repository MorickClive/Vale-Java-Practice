package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class DesignPatternPracticeUnitTEST {

	@Test
	public void exceptionStart() {
		try {
			DesignPatternPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
}

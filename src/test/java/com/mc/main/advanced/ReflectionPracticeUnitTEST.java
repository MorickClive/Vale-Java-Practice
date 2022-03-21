package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ReflectionPracticeUnitTEST {

	@Test
	public void reflectionStart() {
		try {
			ReflectionPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
}

package com.mc.main.advanced.io;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class IOPracticeUnitTEST {
	
	@Test
	public void exceptionStart() {
		try {
			IOPractice.start();
		}catch (Exception e) {
			fail();
		}
	}

}

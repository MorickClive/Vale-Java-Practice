package com.mc.main.advanced.ui;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ScannerPracticeUnitTEST {
	
	@Test
	public void exceptionStart() {
		try {
			ScannerPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
}

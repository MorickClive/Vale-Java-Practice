package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.mc.main.advanced.IOPractice;

public class IOPracticeUnitTEST {
	
	@Test
	public void ioPracticeStart() {
		try {
			IOPractice.start();
		}catch (Exception e) {
			fail();
		}
	}

}

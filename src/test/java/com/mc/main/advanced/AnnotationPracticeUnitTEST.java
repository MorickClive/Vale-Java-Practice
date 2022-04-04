package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AnnotationPracticeUnitTEST {

	@Test
	public void annotationStart() {
		try {
			AnnotationPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
}

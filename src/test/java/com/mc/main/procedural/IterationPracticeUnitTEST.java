package com.mc.main.procedural;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IterationPracticeUnitTEST {
	
	private static float[] array;
	private static float expected;
	
	@BeforeAll
	public static void start() {
		array = new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		expected = 55.0f;
	}

	@Test
	public void startMethod() {
		try {
			IterationPractice.start();
		} catch (Exception e) {
			fail(e);
		}
	}
	
	@Test
	public void sumForLoopTest() {
		float result = IterationPractice.sumForLoop(this.array);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void sumForEachTest() {
		float result = IterationPractice.sumForEach(this.array);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void sumWhileTest() {
		float result = IterationPractice.sumWhile(this.array);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void sumDoWhileTest() {
		float result = IterationPractice.sumDoWhile(this.array);
		
		assertEquals(expected, result);
	}

}

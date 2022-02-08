package com.mc.main.procedural;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArraysPracticeUnitTest {

	@BeforeAll
	public static void init() {
	}

	@Test
	public void startMethod() {
		try {
			ArraysPractice.start();
		} catch (Exception e) {
			fail(e);
		}
	}

	@Test
	public void createPrimativeIntegerArray_Size_Test() {
		int[] array = ArraysPractice.createPrimativeIntegerArray(5);
		
		assertEquals(5, array.length);
	}

	@Test
	public void createPrimativeIntegerArray_Parameters_Test() {
		int[] array = ArraysPractice.createPrimativeIntegerArray(1,2,3,4);

		assertEquals(4, array[array.length-1]);
		assertEquals(2, array[1]);
	}

	@Test
	public void createIntegerListTest() {
		List<Integer> array = ArraysPractice.createIntegerList(5);
		
		assertEquals(5, array.size());
	}

	@AfterAll
	public static void cleanup() {
	}
}

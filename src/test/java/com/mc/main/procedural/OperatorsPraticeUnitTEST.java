package com.mc.main.procedural;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OperatorsPraticeUnitTEST {
	
	@BeforeAll
	public static void init() {
		OperatorsPractice.start();
	}

	@Test
	public void testAdd() {
		float result = OperatorsPractice.addition(3, 5);
		
		assertEquals(8, result);
	}
	
	@Test
	public void testSub() {
		float result = OperatorsPractice.subtraction(12, 5);
		
		assertEquals(7, result);
	}
	
	@Test
	public void testMult() {
		float result = OperatorsPractice.multiplication(5, 5);
		
		assertEquals(25, result);
	}
	
	@Test
	public void testDiv() {
		float result = OperatorsPractice.division(12, 4);
		
		assertEquals(3, result);
	}

	@Test
	public void testMod() {
		float result = OperatorsPractice.modulus(15, 4);
		
		assertEquals(3, result);
	}
	
	@Test
	public void testIncrement() {
		float result = 5;
		
		result = OperatorsPractice.incrementPositive(result);
		
		assertEquals(6, result);
	}
	
	@Test
	public void testDecrement() {
		float result = 5;
		
		result = OperatorsPractice.incrementNegative(result);
		
		assertEquals(4, result);
	}

}

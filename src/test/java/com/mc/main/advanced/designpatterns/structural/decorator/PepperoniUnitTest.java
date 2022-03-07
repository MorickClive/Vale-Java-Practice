package com.mc.main.advanced.designpatterns.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mc.main.advanced.designpatterns.structural.PizzaBase;

public class PepperoniUnitTest {
	
	private static Pepperoni testDecoration;
	
	@BeforeAll
	public static void setup() {
		testDecoration = new Pepperoni(new PizzaBase());
	}

	@Test
	public void defaultConstructor() {
		testDecoration = new Pepperoni(new PizzaBase());
		
		assertTrue(testDecoration instanceof Pepperoni);
	}	

	@Test
	public void accessPrice() {
		double expect = 6.25;
		
		assertEquals(expect, testDecoration.price());
	}

	@Test
	public void accessDescription() {
		String expect = "This pizza has the following:\nA base, pepperoni slices";
		
		assertEquals(expect, testDecoration.description());
	}
	
}

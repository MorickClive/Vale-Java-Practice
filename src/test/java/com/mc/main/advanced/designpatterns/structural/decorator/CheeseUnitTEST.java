package com.mc.main.advanced.designpatterns.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mc.main.advanced.designpatterns.structural.PizzaBase;

public class CheeseUnitTEST {
	
	private static Cheese testDecoration;
	
	@BeforeAll
	public static void setup() {
		testDecoration = new Cheese(new PizzaBase());
	}
	
	@Test
	public void defaultConstructor() {
		testDecoration = new Cheese(new PizzaBase());
		
		assertTrue(testDecoration instanceof Cheese);
	}	

	@Test
	public void accessPrice() {
		double expect = 5.75;
		
		assertEquals(expect, testDecoration.price());
	}

	@Test
	public void accessDescription() {
		String expect = "This pizza has the following:\nA base, gratted cheese";
		
		assertEquals(expect, testDecoration.description());
	}
	
}

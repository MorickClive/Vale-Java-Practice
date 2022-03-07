package com.mc.main.advanced.designpatterns.structural;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PizzaBaseUnitTest {

	private static PizzaBase testPizza;
	
	@BeforeAll
	public static void setup() {
		testPizza = new PizzaBase();
	}
	
	@Test
	public void defaultConstructor() {
		testPizza = new PizzaBase();
		
		assertTrue(testPizza instanceof PizzaBase);
	}	

	@Test
	public void accessPrice() {
		double expect = 5.0;
		
		assertEquals(expect, testPizza.price());
	}

	@Test
	public void accessDescription() {
		String expect = "This pizza has the following:\nA base";
		
		assertEquals(expect, testPizza.description());
	}

}

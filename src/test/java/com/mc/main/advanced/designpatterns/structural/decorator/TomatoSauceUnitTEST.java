package com.mc.main.advanced.designpatterns.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mc.main.advanced.designpatterns.structural.PizzaBase;


public class TomatoSauceUnitTEST {
	
	private static TomatoSauce testDecoration;
	
	@BeforeAll
	public static void setup() {
		testDecoration = new TomatoSauce(new PizzaBase());
	}
	
	@Test
	public void defaultConstructor() {
		testDecoration = new TomatoSauce(new PizzaBase());
		
		assertTrue(testDecoration instanceof TomatoSauce);
	}	

	@Test
	public void accessPrice() {
		double expect = 6.5;
		
		assertEquals(expect, testDecoration.price());
	}

	@Test
	public void accessDescription() {
		String expect = "This pizza has the following:\nA base, a layer of tomato sauce";
		
		assertEquals(expect, testDecoration.description());
	}

}

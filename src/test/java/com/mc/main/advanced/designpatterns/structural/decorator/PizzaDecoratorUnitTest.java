package com.mc.main.advanced.designpatterns.structural.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.mc.main.advanced.designpatterns.structural.PizzaBase;

public class PizzaDecoratorUnitTest {
	
	private static Cheese testDecorator;

	@BeforeAll
	public static void setup() {
		testDecorator = new Cheese(new PizzaBase());
	}
	
	// TODO: provide decorator without composite concrete class relationship
	@Disabled
	public void defaultConstructor() {}
	
	@Test
	public void allArgsConstructor() {
		testDecorator = new Cheese(new PizzaBase());
		
		assertTrue(testDecorator instanceof PizzaDecorator);
	}

	// TODO: provide decorator without composite concrete class relationship
	@Test
	public void accessPrice() {
		double expect = 5.75;
		
		assertEquals(expect, testDecorator.price());
	}

	// TODO: provide decorator without composite concrete class relationship
	@Test
	public void accessDescription() {
		String expect = "This pizza has the following:\nA base, gratted cheese";
		
		assertEquals(expect, testDecorator.description());
	}
		
}

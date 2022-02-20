package com.mc.main.oop.principles.res;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnimalUnitTEST {

	private Animal animal;
	
	@BeforeEach
	public void setupTest() {
		animal = new Animal("Fred");
	}

	@Test
	public void defaultConstructorTEST() {
		animal = new Animal();
		
		assertTrue(animal instanceof Animal);
		assertEquals("[x:0, y:0]", animal.strPosition());
		assertArrayEquals(new int[] {0, 0}, animal.getPosition());
	}
	
	@Test
	public void allArgsConstructorTEST() {		
		assertTrue(animal instanceof Animal);
		assertEquals("Fred", animal.getName());
		assertEquals("[x:0, y:0]", animal.strPosition());
		assertArrayEquals(new int[] {0, 0}, animal.getPosition());
	}
	
	@Test
	public void accessNameTEST() {
		animal.setName("Burger");
		
		assertTrue(animal instanceof Animal);
		assertEquals("Burger", animal.getName());
	}
	
	@Test
	public void accessPositionTEST() {
		animal.setPosition(15, 15);
		
		assertTrue(animal instanceof Animal);
		assertArrayEquals(new int[] {15, 15}, animal.getPosition());
	}
	
	@Test
	public void stringPositionTEST() {
		animal.setPosition(25, 25);
		
		assertTrue(animal instanceof Animal);
		assertEquals("[x:25, y:25]", animal.strPosition());
	}
	
	@Test
	public void moveTEST() {
		animal.move(15, 5);
		
		assertTrue(animal instanceof Animal);
		assertEquals("[x:15, y:5]", animal.strPosition());
		assertArrayEquals(new int[] {15, 5}, animal.getPosition());
	}	
	
	@Test
	public void speechTEST() {
		assertTrue(animal instanceof Animal);
		assertEquals("*Undiscernable noise*", animal.speak());
	}
	
}

package com.mc.main.oop.principles.res.polymorph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.oop.principles.res.polymorph.Dog;

public class DogUnitTEST {

	private Dog dog;
	
	@BeforeEach
	public void setupTest() {
		dog = new Dog("Fido");
	}

	@Test
	public void defaultConstructorTEST() {
		dog = new Dog();
		
		assertTrue(dog instanceof Dog);
		assertEquals("[x:0, y:0]", dog.strPosition());
		assertArrayEquals(new int[] {0, 0}, dog.getPosition());
	}
	
	@Test
	public void allArgsConstructorTEST() {		
		assertTrue(dog instanceof Dog);
		assertEquals("Fido", dog.getName());
		assertEquals("[x:0, y:0]", dog.strPosition());
		assertArrayEquals(new int[] {0, 0}, dog.getPosition());
	}
	
	@Test
	public void speechTest() {
		assertEquals("Fido says Woof!", dog.speak());
	}
	
}

package com.mc.main.oop.principles.res.polymorph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.oop.principles.res.polymorph.Cat;

public class CatUnitTest {
	
	private Cat cat;
	
	@BeforeEach
	public void setupTest() {
		cat = new Cat("Tesla");
	}

	@Test
	public void defaultConstructorTEST() {
		cat = new Cat();
		
		assertTrue(cat instanceof Cat);
		assertEquals("[x:0, y:0]", cat.strPosition());
		assertArrayEquals(new int[] {0, 0}, cat.getPosition());
	}
	
	@Test
	public void allArgsConstructorTEST() {		
		assertTrue(cat instanceof Cat);
		assertEquals("Tesla", cat.getName());
		assertEquals("[x:0, y:0]", cat.strPosition());
		assertArrayEquals(new int[] {0, 0}, cat.getPosition());
	}
	
	@Test
	public void speechTest() {
		assertEquals("Tesla says Meow!", cat.speak());
	}
}

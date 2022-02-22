package com.mc.main.oop.structs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.oop.principles.res.abstraction.Bird;
import com.mc.main.oop.principles.res.abstraction.Penguin;

public class GenericsPracticeUnitTEST {
	
	private GenericsPractice.Cage<Bird> testCage;
	private final Penguin testBird = new Penguin("Emperor Penguin");
	private final String cageType = "Small";
	
	@BeforeEach
	public void startupTest() {
		testCage = new GenericsPractice.Cage<>(cageType, testBird);
		
		assertTrue(testCage instanceof GenericsPractice.Cage<?>);
	}
	
	@Test
	public void startTest() {
		GenericsPractice.start();
		
		assertTrue(testCage instanceof GenericsPractice.Cage<?>);
	}
	
	@Test
	public void defaultNestedConstructor() {
		testCage = new GenericsPractice.Cage<>();
		
		assertTrue(testCage instanceof GenericsPractice.Cage<?>);
		assertTrue(testCage.getBird() == null);
		assertEquals("Standard", testCage.getCageType());
	}
	
	@Test
	public void nestedConstructor1() {
		testCage = new GenericsPractice.Cage<>("Large");
		
		assertTrue(testCage instanceof GenericsPractice.Cage<?>);
		assertTrue(testCage.getBird() == null);
		assertEquals("Large", testCage.getCageType());
	}
	
	@Test
	public void allArgsNestedConstructor() {
		assertTrue(testCage instanceof GenericsPractice.Cage<?>);
		assertTrue(testCage.getBird() instanceof Bird);
		assertEquals("Small", testCage.getCageType());
	}
	
	@Test
	public void accessCageType() {
		testCage.setCageType("Medium");
		
		assertEquals("Medium", testCage.getCageType());
	}
	
	@Test
	public void accessBird() {
		testCage = new GenericsPractice.Cage<>();
		testCage.insertBird(new Penguin("Adélie Penguin"));
		Bird result = testCage.getBird();

		assertTrue(result instanceof Bird);
		assertEquals("Adélie Penguin", result.getSpecies());
	}
	
	@Test
	public void viewBird() {
		String expected = String.format(
				"It appears there is a %s within this %s cage.",
				"Emperor Penguin", "Large");
		Bird resultBird = testCage.getBird();
		
		testCage.setCageType("Large");
		testCage.insertBird(resultBird);
		
		assertTrue(resultBird instanceof Bird);
		assertEquals(expected, testCage.viewBird());
	}
	
	@Test
	public void viewBirdFailure() {
		String expected = String.format(
				"There is no bird in this %s cage.",
				"Large");
		
		testCage.setCageType("Large");
		testCage.getBird();
			
		assertTrue(testCage.getBird() == null);
		assertEquals(expected, testCage.viewBird());
	}
	
}

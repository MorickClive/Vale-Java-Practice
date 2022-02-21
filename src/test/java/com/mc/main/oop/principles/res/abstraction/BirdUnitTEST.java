package com.mc.main.oop.principles.res.abstraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BirdUnitTEST {
	
	// Abstract classes cannot be tested directly
	// so we use the nearest concrete implementation
	// that exposes the interface!
	private Penguin birdExample; 
	private final String species = "Emperor Penguin";
	
	@BeforeEach
	public void setupTest() {
		birdExample = new Penguin(species);
	}	
	
	@Test
	public void defaultConstructor() {
		birdExample = new Penguin();
		
		assertTrue(birdExample instanceof Bird);
	}
	
	@Test
	public void fullArgsConstructor() {
		assertTrue(birdExample instanceof Bird);
		assertEquals(species, birdExample.getSpecies());
	}
	
	@Test
	public void accessSpecies() {
		birdExample.setSpecies("King Penguin");
		
		assertTrue(birdExample instanceof Bird);
		assertEquals("King Penguin", birdExample.getSpecies());
	}
	
	@Test
	public void speech() {
		assertTrue(birdExample instanceof Bird);
		// This cannot be tested without mocking or accessing parent implementation
		// which would not be standard practice due to intentional access override through
		// polymorphic behaviour.
		// TODO: Coverage of Bird.speak();
	}

}

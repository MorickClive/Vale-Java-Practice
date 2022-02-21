package com.mc.main.oop.principles.res.abstraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PenguinUnitTEST {
	private Penguin penguinExample; 
	private final String species = "Emperor Penguin";
	
	@BeforeEach
	public void setupTest() {
		penguinExample = new Penguin(species);
	}	
	
	@Test
	public void defaultConstructor() {
		penguinExample = new Penguin();
		
		assertTrue(penguinExample instanceof Penguin);
	}
	
	@Test
	public void fullArgsConstructor() {
		assertTrue(penguinExample instanceof Penguin);
		assertEquals(species, penguinExample.getSpecies());
	}
	
	@Test
	public void accessSpecies() {
		penguinExample.setSpecies("King Penguin");
		
		assertTrue(penguinExample instanceof Penguin);
		assertEquals("King Penguin", penguinExample.getSpecies());
	}
	
	@Test
	public void speech() {
		assertTrue(penguinExample instanceof Penguin);
		assertEquals("The Emperor Penguin gaks!", penguinExample.speak());
	}

}

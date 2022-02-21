package com.mc.main.oop.principles.res.abstraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeagulUnitTEST  {

	// Abstract classes cannot be tested directly
	// so we use the nearest concrete implementation
	// that exposes the interface!
	private Seagul seagulExample; 
	private final String species = "Common Seagul";
	
	@BeforeEach
	public void setupTest() {
		seagulExample = new Seagul(species, true);
	}	
	
	@Test
	public void defaultConstructor() {
		seagulExample = new Seagul();
		
		assertTrue(seagulExample instanceof Seagul);
	}	
	
	@Test
	public void constructor1() {
		seagulExample = new Seagul(species);
		
		assertTrue(seagulExample instanceof Seagul);
		assertEquals(species, seagulExample.getSpecies());
	}
	
	@Test
	public void fullArgsConstructor() {
		assertTrue(seagulExample instanceof Seagul);
		assertTrue(seagulExample.isFlying());
		assertEquals(species, seagulExample.getSpecies());
	}
	
	@Test
	public void speech() {
		assertTrue(seagulExample instanceof Seagul);
		assertEquals("The Common Seagul mockingly laughs!", seagulExample.speak());
	}
	
}

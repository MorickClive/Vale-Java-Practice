package com.mc.main.oop.principles.res.abstraction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlyingBirdUnitTEST {
		// Abstract classes cannot be tested directly
		// so we use the nearest concrete implementation
		// that exposes the interface!
		private Seagul flyingBirdExample; 
		private final String species = "Common Seagul";
		
		@BeforeEach
		public void setupTest() {
			flyingBirdExample = new Seagul(species, true);
		}	
		
		@Test
		public void defaultConstructor() {
			flyingBirdExample = new Seagul();
			
			assertTrue(flyingBirdExample instanceof FlyingBird);
		}	
		
		@Test
		public void constructor1() {
			flyingBirdExample = new Seagul(species);
			
			assertTrue(flyingBirdExample instanceof FlyingBird);
			assertEquals(species, flyingBirdExample.getSpecies());
		}
		
		@Test
		public void fullArgsConstructor() {
			assertTrue(flyingBirdExample instanceof FlyingBird);
			assertTrue(flyingBirdExample.isFlying());
			assertEquals(species, flyingBirdExample.getSpecies());
		}
		
		@Test
		public void accessSpecies() {
			flyingBirdExample.setSpecies("Black-Tailed Seagul");
			
			assertTrue(flyingBirdExample instanceof FlyingBird);
			assertEquals("Black-Tailed Seagul", flyingBirdExample.getSpecies());
		}
		
		@Test
		public void accessIsFlyingTrue() {
			flyingBirdExample = new Seagul(species, false);
			flyingBirdExample.fly();
			
			assertTrue(flyingBirdExample.isFlying());
		}
		
		@Test
		public void accessIsFlyingFalse() {
			flyingBirdExample.land();
			
			assertFalse(flyingBirdExample.isFlying());
		}
		
		@Test
		public void accessIsFlyingWarning() {
			flyingBirdExample = new Seagul(species, true);
			flyingBirdExample.fly();
			
			assertTrue(flyingBirdExample.isFlying());
		}
		
		@Test
		public void accessIsFlyingFalseWarning() {
			flyingBirdExample = new Seagul(species, false);
			flyingBirdExample.land();
			
			assertFalse(flyingBirdExample.isFlying());
		}
		
}

package com.mc.main.oop.structs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mc.main.oop.structs.EnumerationPractice.Planet;

public class EnumerationPracticeUnitTEST {
	
	@Test
	public void startTest() {
		EnumerationPractice.start();
	}
	
	@Test
	public void defaultNestedConstructor() {
		Planet planet = Planet.EARTH;
		
		assertTrue(planet instanceof Planet);
	}
	
	@Test
	public void nestedGetHoursDay() {
		Planet planet = Planet.EARTH;

		assertTrue(planet instanceof Planet);
		assertEquals(24.0, planet.getHoursInDay());
	}
	
}

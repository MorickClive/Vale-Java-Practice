package com.mc.main.oop.classres;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClassAdvancedPracticeUnitTEST {
	
	private ClassAdvancedPractice instance;
	
	
	@Test
	public void constructorDefaultTEST() {
		instance = new ClassAdvancedPractice();
		
		assertTrue(instance instanceof ClassAdvancedPractice);
	}	
	
	@Test
	public void constructorParam1TEST() {
		instance = new ClassAdvancedPractice(1, "My_Advanced_Instance_1");
		
		assertTrue(instance instanceof ClassAdvancedPractice);
		assertEquals("My_Advanced_Instance_1", instance.name);
		assertEquals(1, instance.id);
	}
	
	@Test
	public void constructorParam2TEST() {
		instance = new ClassAdvancedPractice("My_Advanced_Instance_2");
		
		assertTrue(instance instanceof ClassAdvancedPractice);
		assertEquals("My_Advanced_Instance_2", instance.name);
		assertEquals(ClassAdvancedPractice.idTracker - 1, instance.id); 
		// Remember, the instance has prepared the next value
	}
	
	@Test
	public void methodExampleTEST() {
		instance = new ClassAdvancedPractice("My_Instance_3");
		
		assertTrue(instance instanceof ClassAdvancedPractice);
		assertTrue(instance.example());
	}

	@Test
	public void staticMethodGetIdTrackerTEST() {
		instance = new ClassAdvancedPractice("My_Instance_4");
		
		assertEquals(ClassAdvancedPractice.getIdTracker() - 1, instance.id);
	}
}

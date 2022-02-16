package com.mc.main.oop.classres;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ClassPracticeUnitTEST {
	
	@Test
	public void constructorDefaultTEST() {
		ClassPractice instance = new ClassPractice();
		
		assertTrue(instance instanceof ClassPractice);
	}	
	
	@Test
	public void constructorParam1TEST() {
		ClassPractice instance = new ClassPractice("My_Instance_1");
		
		assertTrue(instance instanceof ClassPractice);
		assertEquals("My_Instance_1", instance.name);
	}
	
	@Test
	public void methodReturnNameTEST() {
		ClassPractice instance = new ClassPractice("My_Instance_2");
		
		assertTrue(instance instanceof ClassPractice);
		assertEquals("This objects name is: My_Instance_2", instance.returnName());
	}
	
	@Test
	public void staticMethodReturnMessageTEST() {		
		assertEquals("This is ClassPractice message", ClassPractice.returnMessage());
	}	

}

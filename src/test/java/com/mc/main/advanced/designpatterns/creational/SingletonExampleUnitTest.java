package com.mc.main.advanced.designpatterns.creational;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SingletonExampleUnitTest {
	
	private static SingletonExample testObj;
	
	@BeforeAll
	public static void setup() {
		testObj = SingletonExample.getInstance();

		// getInstance where SingletonExample.example is null
		assertTrue(testObj instanceof SingletonExample);
	}
	
	@Test
	public void defaultConstructor() {
		String expected = "This String will never change!";
		testObj = SingletonExample.getInstance();

		assertTrue(testObj instanceof SingletonExample);
		assertEquals(expected, testObj.getMessage());
	}
	
	@Test
	public void getInstance() {
		testObj = SingletonExample.getInstance();

		assertTrue(testObj instanceof SingletonExample);
	}
	
	@Test
	public void getMessage(){
		String expected = "New message";
		
		testObj = SingletonExample.getInstance();
		testObj.setMessage(expected);
		
		assertTrue(testObj instanceof SingletonExample);
		assertEquals(expected, testObj.getMessage());
	}
}

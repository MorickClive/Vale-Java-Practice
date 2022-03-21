package com.mc.main.advanced.reflect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrivateCalculatorUnitTEST {

	private static Class<PrivateCalculator> testClass;
	private static Constructor<?> testConstructor;
	private static Method testMessage, testAdd;
	
	@BeforeAll
	public static void setup() throws NoSuchMethodException, SecurityException {
		testClass = PrivateCalculator.class;
		
		testConstructor = testClass.getDeclaredConstructor();
		testMessage = testClass.getDeclaredMethod("message");
		testAdd = testClass.getDeclaredMethod("add", int.class, int.class);
		
		testConstructor.setAccessible(true);
		testMessage.setAccessible(true);
		testAdd.setAccessible(true);
	}
	
	@AfterAll
	public static void cleanUp() throws NoSuchMethodException, SecurityException {
		testConstructor.setAccessible(true);
		testMessage.setAccessible(false);
		testAdd.setAccessible(false);
	}
	
	@Test	
	public void message() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String expect = "message!";
		String actual = (String) testMessage.invoke(PrivateCalculator.class);
		
		assertEquals(expect, actual);
	}
	
	@Test
	public void add() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
		int expect = 25;
		int actual = (int) testAdd.invoke((PrivateCalculator) testConstructor.newInstance(), 15, 10);
		
		assertEquals(expect, actual);	
	}

}

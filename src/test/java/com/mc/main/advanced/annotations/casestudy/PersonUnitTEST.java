package com.mc.main.advanced.annotations.casestudy;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.protobuf.Field;

public class PersonUnitTEST {
	
	private static Person testObj;
	
	@BeforeEach
	public void testStart() {
		testObj = new Person("Caspian", "Lovett", "28");
	}

	@Test
	public void constructor() {
		testObj = new Person();
		assertTrue(testObj instanceof Person);
	}
	
	@Test
	public void constructor1() {
		assertTrue(testObj instanceof Person);
	}
	
	@Test
	public void initNames() {
		Class<?> clazz = testObj.getClass();
		Method targetMethod;
		
		try {
			targetMethod = clazz.getDeclaredMethod("initNames");
			targetMethod.setAccessible(true);
			targetMethod.invoke(testObj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
}

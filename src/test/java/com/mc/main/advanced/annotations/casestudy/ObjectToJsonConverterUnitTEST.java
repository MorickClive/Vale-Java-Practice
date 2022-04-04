package com.mc.main.advanced.annotations.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectToJsonConverterUnitTEST {
	
	private static Person testObj;
	
	@BeforeEach
	public void testStart() {
		testObj = new Person("Caspian", "Lovett", "28");
	}

	@Test
	public void convertToJson() throws Exception {
		String expect = "{\"forename\":\"Caspian\",\"surname\":\"Lovett\",\"Age\":\"28\"}";
		String result = ObjectToJsonConverter.convertToJson(testObj);
		
		assertTrue(testObj instanceof Person);
		assertEquals(expect, result);
	}

	@Test
	public void initNames() {
		Method targetMethod;
		String expect = "{\"forename\":\"Caspian\",\"surname\":\"Lovett\",\"Age\":\"28\"}";
		
		try {
			targetMethod = ObjectToJsonConverter.class.getDeclaredMethod("getJsonString", Object.class);
			targetMethod.setAccessible(true);
			String result = (String) targetMethod.invoke(ObjectToJsonConverter.class, testObj);
			
			assertTrue(testObj instanceof Person);
			assertEquals(expect, result);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail();
		}
	}
	
	@Test
	public void prepareObject() {
		Method targetMethod;
		
		try {
			targetMethod = ObjectToJsonConverter.class.getDeclaredMethod("prepareObject", Object.class);
			targetMethod.setAccessible(true);
			targetMethod.invoke(targetMethod, testObj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void isSerializableFailure1() {
		Method targetMethod;
		
		try {
			targetMethod = ObjectToJsonConverter.class.getDeclaredMethod("isSerializable", Object.class);
			targetMethod.setAccessible(true);
			targetMethod.invoke(targetMethod, new Object());
			fail();
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void isSerializableFailure2() {
		Method targetMethod;
		
		try {
			targetMethod = ObjectToJsonConverter.class.getDeclaredMethod("isSerializable", Object.class);
			targetMethod.setAccessible(true);
			targetMethod.invoke(targetMethod, null);
			fail();
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
			assertTrue(true);
		}
	}

	@Test
	public void isSerializable() {
		Method targetMethod;
		
		try {
			targetMethod = ObjectToJsonConverter.class.getDeclaredMethod("isSerializable", Object.class);
			targetMethod.setAccessible(true);
			targetMethod.invoke(targetMethod, testObj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
			fail(e.getMessage());
		}
	}
		
	@Test
	public void getKey() {
		Class<?> clazz = testObj.getClass();
		Method targetMethod;
		Field testField;
		
		String result;
		String expect = "Age";
		
		try {
			targetMethod = ObjectToJsonConverter.class.getDeclaredMethod("getKey", Field.class);
			testField = clazz.getDeclaredField("age");
			targetMethod.setAccessible(true);
			result = (String) targetMethod.invoke(targetMethod, testField);
			
			assertEquals(expect, result);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			fail(e.getMessage());
		}
		
	}
}

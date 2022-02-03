package com.mc.main.procedural;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VariablesPracticeUnitTEST {
	
	private static VariablesPractice classObject;

	//TODO Create Unit test to prove data type storage accuracy and default values!
	@BeforeAll
	public static void init() {
		System.out.println("value: " + VariablesPractice.defaultByte());

	}
	
	@Test
	public void initTest() {
		try {
			VariablesPractice.start();
		} catch(Exception e) {
			System.out.println("Method completion failure");
			fail();
		}
	}
	
	// default values
	@Test
	public void defaultByteTest() {
		assertEquals(0, VariablesPractice.defaultByte());
	}
	
	@Test
	public void defaultShortTest() {
		assertEquals(0, VariablesPractice.defaultShort());
	}
	
	@Test
	public void defaultIntegerTest() {
		assertEquals(0, VariablesPractice.defaultInteger());
	}
	
	@Test
	public void defaultLongTest() {
		assertEquals(0.0f, VariablesPractice.defaultLong());
	}
	
	@Test
	public void defaultFloatTest() {
		assertEquals(0.0f, VariablesPractice.defaultFloat());
	}
	
	@Test
	public void defaultDoubleTest() {
		assertEquals(0.0, VariablesPractice.defaultDouble());
	}
	
	@Test
	public void defaultBoolTest() {
		assertEquals(false, VariablesPractice.defaultBool());
	}
	
	@Test
	public void defaultCharTest() {
		assertEquals(0, VariablesPractice.defaultChar());
	}
	
	// Testing casting
	@Test
	public void castToDouble_directCastTest() {
		// It is important to remember that casting from a float to double will cause a precision error
		// Java will consider the equivalent value in the respective memory space
		// Doubles are 64-bit rather than floats which are stored in a 32-bit memory space.
		// floats cast to a higher memory allocation will be translated to higher precision.
		assertNotEquals(10.1D, VariablesPractice.castToDouble_directCast(10.1f));
		assertEquals(10.100000381469727D, VariablesPractice.castToDouble_directCast(10.1f));
	}
	
	@Test
	public void castToDouble_Assignment() {
		// It is important to remember that casting from a float to double will cause a precision error
		// Java will consider the equivalent value
		// Doubles are 64-bit rather than floats which are stored in a 32-bit memory space.
		// floats cast to a higher memory allocation will be translated to higher precision.
		assertNotEquals(10.1D, VariablesPractice.castToDouble_Assignment(10.1f));
		assertEquals(10.100000381469727D, VariablesPractice.castToDouble_Assignment(10.1f));
	}	
	
	@Test
	public void castToFloat_Assignment() {
		assertEquals(10.1f, VariablesPractice.castToFloat_Assignment(10.1D));
	}

	
	@AfterAll
	public static void cleanup() {
		classObject = null;
	}
	
}

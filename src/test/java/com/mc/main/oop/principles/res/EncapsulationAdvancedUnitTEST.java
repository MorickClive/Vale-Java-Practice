package com.mc.main.oop.principles.res;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncapsulationAdvancedUnitTEST {
	
	private EncapsulationAdvanced.Employee nestedObject;
	
	@BeforeEach
	public void testSetup() {
		nestedObject = new EncapsulationAdvanced.Employee("Alex", "£xx,xxxx", "Software Engineer");	
	}

	@Test
	public void startTest() {
		EncapsulationAdvanced.start();
	}
	
	// InnerClass: Employee
	// ========================================
	@Test
	public void nestedDefaultConstructor() {
		EncapsulationAdvanced.Employee employee = new EncapsulationAdvanced.Employee();
		
		assertTrue(employee instanceof EncapsulationAdvanced.Employee);
		assertEquals("???", employee.getName());
		assertEquals("???", employee.getWage());
		assertEquals("???", employee.getRole());
	}
	
	@Test
	public void nestedDefaultConstructorOne() {
		EncapsulationAdvanced.Employee employee = new EncapsulationAdvanced.Employee("Alex", "£xx,xxxx", "Software Engineer");
		
		assertTrue(employee instanceof EncapsulationAdvanced.Employee);
		assertEquals(nestedObject.getName(), employee.getName());
		assertEquals(nestedObject.getWage(), employee.getWage());
		assertEquals(nestedObject.getRole(), employee.getRole());
	}
	
	@Test
	public void nestedAccessName() {
		nestedObject.setName("Alan");

		assertTrue(nestedObject instanceof EncapsulationAdvanced.Employee);
		assertEquals("Alan", nestedObject.getName());
	}
	
	@Test
	public void nestedAccessWage() {
		nestedObject.setWage("£yy,yyyy");
	
		assertTrue(nestedObject instanceof EncapsulationAdvanced.Employee);
		assertEquals("£yy,yyyy", nestedObject.getWage());
	}
	
	@Test
	public void nestedAccessRole() {
		nestedObject.setRole("Tester");
	
		assertTrue(nestedObject instanceof EncapsulationAdvanced.Employee);
		assertEquals("Tester", nestedObject.getRole());
	}
}

package com.mc.main.java8;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.mc.main.advanced.ReflectionPractice;

public class FunctInterfacePracticeUnitTEST {
	
	@Test
	public void funcInterStart() {
		try {
			FunctInterfacePractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void print() {
		try {
			FunctInterfacePractice.print( () -> System.out.println("test"));
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void printParam() {
		try {
			FunctInterfacePractice.print( (y) -> System.out.println("test - " + y));
		}catch (Exception e) {
			fail();
		}
	}
	
}

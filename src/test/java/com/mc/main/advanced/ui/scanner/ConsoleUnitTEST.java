package com.mc.main.advanced.ui.scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ConsoleUnitTEST {
	
	//TODO: add tests to control private static context
	//TODO: Mocking
	private static final String userInput = "TEST_WORD";
	private static final String div = StringConst.DIV;
	private static int testCount;
	
	@BeforeEach
	@Disabled
	public void beforeTest() {
		System.out.println(div+"\nScanner Test #" + ++testCount + "\n"+div);
		Console.mockSetup();
		Console.setMockInputStreamMessage(userInput);
	}

	@AfterEach
	@Disabled
	public void afterTest() {
		Console.mockCleanUp();
		System.out.println("\nTest #" + testCount + " END\n" + div + "\n");
	}
	
	@AfterAll
	@Disabled
	public static void CleanUp() {
		System.out.println(div+"\nCleaning Up Test Resources\n" + div);
		Console.mockCleanUp();
		// Console.close(); - closed as part of runner test/conflict occurs
		// issue associated with lack of application wide object mocking capabilities
		// TODO: implement tests with Mocking
	}

	@Test
	@Disabled
	public void getScannerTest() {
		Scanner testScanner = Console.getScanner();
		assertTrue(testScanner instanceof Scanner);
		assertTrue(Console.getScanner() instanceof Scanner);
		assertEquals(testScanner, Console.getScanner() );
	}
	
	@Test
	@Disabled
	public void inputTest() {
		String expect = userInput;
		assertEquals(expect, Console.input());
	}
	
}

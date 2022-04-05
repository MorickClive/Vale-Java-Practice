package com.mc.main.advanced.designpatterns.behavioural.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubscriberUnitTEST {
	
	private static Subscriber testSub;
	private static String testName;
	private static HashMap<Integer, String> testInbox;
	
	@BeforeAll
	public static void setup() {
		testInbox = new HashMap<>();
		testInbox.put(1, "Message 1");
		testInbox.put(2, "Message 2");
		
		testName = "test";
		testSub = new Subscriber();
	}
	
	@BeforeEach
	public void beforeTest() {
		testInbox = new HashMap<>();
		testInbox.put(1, "Message 1");
		testInbox.put(2, "Message 2");
		
		testSub.setInbox(testInbox);
	}

	@Test
	public void defaultConstructor() {
		testSub = new Subscriber();
		
		assertTrue(testSub instanceof Subscriber);
	}

	@Test
	public void allArgsConstructor() {
		testSub = new Subscriber(testName);

		assertTrue(testSub instanceof Subscriber);
		assertEquals(testName, testSub.getUsername());
	}

	@Test
	public void accessUsername() {
		String expect = "new Test";
		
		testSub.setUsername(expect);
		
		assertEquals(expect, testSub.getUsername());
	}

	@Test
	public void accessInbox() {
		HashMap<Integer, String> expect;
		
		testInbox = new HashMap<>();
		testInbox.put(1, "Cat");
		testInbox.put(2, "Dog");
		
		testSub.setInbox(testInbox);
		
		expect = testSub.getInbox();

		assertTrue(expect.size() == 2);
		assertTrue(expect instanceof HashMap<?, ?>);
		assertEquals(testInbox, expect);
	}

	@Test
	public void accessMessage_Success() {
		String expect = "Message 2";
		
		assertNotNull(testSub.getMessage(2));
		assertEquals(expect, testSub.getMessage(2));
	}
	
	@Test
	public void accessMessage_Failure() {
		assertNull(testSub.getMessage(3));
	}

	@Test
	public void editMessage_Success() {
		String expect = "new message";
		
		assertTrue(testSub.editMessage(2, expect));
		assertEquals(expect, testSub.getMessage(2));
	}

	@Test
	public void editMessage_Failure() {
		assertFalse(testSub.editMessage(3, "new message"));
	}

	@Test
	public void update() {
		testSub.update("new Message", new GroupPage("test group"));
		
	}

	@Test
	public void printInbox() {
		testSub.setUsername(testName);
		
		testSub.printInbox();
	}
	
}

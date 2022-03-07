package com.mc.main.advanced.designpatterns.behavioural.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupPageUnitTest {

	private static String pageName;
	private static GroupPage testPage;
	
	@BeforeAll
	public static void setup() {
		pageName = "testPage";
		testPage = new GroupPage(pageName);	
	}
	
	@BeforeEach
	public void beforeTest() {	
		testPage.setObservers(new ArrayList<>());
		testPage.addObserver(new Subscriber("test"));
		testPage.addObserver(new Subscriber("test2"));
	}
	
	@Test
	public void defaultConstructor() {
		testPage = new GroupPage();
		
		assertTrue(testPage instanceof GroupPage);
		assertNull(testPage.getName());
	}
	
	@Test
	public void allArgsConstructor() {
		testPage = new GroupPage(pageName);

		assertTrue(testPage instanceof GroupPage);
		assertEquals(pageName, testPage.getName());
	}
	
	@Test
	public void post() {
		int expect = testPage.getPosts().size() + 1;
		
		testPage.post("new Message");
		
		assertEquals(expect, testPage.getPosts().size());
	}

	@Test
	public void notifyObservers_Success() {
		boolean expect = testPage.notifyObservers("new Message");
		
		assertTrue(expect);
	}
	
	@Test
	public void notifyObservers_Failure1() {
		boolean expect;
		
		testPage.setObservers(null);
		expect = testPage.notifyObservers("new Message");
		
		assertFalse(expect);
	}
	
	@Test
	public void notifyObservers_Failure2() {
		boolean expect;
		List<MediaObserver> listOfObservers = new ArrayList<>();
		listOfObservers.add(null);
		
		testPage.setObservers(listOfObservers);
		expect = testPage.notifyObservers("new Message");
		
		assertFalse(expect);
	}
	
	@Test
	public void addObservers() {
		int expect = testPage.getObservers().size() + 1;
		Subscriber testSub = new Subscriber("cat");		
		
		testPage.addObserver(testSub);
		
		assertEquals(expect, testPage.getObservers().size());
		assertEquals(testSub, testPage.getObservers().get(expect-1));
	}
	
	@Test
	public void accessName() {
		String expect = "new test name";
		
		testPage.setName(expect);
		
		assertEquals(expect, testPage.getName());
	}
	
	@Test
	public void accessPosts() {
		List<String> expect;
		List<String> posts = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			posts.add("Message " + i+1);
		}

		testPage.setPosts(posts);
		
		expect = testPage.getPosts();
		assertTrue(expect instanceof ArrayList<?>);
		assertEquals(5, expect.size());
		
		for (int i = 0; i < expect.size(); i++) {
			assertEquals("Message " + i+1, expect.get(i));
		}
	}
	
	@Test
	public void getObservers() {
		testPage.setObservers(new ArrayList<>());
		testPage.addObserver(new Subscriber("cat"));
		testPage.addObserver(new Subscriber("dog"));
		
		assertTrue(testPage.getObservers() instanceof ArrayList<?>);
		assertEquals(2, testPage.getObservers().size());
	}
	
	// TODO: failure test
	@Test
	public void addObserver() {
		int expect = 1;
		boolean actual;
		
		testPage.setObservers(new ArrayList<>());
		
		actual = testPage.addObserver(new Subscriber("cat"));
		
		assertTrue(actual);
		assertEquals(expect, testPage.getObservers().size());
	}	
	
	// TODO: failure test
	@Test
	public void removeObserver() {
		int expect = 1;
		Subscriber test = new Subscriber("dog");
		
		testPage.setObservers(new ArrayList<>());
		testPage.addObserver(new Subscriber("cat"));
		testPage.addObserver(test);
		
		boolean actual = testPage.removeObserver(test);
		
		assertTrue(actual);
		assertEquals(expect, testPage.getObservers().size());
	}
	
	@Test
	public void accessCreationDate() {
		String expect = testPage.getCreationDate();

		assertNotNull(expect);
		assertTrue(expect instanceof String);
	}
	
}

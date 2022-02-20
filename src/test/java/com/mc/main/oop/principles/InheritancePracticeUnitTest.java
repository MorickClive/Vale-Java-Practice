package com.mc.main.oop.principles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.oop.principles.res.Book;

public class InheritancePracticeUnitTest {
	
	private final Book myBook = new Book("Example Book Title","Alex", "20/02/2022", "Educational", 202);
	private InheritancePractice.Library exampleLibrary;
	
	@BeforeEach
	public void setupTest() {
		exampleLibrary = new InheritancePractice.Library("Java Case Study Library", "local-home", myBook);
	}
	
	@Test
	public void startTest() {
		InheritancePractice.start();
	}
	
	@Test
	public void defaultConstructorTest() {
		exampleLibrary = new InheritancePractice.Library();
		
		assertTrue(exampleLibrary instanceof InheritancePractice.Library);
	}
	
	@Test
	public void allArgsConstructorTest() {
		assertTrue(exampleLibrary instanceof InheritancePractice.Library);
		assertEquals("Java Case Study Library", exampleLibrary.getName());
		assertEquals("local-home", exampleLibrary.getAddress());
		assertEquals(myBook, exampleLibrary.getExampleBook());
	}
	
	@Test
	public void accessNameTest() {
		exampleLibrary.setName("New Test Library");
		
		assertTrue(exampleLibrary instanceof InheritancePractice.Library);
		assertEquals("New Test Library", exampleLibrary.getName());
	}
	
	@Test
	public void accessAddressTest() {
		exampleLibrary.setAddress("New address");
		
		assertTrue(exampleLibrary instanceof InheritancePractice.Library);
		assertEquals("New address", exampleLibrary.getAddress());
	}
	
	@Test
	public void accessBookTest() {
		Book book = new Book("title", "Alex", "20/02/2022", "Science", 42);
		exampleLibrary.setExampleBook(book);
		
		assertTrue(exampleLibrary instanceof InheritancePractice.Library);
		assertEquals(book, exampleLibrary.getExampleBook());
	}
	
}

package com.mc.main.oop.principles.res;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookUnitTEST {
	
	private Book testBook;
	
	@BeforeEach
	public void setupTest() {
		testBook = new Book("Example Book Title","Alex", "20/02/2022", "Educational", 202);
	}
	
	@Test
	public void defaultConstructorTest() {
		testBook = new Book();
		
		assertTrue(testBook instanceof Book);
		assertEquals("UNKNOWN", testBook.getGenre());
		assertEquals(0, testBook.getPageCount());
	}
	
	@Test
	public void allArgsConstructorTest() {
		assertTrue(testBook instanceof Book);
		assertEquals("Educational", testBook.getGenre());
		assertEquals(202, testBook.getPageCount());
	}
	
	@Test
	public void accessGenreTest() {
		testBook.setGenre("Science");
		
		assertEquals("Science", testBook.getGenre());		
	}
	
	@Test
	public void accessPageCountTest() {
		testBook.setPageCount(42);
		
		assertEquals(42, testBook.getPageCount());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Book[title=Example Book Title, author=Alex, datePublished=20/02/2022, genre=Educational, pageCount=202]", testBook.toString());
	}
	
	@Test
	public void objectEqualsTest() {
		assertTrue(testBook.equals(testBook));
	}
	
	@Test
	public void objectEquals_Failure1_Test() {
		Media sampleMedia = new Media("Example Book Title","Alex", "20/02/2022");
		
		assertTrue(!testBook.equals(sampleMedia));
	}

	@Test
	public void objectEquals_Failure2_Test() {
		Book sampleMedia = new Book("Example Book Title","Alex", "20/02/2022", "INCORRECT", 2);
		
		assertTrue(!testBook.equals(sampleMedia) );
	}
	
	@Test
	public void objectEquals_Failure3_Test() {
		Media uniqueInstanceBook = new Media("Example Book Title","Alex", "20/02/2022");
		
		assertTrue(!testBook.equals(uniqueInstanceBook));
	}
	
	@Test
	public void objectEquals_Failure4_Test() {
		Book uniqueInstanceBook = new Book("Example Book Title","Alex", "20/02/2022", "Educational", 0);
		testBook.setGenre(null);
		
		assertTrue(!testBook.equals(uniqueInstanceBook));
	}
	
	@Test
	public void objectEquals_Failure5_Test() {
		Book uniqueInstanceBook = new Book("Example Book Title","Alex", "20/02/2022", "Educational", 0);
		
		assertTrue(!testBook.equals(uniqueInstanceBook));
	}
	
	@Test
	public void objectEqual_Failure6_Test() {
		Book uniqueInstanceBook = new Book("Example Book Title","Alex", "20/02/2022", "Educational", 202);
		
		assertTrue(testBook.equals(uniqueInstanceBook));
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(950115889, testBook.hashCode());
	}
	
	@Test
	public void hashCode_Failure1_Test() {
		testBook.setGenre(null);
		
		assertEquals(-230606460, testBook.hashCode());
	}

}

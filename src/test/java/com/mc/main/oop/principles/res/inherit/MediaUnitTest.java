package com.mc.main.oop.principles.res.inherit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaUnitTest {
	
	private Media testMedia;
	
	@BeforeEach
	public void setupTest() {
		testMedia = new Media("New Media Item","Alex","2020");
	}
	
	@Test
	public void defaultConstructorTest() {
		testMedia = new Media();
		
		assertTrue(testMedia instanceof Media);
		assertEquals("MISSING", testMedia.getTitle());
		assertEquals("MISSING", testMedia.getAuthor());
		assertEquals("UNKNOWN", testMedia.getDatePublished());
	}
	
	@Test
	public void allArgsConstructorTest() {
		assertTrue(testMedia instanceof Media);
		assertEquals("New Media Item", testMedia.getTitle());
		assertEquals("Alex", testMedia.getAuthor());
		assertEquals("2020", testMedia.getDatePublished());
	}
	
	@Test
	public void accessTitleTest() {
		testMedia.setTitle("Access Title");
		
		assertEquals("Access Title", testMedia.getTitle());		
	}
	
	@Test
	public void accessAuthorTest() {
		testMedia.setAuthor("Morick");
		
		assertEquals("Morick", testMedia.getAuthor());
	}
	
	@Test
	public void accessPublishDateTest() {
		testMedia.setDatePublished("2022");

		assertEquals("2022", testMedia.getDatePublished());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Media[title=New Media Item, author=Alex, datePublished=2020", testMedia.toString());
	}

	
	@Test
	public void objectEqualsTest() {
		Media uniqueInstanceMedia = new Media("New Media Item","Alex","2020");
		
		assertTrue(testMedia.equals(uniqueInstanceMedia));
	}
	
	@Test
	public void objectEquals_Failure1_Test() {
		assertTrue(testMedia.equals(testMedia));
	}
	
	@Test
	public void objectEquals_Failure2_Test() {
		assertTrue(!testMedia.equals(null));
	}
	
	@Test
	public void objectEquals_Failure3_Test() {
		assertTrue(!testMedia.equals("words"));
	}
	
	@Test
	public void objectEquals_Failure4_Test() {
		Media uniqueInstanceMedia = new Media(null,"Alex","2020");
		
		assertTrue(!uniqueInstanceMedia.equals(testMedia));
	}
	
	@Test
	public void objectEquals_Failure5_Test() {
		Media uniqueInstanceMedia = new Media("INCORRECT","Alex","2020");
		
		assertTrue(!testMedia.equals(uniqueInstanceMedia));
	}
	
	@Test
	public void objectEquals_Failure6_Test() {
		Media uniqueInstanceMedia = new Media("New Media Item", null,"2020");

		assertTrue(!uniqueInstanceMedia.equals(testMedia));
	}
	
	@Test
	public void objectEquals_Failure7_Test() {
		Media uniqueInstanceMedia = new Media("New Media Item","INCORRECT","2020");
		
		assertTrue(!testMedia.equals(uniqueInstanceMedia));
	}
	
	@Test
	public void objectEquals_Failure8_Test() {
		Media uniqueInstanceMedia = new Media("New Media Item","Alex", null);

		assertTrue(!uniqueInstanceMedia.equals(testMedia));
	}
	
	@Test
	public void objectEquals_Failure9_Test() {
		Media uniqueInstanceMedia = new Media("New Media Item","Alex","INCORRECT");
		
		assertTrue(!testMedia.equals(uniqueInstanceMedia));
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(2050623056, testMedia.hashCode());
	}
	
	@Test
	public void hashCode_Failure1_TestTest() {
		testMedia.setTitle(null);
		
		assertEquals(2011444641, testMedia.hashCode());
	}
	
	@Test
	public void hashCode_Failure2_TestTest() {
		testMedia.setAuthor(null);
		
		assertEquals(86863762, testMedia.hashCode());
	}
	
	@Test
	public void hashCode_Failure3_TestTest() {
		testMedia.setDatePublished(null);
		
		assertEquals(2002967500, testMedia.hashCode());
	}

}

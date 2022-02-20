package com.mc.main.oop.principles.res;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.Application;

public class CompactDiskUnitTest {
	
	private CompactDisk testCD;
	
	@BeforeEach
	public void setupTest() {
		testCD = new CompactDisk("Example Book Title","Alex", "20/02/2022", Application.PROCEDURAL, true);
	}
	
	@Test
	public void defaultConstructorTest() {
		testCD = new CompactDisk();

		assertTrue(testCD instanceof CompactDisk);
		assertFalse(testCD.isReadOnly());
		assertEquals(null, testCD.getApp());
	}
	
	@Test
	public void allArgsConstructorTest() {
		assertTrue(testCD instanceof CompactDisk);
		assertTrue(testCD.isReadOnly());
		assertEquals(Application.PROCEDURAL, testCD.getApp());
	}
	
	@Test
	public void accessIsReadOnlyTest() {
		testCD.setReadOnly(false);

		assertFalse(testCD.isReadOnly());	
	}
	
	@Test
	public void accessAppTest() {
		testCD.setApp(Application.JAVA8);
		
		assertEquals(Application.JAVA8, testCD.getApp());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("CompactDisk[title=Example Book Title, author=Alex, datePublished=20/02/2022, app=PROCEDURAL, isReadOnly=true]",
				testCD.toString());
	}
	
	@Test
	public void objectEqualsTest() {
		assertTrue(testCD.equals(testCD));
	}
	
	@Test
	public void objectEquals_Failure1_Test() {
		Media sampleMedia = new Media("Example Book Title","Alex", "20/02/2022");
		
		assertTrue(!testCD.equals(sampleMedia));
	}

	@Test
	public void objectEquals_Failure2_Test() {
		CompactDisk sampleMedia = new CompactDisk("Example Book Title","Alex", "20/02/2022", Application.JAVA8, false);
		
		assertTrue(!testCD.equals(sampleMedia) );
	}
	
	@Test
	public void objectEquals_Failure3_Test() {
		Media uniqueInstanceMedia = new Media("Example Book Title","Alex", "20/02/2022");
		
		assertTrue(!testCD.equals(uniqueInstanceMedia));
	}
	
	@Test
	public void objectEquals_Failure4_Test() {
		CompactDisk uniqueInstanceCD = new CompactDisk("Example Book Title","Alex", "20/02/2022", Application.PROCEDURAL, false);
		testCD.setApp(null);
		
		assertTrue(!testCD.equals(uniqueInstanceCD));
	}
	
	@Test
	public void objectEquals_Failure5_Test() {
		CompactDisk uniqueInstanceCD = new CompactDisk("Example Book Title","Alex", "20/02/2022", Application.PROCEDURAL, false);
		
		assertTrue(!testCD.equals(uniqueInstanceCD));
	}
	
	@Test
	public void objectEqual_Failure6_Test() {
		CompactDisk uniqueInstanceCD = new CompactDisk("Example Book Title","Alex", "20/02/2022", Application.PROCEDURAL, true);
		
		assertTrue(testCD.equals(uniqueInstanceCD));
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(-703321898, testCD.hashCode());
	}
	
	@Test
	public void hashCode_Failure1_Test() {
		testCD.setApp(null);
		
		assertEquals(-230605431, testCD.hashCode());
	}
	
	@Test
	public void hashCode_Failure2_Test() {
		testCD.setReadOnly(false);
		
		assertEquals(-703321892, testCD.hashCode());
	}

}

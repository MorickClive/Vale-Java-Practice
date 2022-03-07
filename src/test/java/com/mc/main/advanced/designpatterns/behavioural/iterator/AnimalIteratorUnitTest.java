package com.mc.main.advanced.designpatterns.behavioural.iterator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.oop.principles.res.polymorph.Animal;
import com.mc.main.oop.principles.res.polymorph.Cat;
import com.mc.main.oop.principles.res.polymorph.Dog;

public class AnimalIteratorUnitTest {
	
	private static AnimalIterator testIterator;
	private static Animal[] listOfAnimals;
	
	@BeforeAll
	public static void setup() {
		listOfAnimals = new Animal[3];
		
		for(int x = 0; x < listOfAnimals.length; x++) {
			listOfAnimals[x] = x % 2 == 0 ? new Cat() : new Dog();
		}
	}
	
	@BeforeEach
	public void beforeTest() {		
		testIterator = (AnimalIterator) new AnimalList(listOfAnimals).iterator();
	}
	
	@Test
	public void allArgsConstructor() {
		testIterator = new AnimalIterator(listOfAnimals);
		
		assertTrue(testIterator instanceof AnimalIterator);
		assertTrue(testIterator.hasNext());
	}

	@Test
	public void checkHasNext_Success() {
		assertTrue(testIterator.hasNext());
	}
	
	@Test
	public void checkHasNext_Failure() {
		for(int x = 0; x < listOfAnimals.length; x++)  {
			testIterator.next();
		}

		assertFalse(testIterator.hasNext());
	}

	@Test
	public void checkNext_Success() {
		Animal expect = testIterator.next();

		assertTrue(expect instanceof Animal);
		assertTrue(expect instanceof Cat);
	}
	
	@Test
	public void checkNext_Failure() {
		for(int x = 0; x < listOfAnimals.length; x++)  {
			testIterator.next();
		}
		
		assertFalse(testIterator.hasNext());
		assertNull(testIterator.next());
	}

}

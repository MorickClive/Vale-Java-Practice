package com.mc.main.advanced.designpatterns.behavioural.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mc.main.oop.principles.res.polymorph.Animal;
import com.mc.main.oop.principles.res.polymorph.Cat;
import com.mc.main.oop.principles.res.polymorph.Dog;

public class AnimalListUnitTest {
	
	private static AnimalList testList;
	
	@BeforeAll
	public static void setup() {
		testList = new AnimalList(new Animal[2]);
	}
	
	@Test
	public void allArgsConstructor() {
		testList = new AnimalList(new Animal[2]);
		
		assertTrue(testList instanceof AnimalList);
	}
	
	@Test
	public void accessAnimalList() {
		Animal[] listOfAnimals = {new Dog(), new Cat(), new Dog()};
		
		testList.setAnimalList(listOfAnimals);
		
		assertTrue(testList.getAnimalList() instanceof Animal[]);
		
		for(int x = 0; x < listOfAnimals.length; x++) {
			assertEquals(listOfAnimals[x], testList.getAnimalList()[x]);
		}
	}
	
	@Test
	public void accessIterator() {
		assertTrue(testList.iterator() instanceof AnimalIterator);
		assertTrue(testList.iterator().hasNext());
	}

}

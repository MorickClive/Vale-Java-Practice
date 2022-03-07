package com.mc.main.advanced.designpatterns.behavioural.iterator;

import java.util.Iterator;

import com.mc.main.oop.principles.res.polymorph.Animal;

// This is our "container", it is a concrete implementation that has-a list,
// as such the list/array can make it eligible for iteration.
//
//This is the concrete implementation, the interface is actually something that is
//provided by Java, however we could add additional methods in a custom implementation.
public class AnimalList implements Iterable<Animal> {
	
	private Animal[] listOfAnimals;

	public AnimalList(Animal[] listOfAnimals) {
		super();
		this.listOfAnimals = listOfAnimals;
	}
	
	public void setAnimalList(Animal[] list) {
		this.listOfAnimals = list;
	}
	
	public Animal[] getAnimalList() {
		return this.listOfAnimals;
	}

	// To interact with the list, we'd be forced to iterator for each item
	// as the interface is differed to the AnimalIterator class.
	@Override
	public Iterator<Animal> iterator() {
		return new AnimalIterator(listOfAnimals);
	}

}

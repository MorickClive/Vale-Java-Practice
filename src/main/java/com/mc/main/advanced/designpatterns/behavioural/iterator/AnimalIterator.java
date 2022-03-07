package com.mc.main.advanced.designpatterns.behavioural.iterator;

import java.util.Iterator;

import com.mc.main.oop.principles.res.polymorph.Animal;

// Our Container would implement an interface that enables the retrieval
// of our Iterator.
//
// The Concrete Iterator would then take the list of the Container, using
// the implemented methods from an Iterator interface: "next(), hasNext()"
//
// This is the concrete implementation, the interface is actually something that is
// provided by Java, we could add additional methods in a custom implementation instead if we had reason to
// expand the interface.
public class AnimalIterator implements Iterator<Animal> {

	// Our iterator handles a List of some type, the type of array shouldn't necessarily matter!
	// We'll also keep track of the index of the item we're on.
	private Animal[] listOfAnimals;
	private int pos = 0;
	
	// The purpose of this class is to provide control to
	// navigate a list through the iterator methods of "next(), hasNext()".
	public AnimalIterator(Animal[] listOfAnimals) {
		super();
		this.listOfAnimals = listOfAnimals;
	}

	@Override
	public boolean hasNext() {
		// We can use this method to drive a while loop.
		// Every time we access an item, we increment our variable for conditional review.
		// if there are no items "next" then there's no reason to continue.
		return pos < listOfAnimals.length;
	}

	@Override
	public Animal next() {
		// we can access the index of our array, incrementing our position
		// after access.
		//
		// To avoid an out of bounds exception, if for some reason someone calls the next method
		// we can simply return a null reference.
		return hasNext() ? listOfAnimals[pos++] : null;
	}

}

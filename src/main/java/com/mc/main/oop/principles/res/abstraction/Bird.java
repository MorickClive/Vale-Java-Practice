package com.mc.main.oop.principles.res.abstraction;

// Abstraction can be expressed through the use of the of the 'abstract' keyword
// whilst a class is abstract it cannot be instantiated and this is where abstract becomes
// more grounded.
//
// when we think about a class - we might consider some kind of object, entity or value.
// but not all classes define something that is absolute. Whilst everyone can agree a Bird
// maybe a winged creature with typical avian qualities, with java it is a great concept
// to provide a foundation for functionality and instructions.
//
// Without defining features however, this means we shouldn't be able to create an instance of
// Bird - it's just to "loose" or abstract, but child classes might share the Bird functionality
// we define. We call this set of instructions as an implementation of a class, abstract classes
// can provide implementation for child classes, but would never be used to create an instance itself.
public abstract class Bird {

	protected String species;

	public Bird() {
		super();
	}

	public Bird(String species) {
		super();
		this.species = species;
	}
	
	public String speak(){
		return this.species + " begins singing a bird song";
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	// You might be tempted to create functionality for flight; isFlying(), fly() - however 
	// consider birds such as Penguins or Ostrich - they are birds, but not necessarily flight
	// capable, for this example we'll look at interfaces and their similar abstract nature.

}

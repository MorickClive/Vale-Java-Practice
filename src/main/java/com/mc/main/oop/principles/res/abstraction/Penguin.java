package com.mc.main.oop.principles.res.abstraction;

// Penguin is a Bird, and can be stored with a list of any other child classes
// of Bird - even if they are incapable of flight!
//
//Let's see this in action in the Abstraction Practice!
public class Penguin extends Bird {

	public Penguin() {
		super();
	}

	public Penguin(String species) {
		super(species);
	}

	@Override
	public String speak() {
		return "The " + super.species + " gaks!";
	}
		
}

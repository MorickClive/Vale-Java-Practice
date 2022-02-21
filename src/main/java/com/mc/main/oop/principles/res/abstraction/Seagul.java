package com.mc.main.oop.principles.res.abstraction;

// A Seagul is a Bird, and can be stored with a list of any other child classes
// of Bird - even if they are capable of flight!
//
// Let's see this in action in the Abstraction Practice!
public class Seagul extends FlyingBird  {

	public Seagul() {
		super();
	}

	public Seagul(String species, boolean isFlying) {
		super(species, isFlying);
	}

	public Seagul(String species) {
		super(species);
	}

	@Override
	public String speak() {
		return "The " + super.species + " mockingly laughs!";
	}

	
}

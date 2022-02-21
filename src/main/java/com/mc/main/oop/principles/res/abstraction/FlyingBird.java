package com.mc.main.oop.principles.res.abstraction;

// As we can see, FlyingBird will inherit functionality from bird
// reducing duplicate code and implementation - but now any child
// of FlyingBird MUST have some implementation of Flying methods.
// 
// The Java compiler will complain about any methods missing from
// a class implementation if it states it's using the implements keyword.
//
// Additionally - whilst not covered here -  we can ask our classes
// to implement multiple interfaces, purely by listing interfaces separated by commas:
// "class Example implements Flying, Swooping, Resting"
// 
// Generally interfaces should generally be adjectives - this isn't always the case,
// but because of the addition of behaviours via functionality, it is implied there's
// some kind of action/capability being provided.
public abstract class FlyingBird extends Bird implements Flying {
	
	protected boolean isFlying;
	
	public FlyingBird() {
		super();
		super.species = "???";
		isFlying = false;
	}
	
	public FlyingBird(String species) {
		super(species);
	}
	
	public FlyingBird(String species, boolean isFlying) {
		super(species);
		this.isFlying = isFlying;
	}
	
	// Notice that we aren't necessarily worried about changing the speak() method
	// because that's inherited from Bird and works as we intend it to.
	//
	// In a child class there might be cause to provide polymorphic behaviour.
	
	// INTERFACE METHODS
	// ========================================
	// We can now use Flying or FlyingBird to outline
	// any child class as a flight capable bird due to
	// abstraction and interface control.
	public boolean isFlying() {
		return isFlying;
	}

	public void fly() {
		if(isFlying) { 
			System.out.println(this.species + " is already in flight!");
		} else { 
			isFlying = true;
		}
	}

	public void land() {
		if(!isFlying) { 
			System.out.println(this.species + " is already grounded!");
		} else { 
			isFlying = false;
		}
	}

}

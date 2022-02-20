package com.mc.main.oop.principles.res;

/**
 * 
 * As we can see here, our dog doesn't expand much on the Animal class
 * and could definitely include more attributes and method behaviours.
 * 
 * However let's focus instead on the speak method!
 * 
 * @author MorickClive
 *
 */
public class Dog extends Animal {
	
	public Dog() {
		super();
	}

	public Dog(String name) {
		super(name);
	}
	
	// @Override is an annotation, it helps inform other developers
	// that we are changing inherited behaviour from our parent class
	// in this case the method speak should change it's behaviour when used
	// during application runtime!
	//
	// Let's observe Cat!
	@Override
	public String speak() {
		return super.name + " says Woof!";
	}

}

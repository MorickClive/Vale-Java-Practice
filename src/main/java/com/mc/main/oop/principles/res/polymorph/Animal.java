package com.mc.main.oop.principles.res.polymorph;

/**
 * 
 * Here we can see a standard example of an Animal, it has a name and a space within
 * a 2 dimensional position.
 * 
 * We can use this as a basis to demonstrate how we can use inheritance and polymorphism together
 * to represent two child objects that share qualities but can change their inherited behaviour.
 * 
 * We'll pay particular focus to the 'speak()' method.
 * 
 * @author MorickClive
 *
 */
public class Animal {
	
	// let's not forget, we might want to access these in child objects
	// encapsulation allows us to lock attributes to outside view
	// but allow access from sub-classes like our dog and cat classes
	protected String name;
	protected final int[] position;
	
	public Animal() { 
		super();
		position = new int[2];
		}

	public Animal(String name) {
		this();
		this.name = name;
	}
	
	// As we can see here, we can't really give a definite sound here; we don't
	// know what the animal is precisely - we just know that it can make a sound!
	//
	// Let's observe the Dog class.
	public String speak() {
		return "*Undiscernable noise*";
	}
	
	public void move(int x, int y) {
		position[0] += x;
		position[1] += y;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getPosition() {
		return position;
	}
	
	public String strPosition() {
		return "[x:"+ position[0] + ", y:" + position[1] + "]";
	}

	public void setPosition(int x, int y) {
		position[0] = x;
		position[1] = y;
	}
	
}

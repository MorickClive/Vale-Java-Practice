package com.mc.main.oop.principles.res.abstraction;

// An interface is very much like an abstract class, it provides no
// Instantiation only an outline of capabilities through loosely defined
// methods.
//
// In fact, interfaces shouldn't even include instructions, this is left to a class that "inherits"
// it. As a bit of clarity however, when a class draws from a interface we would say that class
// implements a interface, which we will see with the FlyingBird example.
public interface Flying {
	
	public boolean isFlying = false;
	
	// Methods in an interface do not provide scopes
	// as an interface is like a guide - telling java
	// what this object can do.
	//
	// When we think of methods as behaviours of a class
	// it becomes a lot easier to understand the value of a guide to what
	// a class should be able to do.
	public boolean isFlying();
	public void fly();
	public void land();
	
	// When we write code in our IDE, we can use the '.' modifier to access sub methods
	// but the options we get expose the class interface - as there's no reason for 
	// us to know everything but the name and implied capabilities of these methods.
	//
	// Interfaces are exactly the same - they inform a class implementing them that they
	// need to provide implementation for all outlined methods and attributes.
	//
	// We can then use an abstract class as a data type - and most importantly
	// store any child class of that abstract into a variable that is considered
	// a parent class!
	//
	// Java will know that the data type of that variable implies certain capabilities that
	// all sub classes share - it doesn't know specific implementation of child classes.
	// but can infer from the interface that it must have an implementation of "fly()" for
	// example.
	
	// Let us see how FlyingBird creates a sub group of flight capable birds!
}

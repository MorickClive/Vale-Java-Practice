package com.mc.main.java8.streams;

// Functional Interfaces allow us to use abstraction in a way to
// outline a method definition without our implementation
//
// However functional interfaces are only comprised of one abstract method:
// a "Single Abstract Method" Interface.
@FunctionalInterface
public interface Printable {
	
	public void print();

}

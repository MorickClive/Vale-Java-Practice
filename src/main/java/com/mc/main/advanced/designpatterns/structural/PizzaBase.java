package com.mc.main.advanced.designpatterns.structural;

// This class will form our concrete class
// The functionality here is more independent of the general pattern
// so we can implement this with the mind set of the interface capabilities.
//
// Let's look at the Pizza Decorator next
public class PizzaBase implements Pizza {

	public double price = 5.0;
	
	public PizzaBase() {
		super();
	}	

	@Override
	public double price() {
		return this.price;
	}

	@Override
	public String description() {
		return "This pizza has the following:\nA base";
	}

}

package com.mc.main.advanced.designpatterns.structural;

// This interface will form the basis of the decorator pattern capability
// all child classes will be able to perform the following methods.
//
// Let's take a look at the PizzaBase class.
public interface Pizza {

	public double price();
	public String description();

}

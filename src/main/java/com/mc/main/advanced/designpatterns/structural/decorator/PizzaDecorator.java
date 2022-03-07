package com.mc.main.advanced.designpatterns.structural.decorator;

import com.mc.main.advanced.designpatterns.structural.Pizza;
import com.mc.main.advanced.designpatterns.structural.PizzaBase;

// Here is the main class that begins to express the pattern more clearly.
// because this isn't a model so much as a default implementation we can leave
// this as an abstract class - as the child classes will be capable of this too.
public abstract class PizzaDecorator implements Pizza {
	
	// Any instance that shares the Pizza interface/type can be stored here.
	private Pizza pizza;

	public PizzaDecorator() {
		super();
		pizza = new PizzaBase();
	}
	
	// When we make an instance of this, we can store a Pizza during instantiation.
	public PizzaDecorator(Pizza base) {
		super();
		this.pizza = base;
	}
	
	// Let's observe this method primarily, then the description method after understanding the pattern.
	// so clearly we are providing the price from the stored class.
	// Let's observe the TomatoSauce class, which is a child of the decorator.
	@Override
	public double price() {
		return this.pizza.price();
	}

	@Override
	public String description() {
		return this.pizza != null ? pizza.description() + ", " : pizza.description();
	}
		
}

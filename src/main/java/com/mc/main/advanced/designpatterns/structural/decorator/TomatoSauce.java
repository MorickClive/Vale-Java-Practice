package com.mc.main.advanced.designpatterns.structural.decorator;

import com.mc.main.advanced.designpatterns.structural.Pizza;

public class TomatoSauce extends PizzaDecorator {
	
	private double price = 1.50;
	
	// The constructor of this Decoration class
	// is the main way we assign a child class inside this decoration.
	public TomatoSauce(Pizza pizza) {
		super(pizza);
	}
	
	// Because of the relationship with the decorator class and that
	// technically this is a decorator class, despite being a decoration.
	@Override
	public double price() {
		// So if we pass this class the concrete class into this constructor
		// we can call pizzabase.price with the addition of this price value
		// 
		// extending the logic, other decorations can also contain this decoration with the base class
		// inside it, so the child would call this price, which would call the concrete class price.
		// resulting in a sum of all separate prices added.
		return super.price() + this.price;
		// Let's return to DesignPatternPractice to see this executed to demonstrate the chaining
		// of the decorator pattern.
	}

	@Override
	public String description() {
		return super.description() + "a layer of tomato sauce";
	}
}

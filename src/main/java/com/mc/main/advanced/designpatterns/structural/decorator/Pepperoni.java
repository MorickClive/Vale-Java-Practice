package com.mc.main.advanced.designpatterns.structural.decorator;

import com.mc.main.advanced.designpatterns.structural.Pizza;

public class Pepperoni extends PizzaDecorator {
	
	private double price = 1.25;

	public Pepperoni(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public double price() {
		return super.price() + this.price;
	}

	@Override
	public String description() {
		return super.description() + "pepperoni slices";
	}
}

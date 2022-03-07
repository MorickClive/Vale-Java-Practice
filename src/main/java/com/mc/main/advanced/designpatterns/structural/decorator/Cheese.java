package com.mc.main.advanced.designpatterns.structural.decorator;

import com.mc.main.advanced.designpatterns.structural.Pizza;

public class Cheese extends PizzaDecorator {
	
	private double price = 0.75;
	
	public Cheese(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public double price() {
		return super.price() + this.price;
	}

	@Override
	public String description() {
		return super.description() + "gratted cheese";
	}
}

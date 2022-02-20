package com.mc.main.oop.principles.res;

public class Cat extends Animal {
	
	public Cat() {
		super();
	}

	public Cat(String name) {
		super(name);
	}
	
	// Again, Cat is changing it's speak method just like Dog did!
	// but now the response is more appropriate for this child class!
	//
	// Let's see how this works in practice and return to PolymorphismPractice!
	@Override
	public String speak() {
		return super.name + " says Meow!";
	}
}

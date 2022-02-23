package com.mc.main.advanced.designpatterns.creational;

public class SingletonExample {
	
	// The idea is to only have one instance of this class.
	// We entrust this to the class itself - but its static context only.
	// 
	// Because there is only one static context for the class, it is stored
	// in one specific location - we can then use the interface of the static context
	// to provide an instance of this class.
	// being private means only this class can access this instance.
	private static SingletonExample example;
	private String message;
	
	private SingletonExample() {
		message = "This String will never change!";
	}
	
	// Here is where it all comes together, the method that allows us to "create"
	// an instance of the class. This method is public, so it can be invoked.
	// because it is static, you don't need an instance to reference this method!
	//
	// Then, we can check whether this class has an instance of itself in a static context
	// if not, then we create one for the first and last time, returning the newly created instance.
	//
	// If there is an instance it will ignore creating an instance and simply return it.
	public static SingletonExample getInstance() {
		if(example != null) {
			return example;
		} else {
			example = new SingletonExample();
			return example;
		}
	}
	
	// This method belongs to the instance of a class, whilst information/attributes within the class
	// can change. We cannot ever change the instance of this class.
	public String getMessage(){
		return message;
	}
	
	// All functionality can stored as and modified as the interface allows
	// but the idea would be that there won't be unique copies of this class
	//
	// You'd never have a reason to store a list of Singletons - there's only ever
	// one as part of the system. There's clear advantages for setting a singular instance
	// of a class; perhaps it is a fundamental spine of system operations or handles access to
	// one and only one resource - because multiple instances could cause issues with communication.
	public void setMessage(String message) {
		this.message = message;
	}
}

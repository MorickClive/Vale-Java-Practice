package com.mc.main.oop.principles;

import java.util.ArrayList;
import java.util.List;

import com.mc.main.oop.principles.res.Animal;
import com.mc.main.oop.principles.res.Cat;
import com.mc.main.oop.principles.res.Dog;

public class PolymorphismPractice {
	
	private PolymorphismPractice() { super(); }

	
	public static void start() {
		// Polymorphism is a principle of OOP design, the idea that one class
		// maybe represented in many different way. Haven't we already done that with
		// inheritance though?
		//
		// Well not entirely - we've explored how classes can take upon the properties of
		// parent classes, but not how child classes of a parent can differ from their parent counterparts.
		//
		// Well what about the fact the child classes had different methods from each other?
		// that's not really what we are looking at either, the idea is that a child class
		// might differ from its parent distinctly enough that it may change the behaviour it
		// has inherited!
		//
		// For an exploration of polymorphism we shall start with the class Animal.

		// Now we have two child classes that inherit from the same parent class
		// let's observe how the polymorphic behaviour differentiates the two child classes
		// despite using the same method!
		Cat myCat = new Cat("Tesla");
		Dog myDog = new Dog("Fido");

		System.out.println(myCat.speak());
		System.out.println(myDog.speak());
		
		// After running the application, you should see that both outputs are different!
		// this is because the child classes modify their parents behaviour during runtime
		// altering the instructions to prefer their own "implementation" of the 'speak()' method.
		
		// However, both our Animals are still capable of moving and tracking their location
		// without having to change that behaviour:

		myCat.move(25, -15);
		myDog.move(15, -6);
		
		// Next we'll look into how polymorphic behaviour benefits us and how we can appreciate
		// how interfaces and abstraction allows us greater control of related classes!
		//
		// here is a small example:
		List<Animal> myAnimalList = new ArrayList<>();
		
		myAnimalList.add(myCat);
		myAnimalList.add(myDog);
		
		for(Animal animal : myAnimalList) {
			System.out.println(animal.getName() + " is currently located at:\t" + animal.strPosition());
		}
		
	}
	
}

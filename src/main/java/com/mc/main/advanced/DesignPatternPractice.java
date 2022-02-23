package com.mc.main.advanced;

import com.mc.main.advanced.designpatterns.creational.CharacterSheetBuilder;
import com.mc.main.advanced.designpatterns.creational.SingletonExample;
import com.mc.main.advanced.res.CharacterSheet;
import com.mc.main.util.Practice;

public class DesignPatternPractice extends Practice {
	
	private DesignPatternPractice() { super(); }

	public static void start() {
		printHeader("Design Patterns");
		
		creational();
		structural();
		behavioural();
	}
	
	public static void creational() {
		singletonPattern();
		builderPattern();		
	}

	public static void structural() {
		//this.decoratorPattern();
		//this.adapterPattern();
	}

	public static void behavioural() {
		//this.iteratorPattern();
		//this.observerPattern();
	}

	// PATTERNS
	// ========================================
	
	// CREATIONAL
	// ========================================
	private static void singletonPattern(){
		// One of the major benefits of the structure
		// of a singleton pattern is that we can only
		// ever handle one instance of the class in question.
		
		// As you see below, we do not use the new keyword to create an instance.
		// Instead we differ the ability to create the instance to the static context
		// of the class; this global tracking then stores an instance of itself
		// statically, this means the global attribute of the class is the only instance
		// of the class.
		SingletonExample instance1 = SingletonExample.getInstance();
		SingletonExample instance2 = SingletonExample.getInstance();
		
		// Both instance variables point at the same instance of the class!

		System.out.println("Instance1: " + instance1.getMessage());
		System.out.println("Instance2: " + instance2.getMessage());
		
		// let's change instance1's message and then get message from instance2 to
		// observe that the message is only change in the singular instance!

		System.out.println("\nInstance2.setMessage(\"This is my new message!\")\n");
		instance1.setMessage("This is my new message!");

		System.out.println("Instance2: " + instance2.getMessage());
		System.out.println("Instance1: " + instance1.getMessage());
		
		// Example logic:
		// Perhaps we want a Console system, that allows us to enter messages and track
		// log changes by storing it in a singular instance.
		//
		// As you'll find when we look at Scanners, there is only one Stream of system input
		// that is shared in the application lifecycle. As such, we could bind this resource to a
		// singular Console class, that cleans up the Stream resource at the end of the application
		// but exposing the console throughout the application due to the static context.
		//
		// If you close a Scanner, any time you create a new scanner, the object will fail to read input.
	}
	
	private static void builderPattern(){
		// The builder pattern is a useful for class constructors that
		// involve a large number of attributes that can be provided as
		// part of instantiation.
		//
		// The idea is that we provide a proxy class, either nested or separate
		// that is responsible for the construction of the target class.
		//
		// The end goal leaves us with a class that can upon itself to eventually
		// provide the desired and resulting target class we want, with all the attributes
		// provided in any order.
		
		// In order to view the builder pattern we will want to look at the following class:
		// - CharacterSheet
		CharacterSheet myCharacter = new CharacterSheetBuilder()
				.name("Caspian")
				.race("Human")
				.profession("Chronurgy Wizard")
				.level(9)
				.AC(12)
				.hitPoints(new int[]{52,52})
				.abilityScores(8, 14, 14, 20, 13, 14)
				.build();
		
		// As we can see above, our CharacterSheet can effectually initialise from
		// the process happening with our CharacterSheetBuilder.
		
		// We've adapted the CharacterSheet toString so we can get a nice output
		// of our build!
		System.out.println(myCharacter);
	}


}

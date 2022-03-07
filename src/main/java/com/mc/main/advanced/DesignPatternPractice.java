package com.mc.main.advanced;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mc.main.advanced.designpatterns.behavioural.iterator.AnimalList;
import com.mc.main.advanced.designpatterns.behavioural.observer.AdminPostChecker;
import com.mc.main.advanced.designpatterns.behavioural.observer.GroupPage;
import com.mc.main.advanced.designpatterns.behavioural.observer.MediaObserver;
import com.mc.main.advanced.designpatterns.behavioural.observer.MediaSubject;
import com.mc.main.advanced.designpatterns.behavioural.observer.Subscriber;
import com.mc.main.advanced.designpatterns.creational.CharacterSheetBuilder;
import com.mc.main.advanced.designpatterns.creational.SingletonExample;
import com.mc.main.advanced.designpatterns.structural.Pizza;
import com.mc.main.advanced.designpatterns.structural.PizzaBase;
import com.mc.main.advanced.designpatterns.structural.adapter.EnglishInteractions;
import com.mc.main.advanced.designpatterns.structural.adapter.GermanInteractions;
import com.mc.main.advanced.designpatterns.structural.adapter.EnglishToGermanAdapter;
import com.mc.main.advanced.designpatterns.structural.adapter.LanguageInteractions;
import com.mc.main.advanced.designpatterns.structural.decorator.Cheese;
import com.mc.main.advanced.designpatterns.structural.decorator.Pepperoni;
import com.mc.main.advanced.designpatterns.structural.decorator.TomatoSauce;
import com.mc.main.advanced.res.CharacterSheet;
import com.mc.main.oop.principles.res.polymorph.Animal;
import com.mc.main.oop.principles.res.polymorph.Cat;
import com.mc.main.oop.principles.res.polymorph.Dog;
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
		System.out.println("CREATIONAL:\n"+"=".repeat(40));
		System.out.println("\nSingleton:\n"+"=".repeat(10));
		singletonPattern();
		System.out.println("\nBuilder:\n"+"=".repeat(10));
		builderPattern();		
	}

	public static void structural() {
		System.out.println("STRUCTURAL:\n"+"=".repeat(40));
		System.out.println("\nDecorator:\n"+"=".repeat(10));
		decoratorPattern();
		System.out.println("\nAdapter:\n"+"=".repeat(10));
		adapterPattern();
	}

	public static void behavioural() {
		System.out.println("BEHAVIOURAL:\n"+"=".repeat(40));
		System.out.println("\nITERATOR:\n"+"=".repeat(10));
		iteratorPattern();
		System.out.println("\nOBSERVER:\n"+"=".repeat(10));
		observerPattern();
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
	

	// STRUCTURAL
	// ========================================	
	public static void decoratorPattern() {
		
		// DECORATOR
		// ========================================
		// The Decorator pattern, in essence allows us to create
		// classes that share implementation and can store their child implementations
		// into a parent decorator. Thus we can have a base class that then
		// continuously changes and adapts by adding additional modules of behaviour.
		// ========================================
		// The decorator pattern allows us to create a concrete class
		// and a decorator class that share the same interface.
		//
		// This interface provides a method that is common to all child classes in this
		// pattern.
		// The decorator class has the capability to store an attribute that
		// allows any class that implements the interface common to this pattern.
		//
		// The decorator can be an abstract class as we extend child classes from it.
		// The child classes then can implement the method from the interface, adapting it
		// so that it can use polymorphism to refer to the parent class methods; this allows us
		// a chain of references as each instance can store another and call their
		// own shared implementation in addition to the parents.
		
		// Before we look at the code in action, let's look at the following interface:
		// Pizza
		
		// Here we can see that the most nested instance: PizzaBase is the concrete class.
		// We can then capture this within the constructor of any child of the Decorator class.
		Pizza myPizza = new Pepperoni(new Cheese(new TomatoSauce(new PizzaBase())));
		
		// then we access this instance method that it shares with the Pizza interface
		// because each child instance chains their instructions in addition to the parent class.
		// generating the total cost and collective description.
		System.out.println("My Pizza costs: " + myPizza.price());
		System.out.println(myPizza.description());
		
		// So we can have completely separate implementations add to an existing concrete class
		// as long as they share a common interface!
	}
	public static void adapterPattern() {
		// Let's observe the differences between EnglishInteractions and GermanInteractions
		// in their respective classes.
		EnglishInteractions englishModule = new EnglishInteractions();
		GermanInteractions germanModule = new GermanInteractions();
		
		EnglishToGermanAdapter adapter = new EnglishToGermanAdapter(germanModule);

		System.out.println("Language Interactions Unique Methods:");
		// Whilst respecting class interface we are forced to use separate
		// class provided interfaces.
		System.out.println(englishModule.greeting());
		System.out.println(germanModule.Gruﬂ());

		System.out.println("\nLanguage Adapter:");
		// Using adapter, we can access the same method to translate the same interface
		// to interface with our GermanInteractions class!
		System.out.println(adapter.greeting());
		

		System.out.println("\nLanguage Interactions Loop:");
		// We can use the shared interface to handle different languages using the
		// same interface interaction!
		List<LanguageInteractions> langModules = new ArrayList<>();
		
		langModules.add(englishModule);
		langModules.add(adapter);
		
		for(LanguageInteractions lang : langModules) {
			System.out.println(lang.greeting());
		}
	}
	
	// BEHAVIOURAL
	// ========================================
	public static void iteratorPattern() {
		// ITERATOR
		// ========================================
		// The Iterator Pattern allows us to set a concrete Container/aggregate
		// as well as a separate Iterator class.
		//
		// Let's observe the AnimalList(our container) & AnimalIterator(our iterator) classes.

		// assuming that our Iterator shares an interface with other iterators - we could
		// have multiple Iterators in the same list - handling different value retrievals.
		// as long a we consider access the items stored via a common implementation
		// we could even handle them in one loop block!
		Animal[] myAnimals = { new Dog("Fido"), new Cat("Tesla") };
		AnimalList myAnimalList = new AnimalList(myAnimals);
		
		Iterator<Animal> myIterator = myAnimalList.iterator();
		
		// Navigate via Iterator
		do {
			System.out.println(myIterator.next().speak());
		} while(myIterator.hasNext());
	}
	
	public static void observerPattern() {
		// OBSERVER
		// ========================================
		// The Observer pattern comprises of two major relationships
		// One of a Subject.
		// One of an Observer.
		//
		// The Subject has a singular or list of Observers.
		// The Subject implements an interface that can manage Observers
		// as well as notify all Observers
		GroupPage catGroupPage = new GroupPage("Everyone Loves Cats");
		List<MediaObserver> subList = new ArrayList<>();

		// Populate Observers to catGroup
		subList.add(new Subscriber("stripyKitten"));
		subList.add(new Subscriber("FurballFriend"));
		subList.add(new Subscriber("CatsRule!"));
		subList.add(new Subscriber("CalmingPur"));
		subList.add(new AdminPostChecker());
		subList.stream().forEach( x -> catGroupPage.addObserver(x));
		
		// now our page can make a post, this will trigger the notify process
		// passing the message to observers
		// Automatically informing the observers they have a new change to review
		catGroupPage.post("We've got a new catbed for sale, check our page for details!" + "\n");
		System.out.println("Observer - News Alerts");
		
		// We can now review each unique Subscriber and their respective inboxes.
		for(MediaObserver sub : subList) {
			if(sub instanceof Subscriber) {
				((Subscriber)sub).printInbox();
				System.out.println("");
			}
		}
		
		// Will attempt to post to subscribers, but will result in addition of ban list
		// This could be developed further to await the AdminPostChecker
		// but the focus here is that an Observer can review a Subject
		// and then perform some action based on a Subject in the Observer Pattern
		//
		// Additional:
		// Observe the catGroupPage.notifyObservers(); method to investigate how we could use this
		// to block a sub group from receiving this message!
		catGroupPage.post("Check out our page relating to dogs!" + "\n");
		
		System.out.println("PAGE BAN LIST:\n" + "=".repeat(40));
		for(MediaSubject sub : AdminPostChecker.retrieveBanList()) {
			if(sub instanceof GroupPage) {
				System.out.println("\t- " + ((GroupPage)sub).getName());
			}
		}
	}

}

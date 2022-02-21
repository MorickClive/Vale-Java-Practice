package com.mc.main.oop.structs;

import java.util.ArrayList;
import java.util.List;

import com.mc.main.oop.principles.res.abstraction.Bird;
import com.mc.main.oop.principles.res.abstraction.Penguin;
import com.mc.main.oop.principles.res.abstraction.Seagul;

public class GenericsPractice {
	
	private GenericsPractice() { super(); }
	
	public static void start() {
		// Observe the nested generic "Cage" below
		// return here to observe how a generic allows us to expand our type restrictions.
		// We can also limit interaction with a stored generic attribute!
		
		// Notice that when we use a generic, we need to provide the data type within
		// the variable data type declaration.
		//
		// we do not have to provide the generic for the initialising value however
		// this is a result of type inference from the java compile; who understands
		// from the context of assignment that it should be a "new Cage<Bird>()";
		Cage<Bird> birdCage = new Cage<>("Large");
		
		// This syntax might look familiar because we've already technically used Generics!
		// using ArrayList<> objects require a prerequisite type to handle.
		// Hopefully it now makes sense as to how ArrayLists now handle functionality!
		
		// Our cage should be empty.
		System.out.println(birdCage.viewBird());
		
		// let's place a bird in our cage!
		birdCage.insertBird(new Seagul("Common Gull"));
		
		// Our cage should now contain a seagul!
		System.out.println(birdCage.viewBird());
		
		// let's retrieve our bird!
		Bird fred = birdCage.getBird();
		
		// Our cage should be empty again!.
		System.out.println(birdCage.viewBird());
		
		// let's really mix it up and have multiple cages with different birds stored inside!
		List< Cage<Bird> > listOfBirdCages = new ArrayList<>();

		birdCage.insertBird(fred);
		listOfBirdCages.add(birdCage);
		
		birdCage = new Cage<>("large");
		birdCage.insertBird(new Penguin("Emporer Penguin"));
		listOfBirdCages.add(birdCage);
		
		for(Cage<Bird> cage : listOfBirdCages) {
			System.out.println(cage.viewBird());
		}
		
	}
	
	// Generics are a form of type templating within the context of class implementation.
	// Whilst the definition is abstract, the usage of Cage as a variable will define
	// what type of data it might handle, it uses the arrow brackets: "<>" to help provide
	// a referential value "T"(although it can be any letter or word) that enables use to 
	// provide a type when we decide to use it!
	//
	// Optional: when you write a Generic "<T>" we can also set limiters for
	// 			 the "upper limit" of an acceptable data type.
	//
	//			 After all, java is only able to expose the interface of a class
	//			 to the highest level of inheritance!
	//			 As such we'll set this Cage to hold any type of Bird as
	//			 a caged penguin would be larger than our intended Cage size as
	//			 part of this java app.
	public static class Cage<T extends Bird> {
		// If we want multiple generics, we can provide a comma seperated list
		// within the angled brackets.
		
		private String cageType;
		private T bird;
		
		// As we can see above, the attribute bird is using the generic type "T"
		// this means that we know bird is capable of being any type of Bird
		// but it'll be limited to Bird or any child instance of this class limitation!
		
		public Cage() {
			super();
			this.cageType = "Standard";
			this.bird = null; // the cave is empty!
		}
		
		public Cage(String cageType) {
			this();
			this.cageType = cageType;
		}
		
		public Cage(String cageType, T bird) {
			this(cageType);
			this.bird = bird;
		}
		
		// METHODS
		// ========================================
		// Generics are a good way to limit interface exposure but also
		// provide a class that isn't concretely set to one bias in terms of data types.
		//
		// Just remember that because the generic "T" is extending a class, it allows
		// us to use that upper limit to infer what T is capable of; at least at the highest
		// level of implementation!
		public String getCageType() {
			return cageType;
		}

		public void setCageType(String cageType) {
			this.cageType = cageType;
		}

		public T getBird() {
			T extract = this.bird;
			this.bird = null;
			
			return extract;
		}

		public void insertBird(T bird) {
			this.bird = bird;
		}
		
		public String viewBird() {
			String result = this.bird != null ? 
				String.format("It appears there is a %s within this %s cage.", this.bird.getSpecies(), getCageType())	: 
				String.format("There is no bird in this %s cage.", getCageType());
			
			return result;			
		}
		
	}

}

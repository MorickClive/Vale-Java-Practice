package com.mc.main.oop.structs;

public class EnumerationPractice {
	
	private EnumerationPractice() { super(); }
	
	public static void start() {
		
		// For this section we'll look at the nested enum below
		// and then observe how an enum can be put in use in regular
		// code execution in the start method.
		
		// Values
		// ========================================
		// Enums are generally just a list of constants
		// as such it may prove useful to treat an enum like
		// an array for the purposes of listing or access all
		// available constants.
		//
		// We can do this using the '.values()' method.
		System.out.println("List of planets:\n"+ "=".repeat(40));
		
		for(Planet planet : Planet.values()) {
			System.out.print(planet);
			System.out.println(",\t number of hours in days: " + planet.getHoursInDay());
		}
		
		// Switch-Case
		// ========================================
		// Enums work particularly well as comparisons as their values do not change.
		// Each case will ommit the reference to the containing enum and just use the
		// Constant values.
		Planet myPlanet = Planet.MERCURY;
		
		// We'll keep this example short without any scope breaks
		// to allow for maximum code coverage; hopefully we can see
		// the distinction between standard case values and how java will
		// understand we are using a enum instead; allowing the use of isolated constants!
		switch(myPlanet) {
			case MERCURY:
			case VENUS:	
			case EARTH:	
			case MARS:	
			case JUPITER:
			case SATURN:	
			case URANUS:	
			case NEPTUNE:
			default:
		}
	}
	
	// Enums, or Enumerated values can be defined like a class, but instead of the
	// class keyword, we use the 'enum' keyword.
	//
	// Enums are very similar to classes, it contains non-typed attributes - however it is
	// slightly different from the typical example of an attribute.
	// each non-typed member of the enum has the following access modifiers 'public static final';
	// 
	// This means that enums are perfect to generate groups of constants that can be referenced
	// for the purposes of decision making or value referencing!
	//
	// ~: For this example we will use a nested class to encapsulate it within this class practice.
	//	  But enums can be their own files just like classes!
	public static enum Planet {
		
		// As we provide enumerated values we typically use all uppercase
		// to help distinguish them as unchanging constants.
		// they do not have to include a set of brackets, however
		// if they do, it implies the enum has a constructor!
		MERCURY(4222.6),
		VENUS(2802.0),
		EARTH(24.0),
		MARS(24.7),
		JUPITER(9.9),
		SATURN(10.7),
		URANUS(17.2),
		NEPTUNE(16.1);
		
		// non-static values belong to a single constant and are usually
		// initialised once as part of the constructor!
		private final double hoursInDay;
		
		// enums can have constructors, it's not necessary to include
		// but it can provide a means of associating data outlined as 
		// typed attributes to that particular constant!
		//
		// constructors in enums are private; as initialised values are part of a
		// constant, they are unchanging and therefore are set as part of the constant
		// definition within the enum.
		//
		// Notice that this is a non-static method in a enum/class!
		// this means that the constructor is for the non-typed attribut/constant.
		// observing above, we can see that the constant is followed by brackets
		//
		// These brackets represent this constructor!
		private Planet(double hoursInDay) {
			this.hoursInDay = hoursInDay;
		}
		
		// We can assign methods to extract attributes from our constant
		public double getHoursInDay() {
			return this.hoursInDay;			
		}
		
	}

}

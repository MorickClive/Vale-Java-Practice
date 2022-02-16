package com.mc.main.oop.classres;

/**
* Classes are a fundamental concept in Object-Oriented Programming.
* 
* Classes, much like methods have a definition and a scope.
* Classes can be used like data types and can have associated attributes and method functionality.
* 
* Classes represent some kind of entity or object, tracking its details and the actions it can take.
* We can write a class that could represent a person or motor vehicle; tracking data and 
* functionality that these entities are capable of.
* 
* To define a class, we need to use the following features:
* - accessor - "public"
* - class keyword
* - class name - ClassPractice
* - scope
* 
* We'll investigate the meaning of accessors in Encapsulation, for the time being we'll use "public".
* 
* Generally class definitions are written in its scope and typically comprise of:
* - Attributes - variables that belong to the class as a whole, visible to all class methods.
* - Constructors - A special method that is executed when you create an instance(or value) of this class.
* - Methods - functionality that is associated with the class object.
* 
*/
public class ClassPractice {
	
	// ATTRIBUTES
	// ========================================
	// Attribute are variables that belong to a class.
	// a class can have multiple attributes; if these variables aren't
	// provided a value, they have their respective default value.
	// If the data type is not primitive the default value will be "null".
	public String name;
	
	// CONSTRUCTORS
	// ========================================
	// Just like methods, Constructors can be overloaded.
	// Constructors always run when you attempt to create an instance of a class, e.g:
	// ClassPractice example = new ClassPractice();
	public ClassPractice() {
		// The super keyword will be explained in inheritance.
		// Generally, versions of java + will provide a default constructor if
		// a developer doesn't define one.
		super();
	}
	
	// Overloaded Constructors
	// ========================================
	// An Overloaded constructor can allow us to provide parameters to a constructor,
	// parameters can be useful as part of a constructor as it gives us the option
	// to provide values on initialisation of this data type.
	//
	// In the example below, we can create an instance and immediately provide a value
	// to the class attribute 'String name;' observe below the declaration and initialisation:
	// ClassPractice example = new ClassPractice("MyClass");
	public ClassPractice(String name) {
		super();
		// As you can see the parameter we passed is called "name", however,
		// the attribute we defined this class is also called "name".
		// So we need to differentiate between the class attribute and the localised
		// parameter name.
		//
		// We can do this using the 'this' keyword; in the context of the class
		// the 'this' keyword reflects this class object/instance, thus we can explicitly
		// target the name attribute as follows:
		this.name = name;
	}
	
	// METHODS
	// ========================================
	// We've looked at methods in MethodPractice.
	// We'll look at "gettors" and "settors" in encapsulation
	// however this is a great opportunity to understand the difference between
	// static and non-static context.
	
	// A non-static method belongs to the class instance!
	// ==============================
	// What does that mean?!?
	// Well an instance of a class is much like a value of a variable, but there's a little
	// more to it than just that.
	//
	// A instance of a class looks like the following:
	// ClassPractice sampleVariable = new ClassPractice("My_Instance_1");
	//
	// As you can see, the 'new' keyword creates an instance of the ClassPractice definition.
	// when we create a new instance of a class - all the non-static methods and attributes
	// are copied from the definition and are tracked uniquely!
	//
	// This means we could have multiple instances of ClassPractice, each with their own
	// name!
	// 
	// So the method below would be used like follows:
	// sampleVariable.returnName(); // returns "This objects name is: My_Instance_1";
	
	public String returnName() {
		return "This objects name is: " + this.name;
	}
	// Sometimes an instance of a class might be referred to as an "object" or "entity".
	// Instances are an independent unique memory-allocated example of this class.
	// The Static context is like a global instance, the definition has an instance
	// that is shared to all future instances.
	
	// Static methods
	// ==============================
	// WARNING:
	// If you aren't certain about the 'static' keyword, do not use it!
	// it can be learned through practice and observation.
	// ==============================
	// A static method or attribute belongs to the class definition.
	// But what does that mean?
	//
	// When we use "String.format()" method, we are using the class definition - 
	// we don't need a value in order to refer to the method.
	//
	// In this case, the returnMessage method can be access via:
	// "ClassPractice.returnMessage();"
	// We don't need to make an instance of the class using the 'new' keyword!
	public static String returnMessage() {
		return "This is ClassPractice message";
	}
	
	// For reference:	
	// The static context belongs to the class definition.
	// The non-static context belongs to the instance of the class.
}

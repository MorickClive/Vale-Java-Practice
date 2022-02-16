package com.mc.main.oop.classres;

public class ClassAdvancedPractice {
	
	// ATTRIBUTES
	// Attributes can be provided default values;
	public static int idTracker = 0;
	public int id;
	public String name;
	
	// CONSTRUCTORS	
	public ClassAdvancedPractice() {
		super();
		// See "Static Attributes"
		// We can increment the global ID that is stored in the global definition(the global instance).
		ClassAdvancedPractice.idTracker++;
	}
	
	// Constructor Chaining
	// ========================================
	// We can use something known as constructor chaining
	// to refer to another constructor to access instructions comment to
	// constructor overloads, all constructors refer to "super".
	// So we can use the "this();" method to refer to the constructor that calls "super();"
	public ClassAdvancedPractice(int id, String name) {
		this(); // calls super(); on line 13
		this.id = id;
		this.name = name;
	}
	

	// Static Attributes
	// ========================================
	// Because static and non-static contexts can be complementary, 
	public ClassAdvancedPractice(String name) {
		// We can use the global definition to auto increment the idTracker 
		// (which is incremented in the default constructor)
		// passing this via constructor chaining to provide the value for the id;
		this(ClassAdvancedPractice.idTracker, name);
		
		// Because the shared constructor adds 1 to the idTracker (Stored in definition).
		// When we create an instance of this we automatically provide a value to id, but that
		// id comes from the global definition and set in this local instance.
		//
		// The local instance will always have a fixed id
		// the global definition/instance will always increment id that is refered to by
		// local instances.
	}	
	
	// METHODS
	// ==============================
	
	public boolean example() {
		return true;
	}
	
	// As we can see, the global definition can have methods.
	// static methods however, aren't available from instanced, 
	// non-static instances.
	public static int getIdTracker() {
		return ClassAdvancedPractice.idTracker;
	}

}

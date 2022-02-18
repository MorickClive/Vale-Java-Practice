package com.mc.main.oop.principles.res;

public class EncapsulationAdvanced {
	
	// Final
	// ========================================
	// Whilst modifiers might change the visibility of methods or attributes
	// the final keyword can be added onto attributes.
	// this keyword prevents a variable from changing the value it stores
	// it cannot be overwritten by any means after being set.
	// This can be very useful for locking down the ability to modifier data
	// that should never change, these are typically considered constants.
	//
	// Constants usually exist in a static context, because instanced variables
	// contain unique data but adapt to change; that's not to say there are no cases
	// final might be used in a non-static context, but it's rare.
	private static final double VERSION_NUMBER = 1.00;
	
	private EncapsulationAdvanced() { super();	}
	
	public static void start() {
		Employee example = new Employee("Alex", "£xx,xxxx", "Software Engineer");
		
		System.out.println(example);
	}
	
	// Nested classes
	// ========================================
	// Whilst we've avoided the use of nested classes, it's good to know of the importance
	// Encapsulation has in relation to classes within class objects.
	//
	// Nested classes are separated into two distinct categories
	//
	// Non-Static nested classes
	// ========================================
	// Also known as inner classes, but only in it's static context,
	// they have access to their encompassing classes members - even if they are private!!
	//
	// Static nested classes
	// ========================================
	// Are classes that exist within another class, but only in it's static context,
	// they do not have access to their encompassing classes members.
	//
	// Here we're using a static declaration so we can instantiate an example in our static method above!
	// Be aware, nested classes can be tricky to test and can add to complexity of readable code.
	protected static class Employee {
		
		private String name;
		private String wage;
		private String role;

		public Employee() { 
			super();
			
			// Whilst this isn't great for readability
			// it is good to know that execution of code is typically
			// right to left, as a result we can use this to initialise
			// multiple values.
			//
			// Consider that this is looser in terms of independent values
			// with the string pool, these three attributes share the same value.
			
			// e.g:
			//this.name = this.wage = this.role = "???";			
			
			// HOWEVER, we are assigning a value to one attribute
			// and then assigning the references in a chain for wage and name
			// they will store a reference, rather than a value.
			//
			// This can result in undesirable behaviour and thus should be avoided!
			// Initialise with unique values on separate lines; it's just good practice.
			this.name = "???";
			this.wage = "???";
			this.role = "???";			
		}
		
		public Employee(String name, String wage, String role) { 
			this();
			this.name = name;
			this.wage = wage;
			this.role = role;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getWage() {
			return wage;
		}

		public void setWage(String wage) {
			this.wage = wage;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		// We'll explore this in more depth in inheritance
		@Override
		public String toString() {
			return "Employee [name=" + name + ", wage=" + wage + ", role=" + role + "]";
		}
		// END OF NESTED CLASS
	}

}

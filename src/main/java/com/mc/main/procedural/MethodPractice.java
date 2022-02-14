package com.mc.main.procedural;

public class MethodPractice {
	
	// In Java we can write a basic application such as the following:
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	// Analysing what we have above, we can craft another "method"
	// Java generally executes "public static void main()" as a point of entry
	// for any class - however your application as a whole should only ever
	// have one entry point for running/"executing" it.
	// ~: It's important to remember that the "public static void main()" method is uniquely
	//	  understood by java.
	//
	// The main entry point of this application is found in the `Runner.java` file!
	// the above is only used as an example!
	public static void start() {
		
		// FlowControlPractice recap:
		// ========================================
		// A method usually defined within the scope "{" "}" of a class
		// a method is comprised of:
		//		- accessor - "public" - others will be covered in classes
		//		- static keyword - will be covered in classes.
		//		- return type - void; meaning no value expected to be returned
		//		- method name - "start"
		//		- parameter list - parenthesis
		//		- scope - curly brackets
		//
		// We can invoke another method within a method as long as it has access to it.
		// A method can see any other method within the same class.
		//
		// We can do this by writing the name of the method and it's parenthesis
		// the method will be called by java and the called method will perform its
		// set of instructions(top down, line by line)
		// as seen below:
		printHello();
		
		// Please move onto the ArraysPractice.java
		// Now we are familiar with methods, feel free to explore
		// methods with your understanding of flow and control.
		// reading code is a skill unto itself!
	}
	
	protected static void printHello() {
		System.out.println("Hello");
	}
	
	// Sometimes a method won't just be called in isolation but may result in 
	// a final value being return instead.
	// In this example we can see how this can be applied to variables we use.
	protected static void variableExample() {
		float value = 5.0f;
		
		// Method Invocation
		// ========================================
		// We have a value but perhaps we call a method that returns a value.
		// let's call the method which returns a value
		returnOne();
		
		// Method return values
		// ========================================
		// Whilst the above the will work and run the instructions, the value is lost
		// after the method is called. 
		// The value it returns isn't stored and therefore the value of
		// performing it is lost.
		//
		// HOWEVER:
		// If we use the method as though it were a value, it will be executed first
		// then the returning value is stored for later use:
		value = returnOne();
		
		// value is now equal to 1.0f!
		
		// Passing Parameters
		// ========================================
		// We can create methods that take in values as part of their usage.
		// We can give it value - but the method must first be written in the class
		// scope to expect these values and understand how to use them.
		value = add(15, 23);
		
		// Value should now be equal to 38.0f
		
		// Overloading
		// ========================================
		// Here we are calling the overloaded version of add:
		value = add(15, 23, 3); // result float 41.0f
		
		// VarArguments
		// ========================================
		// Here we are calling the varArgument
		// ~: This will be covered again in Arrays and Iteration/loops
		value = addList(4, 5, 6, 7, 12, 40);
		
		// result now equals float 74.0f
	}

	/** Notice that the method return type is float
	 * this means that this method needs to use a 'return' keyword
	 * in conjunction with a value that matches the return type the method outlines.
	 * In this case - some kind of numeric float value.
	 * 
	 * @return - 1.0f floating point value.
	 */
	protected static float returnOne() {
		return 1.0f;
	}
	
	/**
	 *  The method here includes a parameter list, this is
	 *	between the parenthesis("brackets"), both x and y are declare like variables
	 *	and in a sense they are treated in a similar way.
	 *
	 *	Parameters are declared variables that are requirements for calling this method.
	 *	When you attempt to invoke this method you'd have to provide values that match
	 *	the data type of the parameter defined.
	 *	
	 *	The values provided then map to 'x' and 'y' respectively.
	 *	We can then use these references within the method.
	 *	Below is an example where the product of x and y are returned after invocation.
	 *
	 * @param x - a floating point value.
	 * @param y - a floating point value.
	 * @return - product of x + y.
	 */
	protected static float add(float x, float y) {
		return x + y;
	}
	
	/**
	 * Overloading
	 * ========================================
	 *	Whilst we cannot have variables that have the same name within a method
	 *	Methods can be written in a class more than once with different functionality.
	 *	Generally functionality shouldn't be too different, but might extend capability
	 *	of what a method can do.
	 *	
	 *	The process being described is known as method overloading.
	 *	Overloaded methods typically appear like a previously written method but
	 *	include additional or reduced parameters
	 *	for example, we could extend the method above to handle 3 parameters.
	 *
	 *	@param x - a floating point value.
	 *	@param y - a floating point value.
	 *	@param z - a floating point value.
	 *	@return - product of x + y + z.
	 */
	protected static float add(float x, float y, float z) {
		return x + y + z;
	}
	
	
	/**
	 * Variable Arguments or varArgs
	 * ========================================
	 * To appreciate this example, you might need to look into iteration/loops as well as arrays
	 * when we declare a parameter with ellipses we are actually expecting multiple values for a
	 * method parameter.
	 * 
	 * We can cycle through this list and the number of provided values might be variable,
	 * this result is stored like an array and can be handled like such.
	 * 
	 * However, one major rule with varArgs is that you should not overload methods
	 * that use them. This can cause an issue with the compiler, it is also
	 * not a frequently used technique and can sometimes be more obtrusive to readability.
	 */
	protected static float addList(float... list) {
		float result = 0;
		
		// for each item in the list, add the value to our total result.
		for(float item : list) {
			result += item;
		}
		
		return result;
	}
	
	/** We don't want to create an instance of this class */
	private MethodPractice() { super();	}
}

package com.mc.main.procedural;

public class MethodPractice {
	
	private MethodPractice() { super();	}
	
	// In Java we can write a basic application such as the following:
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	// Analysing what we have above, we can craft another "method"
	// java generally executes "public static void main()" as a point of entry
	// for any class - however your application as a whole should only ever
	// have one entry point for running it.
	// ~: it's important to remember that the "public static void main()" method is uniquely
	//	  understood by java
	public static void sampleMethod() {
		// a method usually defined within the scope "{" "}" of a class
		// a method is comprised of 
		// an "accessor" - "public" - others will be covered in classes - Encapsulation
		// a "static" keyword - optional; will be covered in classes
		// a "return type" - void
		// and a method name (followed by parenthesis and then its scope)
		
		// We can call another method within a method as long as this method has access to it
		// to simplify understanding in this case, a method can see any other method
		// within the same class.
		//
		// We can do this by writing the name of the method and it's parenthesis
		// the method will be called by java and the called method will perform its
		// set of instructions(top down, line by line)
		// as seen below:
		printHello();
	}
	
	protected static void printHello() {
		System.out.println("Hello");
	}
	
	// Sometimes a method won't just be called in isolation
	// but may result in a final value being return instead.
	// in this example we can see how this can be applied
	protected static void variableExample() {
		float value = 5.0f;
		
		// We have a value but perhaps we call a method that returns a value.
		// let's call the method which returns a value
		returnOne();
		
		// Whilst the above the will work and run the instructions, the value is lost
		// after the method is called, the value it returns isn't stored - and therefore
		// the value of it's function is lost
		//
		// however, if we use the method as though it were a value, it will be executed first
		// then stored:
		value = returnOne();
		
		// the method above, is executed, returning the value 1.0f - which is then stored in our
		// value variable
		
		// finally, we can create methods that take in values as part of their usage
		// we call "the calling" of a method a invocation, when we invoke a method
		// we can also give it value - but the method must first be written to expect these
		// values.
		value = add(15, 23);
		
		// The result should be that value now contains the float 38.0f
		
		// Here we are calling the overloaded version of add:
		value = add(15, 23, 3); // result float 41.0f
		
		// Here we are calling the varArgument
		value = addList(4, 5, 6, 7, 12, 40); // result float 74.0f
	}

	// notice that the method return type is float
	// this means that this method needs to use a 'return' keyword
	// in conjunction with a value that matches the return type the method outlines
	// in this case - some kind of numeric float value.
	protected static float returnOne() {
		return 1.0f;
	}
	
	// The method here includes a parameter list, this is
	// between the parenthesis("brackets"), both x and y are declare like variables
	// and in a sense they are treated in a similar way.
	//
	// Parameters are declared variables that are requirements
	// for calling this method, so you would provide values, rather than trying
	// to create a variable whilst invoking this method.
	// The values provide then map to x and y respectively.
	// we can then use these references within the method.
	// below is an example where the product of x and y are returned after invocation.
	protected static float add(float x, float y) {
		return x + y;
	}
	
	// Overloading
	//
	// whilst we cannot have variables that have the same name within a method
	// Methods can be written in a class more than once with different functionality
	// generally functionality shouldn't be too different, but might extend capability
	// of what a method can do.
	// The process being described is known as method overloading.
	// overloaded methods typically appear like a previously written method but
	// include additional or reduced parameters
	// for example, we could extend the method above to handle 3 parameters
	protected static float add(float x, float y, float z) {
		return x + y + z;
	}
	
	
	// Variable Arguments or varArgs
	// To appreciate this example, you might need to look into iteration/loops as well as arrays
	// when we declare a parameter with ellipses we are actually expecting multiple values for a
	// method parameter.
	// We can cycle through this list and the number of provided values might be variable,
	// this result is stored like an array and can be handled like such.
	// 
	// However, one major rule with varArgs is that you should not overload methods
	// that use them. This can cause an issue with the compiler, it is also
	// not a frequently used technique and can sometimes be more obtrusive to readability.
	protected static float addList(float... list) {
		float result = 0;
		
		// for each item in the list, add the value to our total result.
		for(float item : list) {
			result += item;
		}
		
		return result;
	}
}

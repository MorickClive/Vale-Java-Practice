package com.mc.main.oop;

public class WrapperClass {
	
	public static void start() {
		wrapperClasses();
		autoBoxing();
	}
	
	private static void wrapperClasses() {
		// When we started looking into arrays, there was a distinction
		// between primitive data and complex wrapper types.
		
		// We are use to writing variables with primitive data types such as the following:
		int myNumber = 12;
		
		// However there is no functionality associated with this variable.
		// but Java provides a complex version of each primitive data type:
		Integer myIntNumber = new Integer(12);
		
		// This new data type or wrapper class is just that - a class - an instance
		// that wraps the primitive data type inside a class with methods that control
		// the value in some way, or even provide us with the ability to translate that
		// value into a different type!
		float myfloat = myIntNumber.floatValue();
		
		// As we've observed, these classes are instances, holding unique values
		// that represent the number we want to store and handle.
		// 
		// But it is also useful to know that these wrapper classes have a static context
		// a series of constant values as well as methods that can help you control or
		// modify primitive data type values!

		// To explain these constants, we have to recall that data precision
		// varies between available space java can reserve.
		// this value is in the number of bit/bytes that make up the memory space provided
		// Integers have a limited upper and lower cap of values that can be represented
		// but a Wrapper class can provide that value upon invocation!
		System.out.println("Integer reserved space size: " + Integer.BYTES * 8 + " Bits.");
		System.out.println("Integer minimum achievable value: " + Integer.MIN_VALUE);
		System.out.println("Integer maximum achievable value: " + Integer.MAX_VALUE);
		
		// Wrapper classes typically differ from their primitive counterpart
		// this is usually by the PascalCase that is use; as in they begin with
		// a capital, rather than lowercase.
		//
		// an exception to this is that some wrapper classes have a distinct
		// name, as we've seen with int/Integer.
		System.out.println("12.5f as a hex value: " + Float.toHexString(12.5f));
		
		// Available primiative to wrapper classes can be seen below:
		// boolean		-> Boolean
		// byte			-> Byte
		// char			-> Character
		// float		-> Float
		// int			-> Integer
		// long			-> Long
		// short		-> Short
		// double		-> Double
		
	}
	
	private static void autoBoxing() {
		// As of Java 9, using the new keyword with object types has been considered
		// deprecated, this has instead been replaced with a more performance efficient
		// factory method: '.valueOf(int x)'
		Integer.valueOf(12);
		
		// However as far back as java 1.5 we had access to autoboxing
		// a technique that the java compiler uses to infer a primitive type
		// to a wrapper class during initialisation:
		Double myDouble = 12.50D;
		
		// In cases where we want to extract a primitive value from a Wrapper class
		// we can use the a process referred to as "unboxing".
		// Extracting the value out from the class object.
		double myPrimitiveDouble = myDouble.doubleValue();
		
		// we can also simply provide a direct assignment, the compiler will
		// understand that unboxing is needed when reversing the process.
		myPrimitiveDouble = myDouble;
	}
	
	/** We don't want to create instances of this class! */
	private WrapperClass() { super();	}

}

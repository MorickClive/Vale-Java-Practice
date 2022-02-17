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
		
	}
	
	private static void autoBoxing() {
		// As of Java 9, using the new keyword with 
		
	}
	
	/** We don't want to create instances of this class! */
	private WrapperClass() { super();	}

}

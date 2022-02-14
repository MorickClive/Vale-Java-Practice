package com.mc.main.procedural;

import java.util.ArrayList;
import java.util.List;

public class ArraysPractice {

	// This topic may cover concepts within the classes/object-oriented topics
	public static void start() {
		// Primitive data 
		primativeArrays();

		// Class initialised Arrays
		wrapperArrays();
		
		// Please move onto OperatorsPractice.java
	}

	// This topic explores the basics of java arrays
	private static void primativeArrays() {
		// Programming is heavily build upon mathematics principles
		// Java respects the handling of numeric data as variables, but also can use
		// sets of numeric data in the forms of variable arrays.

		// To create an array we need to declare a variable with square brackets to
		// imply an array structure.
		// variable arrays are very much similar to variables, but represent multiple
		// memory locations to
		// store data.
		int[] x;

		// X now can technically store multiple values, when we create an array, we
		// first must
		// declare how many variable spaces we want to use.
		// We can declare this using the new keyword in conjunction with square brackets
		// containing a number
		// within the brackets to determine the size of the array.
		x = new int[5];

		// Just like variables we can declare and initialise an array at the same time.
		// additionally we can also provide a list of values as an alternative means of
		// initialisation
		// such as the following:
		int[] y = { 1, 2, 3, 4, 5 };

		// Finally, we have the capability to create a set of sets, in simpler terms, a
		// 2-Dimensional array.
		// We can provide additional brackets to the data type to imply a second set of
		// square brackets.
		// In the following example we can see how we can create this "set of sets".
		int[][] z = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } };

		// alternatively we can set the size of the multiple dimensions
		// a way to understand the structure is often to compare to the x & y axis(& in
		// 3-Dimensional arrays, z)
		int[][] i = new int[5][5];

		// Here is a visualisation to the z array:
		// {1, 2, 3, 4, 5 }
		// {6, 7, 8, 9, 10}

		// If we can provide values in an array, declared and initialised, what happens
		// with arrays
		// that we use the new keyword with?
		// Well primitive data without values in Java are usually assigned their default
		// value.
		// as such the array labels 'x' has 5 values which should all store default
		// integer values
		// meaning the array should appear like the following:
		// x = {0, 0, 0, 0, 0}

		// So if we can store values in an array, how do we extract or assign a value to
		// the array
		// well we can use the square brackets on the variable to specify the array
		// position, this is usually referred to as the "array index".
		// HOWEVER, array positions begin at position 0 and reach the size of the array,
		// with
		// consideration from a starting position meaning the final position is
		// typically the
		// size -1.

		// So if we wanted to find the 3rd value in the array labelled 'y'
		// we can do the following:
		System.out.println(y[2]);

		// and if we wanted to extract a value from a multi-dimensional array such as
		// 'z'
		// we can do the following:
		// To select the 2nd value from the 2nd set from array 'z'
		System.out.println(z[1][1]);
	}

	// Topics explored here are covered with respect to object-oriented topics
	// You may wish to refer to WrapperClasses Practice.
	private static void wrapperArrays() {
		
		// It is advisable to investigate Wrapper objects to gain a full appreciate of the dynamics
		// of Wrapper Objects that represent primitive data types.
		
		// Whilst all declarations of primitives in java are inherently understood,
		// arrays are actually translated to a simplified object structure
		// this is part of the reason we can use the new keyword to create an array.
		// additionally the implementation of a provided list is also translated into class object
		// with the initialised values stored appropriately.
		
		// As such, even primitive arrays have access to methods such as '.length'; which returns the size of
		// the array, as well as including additional functions in the form of methods.
		int[] x = { 1, 2, 3, 4, 5 };
		
		System.out.println("The number of item in the array 'x' is: " + x.length);
		
		// Unfortunately once you've declared the array with a size, it remains fixed unless replaced with
		// an entirely new java object to represent a new array when using primitive data types.
		// As such java has implemented an Object representation of an Array with enhanced capabilities.
		// the Object in question would be an ArrayList, with inheritance to the Collection interface.
		// An ArrayList can use the new keyword to initialise the object.
		// See the below example for declaration and initialisation:
		List<Integer> myIntegerList = new ArrayList<>();
		
		// It is also important to observe that the data type of a ArrayList is determined between the
		// angled brackets '<'/'>' on the List Object declaration.
		
		// Using methods provided by the List class, we can access the list we've stored
		// with increased capability to interact.
		// In particular the size of an ArrayList object can increase when using the respective
		// add or remove methods;
		myIntegerList.add(2);
		myIntegerList.add(5);
		
		// We can also query the array like the primitive equivalent '.size()' method.
		myIntegerList.size();
		
		// Final word: 
		// it is important to observe that an ArrayList would require a Wrapper object
		// to provide a data type to of the values to store within the array.
		
	}

	protected static int[] createPrimativeIntegerArray(int arraySize) {
		return new int[arraySize];
	}
	
	protected static int[] createPrimativeIntegerArray(int... contents) {
		int[] x = new int[contents.length];
		
		for(int y = 0; y < contents.length; y++) {
			x[y] = contents[y];
		}
		
		return x;
	}
	
	protected static List<Integer> createIntegerList(int arraySize) {
		List<Integer> list = new ArrayList<Integer>();
		
		// Observe Topic of Iteration to explore the 'for' keyword
		for(int x = 0; x < arraySize; x++) {
			list.add(0);
		}
		return list;
	}
	
	/** We don't want to create an instance of this class */
	private ArraysPractice() { super(); }

}

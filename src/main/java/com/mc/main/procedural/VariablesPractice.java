package com.mc.main.procedural;

public class VariablesPractice {
	
	// Variables can also be declared in the class scope
	// their appropriate name is then referred to as an "attribute"
	// this is because this variable is tracking something relating to this class
	// or holds some importance to the class it is contained with
	// ========================================
	// attributes are assigned default values if left uninitialised, each data type has its own default value
	// that is usually equal to the zero equivalent value.
	// ========================================
	private static byte myByte;
	private static short myShort;
	private static int myInt;
	private static long myLong;
	private static float myFloat;
	private static double myDouble;
	private static boolean myBool;
	private static char myChar;
	
	public static void start() {
		// An application in Java runs from the top of a scope ('{') - methodically, 
		// line by line until it hits the end scope line ('}') of a method.
		
		// instructions are performed which have meaning to Java and are typically terminated by a semi colon.
		// the instruction below is refering to a method stated within the scope of this class('VariablesPractice')
		// methods are usually self contained groups of instructions that can be refered to as "part of" or "within a" class.
		init();
	}
	
	// Primitives
	private static void init() {
		// Primitive variables in Java are data types that are inherently understood by Java to store values within a memory range
		// variables may vary in memory size due to the respective bits assigned to that data type.
		// primitives in Java comprise of: byte, short, int, long, float, double, boolean and char
		
		// Variables can be declared without having to be provided a value
		// Unlike wrapper classes, uninitialised variables have a preset "null" value determined by Java
		byte myByte;
		
		// Variables that are declared are then understood to be part of the procedural flow of the application
		// we can use this to assign a value to the variable above using the 'equals' symbol
		myByte = 0;
		
		// Likewise we can declare and initialise a variable immediately by providing
		// the type, name of the variable and value to be assigned to that
		short myShort = 0;
		
		// Ints are Integers, they represent whole numbers, but not decimal values
		// if decimals are introduced they will perform a process known as truncation - simply removing the
		// fractal value.
		int myInt = 0;
		
		// Longs have a larger range of memory associated with the storage of integer values.
		// ~: if you wish to tell Java this value is absolutely a Long value
		//	  you can provide an `L` value directly after the numeric value. 
		long myLong = 0L;
		
		// Floating point values hold a decimal value.
		// ~: if you wish to tell Java this value is absolutely a Float value
		//	  you can provide an `f` value directly after the numeric value. 
		float myFloat = 0.0f;
		
		// doubles are floating point values with a higher range of available memory, 
		// this aids with mathematical precision.
		// ~: if you wish to tell Java this value is absolutely a Double value
		//	  you can provide an `D` value directly after the numeric value. 
		// 	  HOWEVER: all floating point values without a letter to reinforce meaning are understood by
		//	  Java to be of the `double` type
		double myDouble = 0.0;
		
		// Booleans are usually values with either a 'on' or 'off' state, they do not store much in memory
		// due to simplicity as well as readability you will find the values true and false are keywords that
		// represent boolean values. they are useful for toggles and conditional flags.
		boolean myBoolean = false;
		
		// Chars or Characters are where data types get more complex, characters represent singular letters.
		// however letters are represented in numeric form, programmers who are familiar with the Ascii table
		// know that characters represent in a number of numeric bases
		char myChar = 0;
		
		// Variables are just as they imply by namesake; variable, the value we store inside a variable can
		// be referred to any time we mention that variable in a programming application.
		// as such we can replace/overwrite the value stored in a variable.
		
		// We'll use a Char for this example, just to place emphasis on the fact you can use single
		// quotations around a letter to provide a value for the variable to hold onto.
		myChar = 'a';
		
		// Strings are often used in Java applications, however they are NOT primitive variables in Java.
		// Strings are a collection of chars that form words from their structure.
		// To pass a value to a String we surround a sentence of words in quotation marks.
		String myString = "Hello World!";
		
		// Whilst this can be considered bad practice, variables can also be initialised or declared on the
		// same line. This is discouraged as it can lead to poor readability or complications 
		// with application builds/practices.
		// this can be done by providing commas after the declaration or initialisation.
		//
		// WARNING:
		// It is important that the variables all conform to the same data type during declaration.
		int x, y, z;
		int i = 0, j = 0, k = 0;
		
		// values of variables can also be chain during initialisation, meaning that you can have one 
		// variable initialise from a singular variable, this can be a useful technique to reduce
		// the declaration of a singular value to multiple variables as a standard
		// however you should consider avoiding this practice beyond initial setup as it can
		// Obfuscate the meaning of code and the intention of your programming.
		z = 0;
		x = y = z;
		
		// Additional String Information
		// ========================================
		// Strings can be declared like variables in Java as there is a specially memory management tool that
		// aids the application in understanding how to craft a list of characters.
		// 
		// ========================================
		// Strings also do not have a default value, their default declared value is a "null" reference.
		// null references have more importance when we start dealing with writing and using classes.
		// 
		// ========================================
		// There is also some special considerations when using Strings in conditional statements
		// that we will look at when we begin to use conditions, in this case we will refer to the
		// "String pool".
		
		// Final words
		// ========================================
		// When naming a variable it is better to infer it's purpose through the importance of its name,
		// this can help imply what is being saved/handled in a method.
		// Caution should be considered however, as variables cannot start with a number and certain keywords
		// have special meaning in Java and therefore cannot be used as a variable name.
		//
		// ========================================
		// Industry standards for coding conventions can help standardise certain practices and help aid team
		// programming efforts through expected practices.
		// for example, when writing a variable name we might consider using camelCase, rather than PascalCase.
		// Structurally this would mean setting the first word of the variable to lowercase, with every other 
		// conjoined word after starting with a Capital.
		
	}
	
	// Below are methods to test default values	
	protected static byte defaultByte() {
		return myByte;
	}	
	protected static short defaultShort() {
		return myShort;
	}	
	protected static int defaultInteger() {
		return myInt;
	}	
	protected static long defaultLong() {
		return myLong;
	}	
	protected static float defaultFloat() {
		return myFloat;
	}	
	private static double defaultDouble() {
		return myDouble;
	}
	
	// below is an example of casting
	protected static double castToDouble_directCast(float floatVal) {
		// because a float has a memory range of 32-bits
		// and the value of a double is 64-bits, a float can be automatically cast to a double
		// by using the brackets with the data type desire to transform our value in front of the value
		// or variable, we change the type of data from a float to a double.
		return (double)floatVal;
	}

	protected static double castToDouble_Assignment(float floatVal) {
		// Values that are of a different type can also be stored in an 
		// initialisation of a higher data type, e.g float -> double.
		double doubleVal = floatVal;
		return doubleVal;
	}
	
	protected static float castToFloat_Assignment(double doubleVal) {
		// You can also cast down to a smaller data type.
		// in these cases you will find that you might encounter errors or truncation however.
		// this is because certain stored values of a larged memory range cannot fit into a memory range that is smaller.
		// we know that floats are 32-bit in size and the maximum value of a double can be 64-bits in size.
		// this will lead to an issue if we took the highest numeric value of a double and attempted
		// to force it into a float.
		// ========================================
		// Such an action can lead to data loss and thus should be avoided!
		// ~; Also, remember that floating point values such as `10.0` are understood to be a double type
		//	  This means that if you write a floating point value for a float variable, to reinforce the
		//	  the value with an 'f' character to inform Java you mean
		//	  a float `10.0f`
		//	  rather than 
		//	  a double `10.0`
		return (float)doubleVal;
	}

	// Arrays will be covered in a separate class for clarity purposes
}

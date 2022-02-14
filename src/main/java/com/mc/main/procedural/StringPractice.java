package com.mc.main.procedural;

public class StringPractice {

	private static String message;
	private static char letter;
	
	/** We don't want to create an instance of this class */
	private StringPractice() { super();	}
	
	public static void start() {
		// As covered by variables and arrays, there is a distinction between
		// primitive types and complex/wrapper classes.
		//
		// Unlike the usual boolean, int, float, double, char and other primitives
		// there are some data types that are considered more complex.
		//stringComparision();
		stringMethods();
	}
	
	protected static void stringComparision() {
		// String Pool
		// ========================================
		// This section covers some details in the WrapperPractice section
		// ========================================
		// Whilst Strings might be used in java much like a primitive
		// however Strings are considered objects in java, they are in fact classes
		// rather than primitive data type - this means they have access to methods
		// as well as the option to be initialised using the new keyword.
		// 
		// This presents a issue as because java handles Strings uniquely
		// treating values of a String type as characters surrounded by double quotations.
		// 
		// When we use the double quotations we can successfully initialise a variable:
		String msg = "Hello World";
		
		// However, because a String is an object, defined as a java class, we can use the
		// 'new' keyword to create an object representation of the value.
		String msgObject = new String("Hello World");
		
		// Okay, so we have two ways of creating a String value, both are valid and both have
		// slight variations in a java application.
		//
		// So why then, might we have an issue with using Strings in java?
		// Well programming errors are traditionally associated with human error more than often.
		// Java utilises memory management on the programmers behalf to improve efficiency
		// and in certain cases avoid unnecessary memory allocation; with Strings
		// Java has a special heap designated for storing String values specifically
		// initialised with the quotation marks.
		//
		// This means that the difference between `new String("Cat")` and "Cat" are actually
		// meaningful, but why?!
		//
		// Well all objects in Java are created with unique memory allocation - making each object
		// unique, the "String Pool" memory heap is however, a collection of string objects without
		// duplication. So when I create two variables with quotation Strings, Java doesn't
		// create unique memory allocations for duplicate Strings.
		// EG:
		// String x = "cat";
		// String y = "cat";
		// x and y both need a new String("Cat"); however the String pool only makes 1 object, not two
		// both x and y share a reference to this value, stored in the String pool.
		// HOWEVER
		// EG:
		String x = "cat";
		String y = new String("cat");
		// do not share the value cat stored from the String pool. In fact
		// the String pool creates the "cat" within the pool for 'x', but creates
		// an entirely new object for 'y'.
		//
		// Well that doesn't clear it up much hu?
		// Well consider our comparisons with the 'if' statement/keyword
		
		// When we compare the objects using '==', we typically would expect our variables
		// to be checked right?
		// Each variable value would be extracted and compared - well this is true for primitive
		// data types.
		// However, the string pool complicates the narrative, this is because '==' actually
		// checks the reference of a variable not the "contents" of the value.
		//
		// This means that if we try to compare 'x' to 'y', it'll produce "false"
		// as `x = "cat"` is stored as a instance in the string pool
		// and `y = new String("cat")` is stored elsewhere and is a different object.
		if(x == y) {
			System.out.println("true: The reference x, matches y!");
		} else {
			System.out.println("false: The reference x does not match y!");
		}
		
		// This is why it is best practice to avoid using '==' for comparisons between
		// class objects, particularly Strings given the efficiency of the String pool
		// around memory storage.
		//
		// We should instead use a method that comes with the String data type:
		// '.equals(object obj);'
		// It'll return either true or false based on the stored value in the
		// complex data type!
		// This makes it more reliable for comparisons and accuracy, whilst gaining the benefit
		// of the String pool and quotation mark based Strings.
		if(x.equals(y)) {
			System.out.println("true: the VALUE inside x, matches the VALUE inside y");
		} else {
			System.out.println("false: the VALUE inside x, does not match the VALUE inside y");
		}
	}
	
	protected static void stringMethods() {
		// In this section we will look at some of the methods
		// provided by the String method. These methods
		// are useful to control value data as well as what we can do with
		// text based data!
		String result = "";
		message = "Hello World!";
		
		System.out.println(message);
		
		// Covered in Operators:
		// Concatenation
		// ========================================
		// Java provides the use of operators to join values or other Strings into the
		// target String.
		
		result = "Hello" + " " + "World";
		
		result = result.equals(message) ? 
				"The contents of result is the same as message" :
				"The contents of result is NOT the same as message";
		
		System.out.println(result);
		
		// CharAt allows us to treat a String like a Char array.
		// providing an index value will extract that letter as
		// a char/character value.
		letter = message.charAt(2);
		
		// String.format(String str, Object... obj)
		// ========================================
		// Allows us to format a String with symbols that allow us to 
		// inject values directly into a singular String, rather than use concatenation,
		// the method returns the completed String with injected values.
		//
		// C++ programmers might compare this to the printf() function.
		message = String.format("charAt index 2, pos 3: '%s'", letter);
		System.out.println(letter);
		// String.format() is a static method, we'll look at the difference between
		// static and non-static methods in OOP
		//
		// ~To simplify, you don't need a declared/initialised class variable
		// to access methods.
		
		// Injecting certain types of objects work based on a format specifier.
		// in the above example we've used '%s', which represents the first listed object
		// and inject it as a String, however using the table below, we can see
		// that '%c' might be more appropriate as the first data type is technically a character.
		// and therefore the first instance of a character.
		
		// The following is extracted from: https://www.javatpoint.com/java-string-format
		// ========================================
		// Format Specifier	|	Data Type	|	Output
		// ========================================
		// %a |	floating point (except BigDecimal)	|	Returns Hex output of floating point number.
		// %b |	Any type							| "true" if non-null, "false" if null
		// %c |	character							| Unicode character
		// %d |	integer								| (incl. byte, short, int, long, bigint)	Decimal Integer
		// %e |	floating point						| decimal number in scientific notation
		// %f |	floating point						| decimal number
		// %g |	floating point						| decimal number, possibly in scientific notation depending on the precision and value.
		// %h |	any type							| Hex String of value from hashCode() method.
		// %n |	none								| Platform-specific line separator.
		// %o |	integer (incl. byte, short, int, long, bigint)	|	Octal number
		// %s |	any type							| String value
		// %t |	Date/Time (incl. long, Calendar, Date and TemporalAccessor) | %t is the prefix for Date/Time conversions. More formatting flags are needed after this. See Date/Time conversion below.
		// %x |	integer (incl. byte, short, int, long, bigint)	|	Hex string.
		
		resetMessage();
		
		// .concat()
		// ========================================
		// concat is the method provided version of concatenation,
		// it'll return the value as a product of the method invocation
		// so don't forget to save it!
		//
		// Choices with concatenation of Operator approach vs method invocation
		// come with security and memory usage considerations for scaling applications
		// 
		message = message.concat(" and universe!");
		
		System.out.println(message);
		
		resetMessage();
		
		// .endsWith();
		// ========================================
		// returns a boolean to determine if a String ends with a certain 
		// String structure
		System.out.println(message.endsWith("World!") ?
				"true: ends with 'World!'" :
				"false: does not end with 'World!'");
		
		// .replace();
		// ========================================
		// returns a new String where the target sequence
		// is replaced with the provided character sequence
		message = message.replace("Hello", "Welcome to our");

		System.out.println(message);
		resetMessage();

		// .substring();
		// ========================================
		// returns a String from within the String, based on a start and end index value.
		message = message.substring(6, message.length());
		// .length() - similar to .size of primitive arrays, returns number of characters
		// in string as int

		System.out.println(message);
		resetMessage();
	}
	
	protected static void resetMessage() {
		// reset value
		message = "Hello World!";
	}

}

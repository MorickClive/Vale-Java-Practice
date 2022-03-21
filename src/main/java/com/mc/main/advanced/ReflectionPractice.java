package com.mc.main.advanced;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mc.main.advanced.reflect.PrivateCalculator;
import com.mc.main.util.Practice;

public class ReflectionPractice extends Practice {

	/** We don't want to create an instance of this class */
	private ReflectionPractice() {
		super();
	}

	public static void start() {
		printHeader("Reflection");
		
		// Reflection allows us to capture the definition of our class and execute code
		// through internal inspection.
		//
		// Whilst it might be tempting to use reflection to execute code that should not be accessed
		// this would violate good coding practices and would be difficult to maintain.
		// 
		// To some extents, we should never need to use reflection to use code we've written
		// as that code adheres to strict structural design that ideally shouldn't be
		// circumvented.
		
		// As an example, we might use reflection to call behaviour specific to a class
		// that has private implementation for testing purposes!
		//
		// In cases where we cannot test code, we can use reflection to introspectively
		// expose code to our runtime that would otherwise be private.
		//
		// We'd avoid this practice for the implementation of code systems to adhere to
		// best coding practice, respect of encapsulation as well as security; but in testing
		// the idea is to ensure that code works as expected - this is where reflection shines!
		
		
		// Let's observe how to access private class members such as Attributes and Methods!
		// Review the PrivateCalculator class before proceeding!
		try {
			printStaticAttribute();
			printStaticMethod();
			privateClassMethod();
		} catch (NoSuchFieldException | SecurityException |
				IllegalArgumentException | IllegalAccessException | 
				NoSuchMethodException | InstantiationException | 
				InvocationTargetException e) {
			e.printStackTrace();
		}
		// Additionally issues to consider:
		// Calling classes and their member fields/methods can be process intensive
		// and implementation is separate to structural design; meaning reflection might
		// not be aware of the changes to the invoked or changed code.
		//
		// Any errors that caused might only be caused because reflection attempts to access it!
		// this means that refactored code may work fine, but reflection did not refactor inline with
		// changes. This can produce errors during runtime, rather than compile time - as compiling
		// cannot infer functionality that reflection invokes and whether that should be correct!
	}

	private static void printStaticAttribute() throws NoSuchFieldException, SecurityException, 
	IllegalArgumentException, IllegalAccessException {
		// In order to access a "Field" or "Method", we need to use the "java.lang.reflect" library
		// of classes to utilise the respective java reflection API to gain access to classes
		// that allow us to represent and store this class member;
		Field myAttribute;
		int result;
		
		// To extract a Field or methods, we can request it through the
		// class attribute of any class object; using the respective "getX" method
		// to retrieve the field we want.
		myAttribute = PrivateCalculator.class.getDeclaredField("myValue");
		myAttribute.setAccessible(true);
		// because the field is private static final, particularly "private", we can use
		// .setAccessible(true) to overwrite this behaviour.
		//
		// WARNING: if you set accessibility, ensure that you only change it for the time you need to
		// leaving this state post execution could introduce security flaws or vulnerabilities
		// not intended for your reflection instance.
		// typically this wouldn't be an issue, our instances are moderated separate from reflection
		// and reflection works as an effective copy; however you are responsible for the security of
		// this functionality.
		
		// We can now retrieve the field by passing itself into the respective type "getter"
		// this will return the expected value assuming that the value type is respected.
		result = myAttribute.getInt(myAttribute);
	
		System.out.println("PrivateCalculator.myValue = " + result);
		
		// We have no more use for the reflected instances, preserve intended accessibility.
		myAttribute.setAccessible(false);
	}

	private static void printStaticMethod() throws NoSuchMethodException, SecurityException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		Method add;
		String result;
		
		// We use a string to provide the method name, because there are no parameters, we are not
		// required to mention them.
		add = PrivateCalculator.class.getDeclaredMethod("message");
		add.setAccessible(true);
		
		// For methods we use "invoke", much like the term we've been accustom to using throughout
		// this refresher. We need to provide a class reference as part of the invocation process.
		// Java can then create a "reflected copy" of the object to use.
		result = (String) add.invoke(PrivateCalculator.class);
	
		System.out.println("PrivateCalculator.message() = \"" + result +"\"");
		
		// We have no more use for the reflected instances, preserve intended accessibility.
		add.setAccessible(false);
	}

	private static void privateClassMethod() throws NoSuchMethodException, SecurityException, 
	InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		
		// So far we've only been accessing the static context of a class
		// however difficulties arise when you attempt to use reflection on a class
		// that requires an instance.
		
		// In order to achieve this we will need to create an instance first BEFORE reflection can take
		// place.
		
		// let's take the situation that we have a private class, it was never intended
		// to be created as an instance, we could technically by pass this using reflection
		// to create a "reflected instance" of this class; it has very little value
		// as the purpose of a class with a private constructor is arguably to be unavailable to
		// instancing.
		
		// Here we'll save our class constructor, instance and method, as well as the final result
		// of the non-static method call (some value of type int).
		Constructor<PrivateCalculator> myClass;
		PrivateCalculator myInstance;
		Method add;
		int result;
	
		// first we need to store our defined constructor and method
		myClass = PrivateCalculator.class.getDeclaredConstructor();
		// Notice that methods with parameters should provide the type of parameters respectively
		// this means we can also reflect overloads of a method too!
		add = PrivateCalculator.class.getDeclaredMethod("add", int.class, int.class);
	
		// Set both to be accessible
		myClass.setAccessible(true);
		add.setAccessible(true);
		
		// Here we use our reflection to create an instance, much like the "method.invoke()" approach
		// storing the instance of a class that should typically not
		// provide an instance!
		myInstance = (PrivateCalculator) myClass.newInstance();
		// Because our method had parameters, (int, int) - we use the parameters post-class reference
		// to provide these values as part of the reflection call.
		result = (int) add.invoke(myInstance, 1, 2);
	
		System.out.println("PrivateCalculator.add(1,2) = " + result);

		// We have no more use for the reflected instances, preserve intended accessibility.
		myClass.setAccessible(false);
		add.setAccessible(false);
	}

}

package com.mc.main.advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mc.main.util.Practice;

public class ExceptionPractice extends Practice {
	
	/** We don't want to create an instance of this class */
	private ExceptionPractice() { super();	}
	
	public static void start() {
		printHeader("Exceptions");
		// Up to this point, we've looked at variables, arrays, loops, conditionals
		// and primarily a considerable amount of basic java interaction
		// 
		// We can see with conditionals that sometimes the resulting code
		// may change based on circumstances that aren't immediately obvious.
		// 
		// In these circumstances variables might not even get a value to work with!
		// This wouldn't bode well with java and in fact might even have been something
		// you've encountered.
		//
		// When this happens, or in any scenario where something unexpected happens
		// you may get either an error or an exception!
		// Generally speaking, there's not much we can do about errors - they will
		// always crash your application. But when we get an exception we can actually
		// anticipate this unusual state of code.
		//
		// Java provides the 'try', 'catch' and 'finally' keywords to handle exceptions.
		// When your application encounters a exception, the application will stop and provide
		// useful information that implies the reason for failure.
		// When we expect code to cause an exception, we can wrap a try block around it
		// using the scope to encapsulate code with potential to fail.
		//
		// Additionally we can inform java that certain methods we create can throw exceptions
		// with the 'throws' keyword or even use certain circumstances to explicitly
		// throw an exception by using the 'throw' keyword.
		tryCatch();
	}
	
	// Keywords: try, catch, finally
	// ================================================
	protected static void tryCatch() {
		// try-catch
		// ================================================
		// In order to demonstrate an exception, it will help us
		// to create an exception, in this case we will attempt
		// to use a complex variable without a value to invoke
		// the standard NullPointerException; an exception where
		// a variable doesn't contain a default or specific value.
		String message = null;
		
		// try blocks include their own scope and must be followed with a
		// 'catch' block to handle the caught exception. If no exception is caught
		// the catch block will be ignored.
		try {
			System.out.println(message);
		} catch(Exception e) {
			// If an exception is caught; just like an unhandled exception.
			// We can tell java we want the message that typically
			// appears in the console to aid debugging.
			// we can use a method from the exception class to print out
			// the standard stack trace message ourselves.
			System.out.println(e);
			// Alternatively we could use this:
			// e.printStackTrace();
			// however we will avoid this because of parallel execution.
			// and we do not have a logger library.
		}
		
		// try-catch-finally
		// ================================================
		// In some cases we might use important variables in our java applications,
		// for example, some variables can represent active connections with
		// important data inside. An open connection can actually cause issues
		// and should the java app "crash", we could be left with an active
		// connection that cannot be closed.
		//
		// With the finally block, we can attach a finally block to a try-catch block.
		// A finally block always runs after a try block - irrespective of whether
		// an exception is thrown or not, perfect for our active connection.
		Connection activeConnection = null;
		
		try {
			// Activate a connection to a server - null for demo
			activeConnection = DriverManager.getConnection("");
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Always run this");
			// in this case, the active connection has a close method that can
			// also throw an exception. however we'd need to also check the connection
			// is not empty/"null" - otherwise that'll cause a NullPointerException as well.
			// 
			// But the main objective is to make sure that the active connection
			// is closed - and therefore, cannot be exploited or cause server
			// lockup through network priority waiting for a response.
			try {
				if (activeConnection != null) { 
						activeConnection.close(); 
					}
			} catch(SQLException e) {
				// .close() has the potential to throw an SQL Exception
				// thus we can catch that specific exception type
				// if it throws more than one type of Exception, it maybe
				// more appropriate to use a more generic Exception.
				System.out.println(e);
			}
		}
		
		// try with resources
		// ================================================
		// As we saw before, using a complex variable with responsibilities
		// to outside resources like servers and their connections to our application
		// requires our attention should something go wrong.
		//
		// servers can stop working - due to factors outside of software/code related
		// problems, this can cause issues our application and it can be tricky
		// to handle nested try-catch blocks to handle these issues as well as messy.
		//
		// we can use parenthesis '()' to initialise variables with important values
		// and the try-catch block will consider this variable as a resource.
		// We typically refer to this as "try with resources"
		try (Connection serverConnection = DriverManager.getConnection("") ) {
			// If the resource throws an exception, not only
			// can we catch it like a traditional try-catch block
			// but if the resource we are using has an AutoClosable interface
			// java will attempt to close this resource if an exception has been
			// thrown.
			serverConnection.beginRequest();
			
			// If the connection variable is personally crafted without
			// an auto-closable interface, you should consider
			// adding the close method in the catch block.
			// alternatively if the resource is no longer needed
			// after this try-catch block, you could add the close method invocation
			// in a finally block
		}catch(Exception e) {
			System.out.println(e);
		}
		
		// try-finally
		// ================================================
		// in terms of combinations, we can use a try-finally block
		// assuming that we simple want to catch an exception
		//
		// HOWEVER: this isn't ideal practice as exceptions help us determine
		// what kind of problem is causing functionality loss in our application
		// and help us resolve problems during testing.
		try {
			// Activate a connection to a server - null for demo
			System.out.println(message);
		} finally {
			message = "MISSING!";
		}
		
		// throws example
		try {
			genericException(null);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// throw-throws example
		try {
		explicitNumericException(0);
		}catch (Exception e) {
			System.out.println(e);
		}

	}
	
	// Keyword: throws
	// ================================================
	// Code we write might cause a problem purely because an exception
	// is possible to throw, however as developers we are responsible for our
	// own code and the problems it can cause to other users that might
	// wish to utilise it.
	//
	// If we have code that can throw an exception you might find
	// the compiler will warn you there is an unhandled exception
	// but if we amend the 'throws' keyword with an Exception type
	// we can pass any exceptions that happen in this method to the code that
	// will invoke this method
	protected static void genericException(String message) throws Exception {
		// After the throws keyword is used, you can use commas to add additional
		// types of Exceptions to warn developers of the exceptions this method might
		// potentially encounter.
		System.out.println(message.contains("2"));
	}
	
	// Keyword: throw
	// ================================================
	// In cases where we want to throw an exception where a developer might
	// use our method incorrectly, we can use the 'throw' keyword in
	// scope, one of the benefits of this is that we can also write a string
	// as part of the exception to explain the failure reason.
	//
	// In addition to the throw keyword, we can pass this possible exception to
	// be handled by the developer invoking them, so they can provide a try-catch block
	// to handle the exception they might cause using our code.
	protected static float explicitNumericException(float val) throws ArithmeticException {
		if(val > 0) {
			return val;
		} else {
			throw new ArithmeticException("no positive value found!");
		}
	}

}

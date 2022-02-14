package com.mc.main.procedural;


public class FlowControlPractice {
	
	// !!! READ THIS FIRST !!!
	public static void flowOfControl() {
		// Java code always runs within methods within a class
		// as you can see above we are in `public static void flowOfControl() { }`
		// 
		// but what does that mean?
		// well all methods have the following structure:
		// 'accessor - "public"',
		// 'static context - "static"', 
		// 'return type - "void"', 
		// 'name(of method) - "flowOfControl"', 
		// 'parameter list - "()"', 
		// 'scope - "{}"'
		// We don't need to understand accessors, static or the parameter list for now
		// but something that is very important is the "scope"
		//
		// Method
		// ========================================
		// Methods generally need at minimum an
		// Accessor, return type, name, parameter list and scope.
		// for example:
		// 		public void myMethod() {}
		//
		// Scope
		// ========================================
		// Whilst we can assume everything else is needed, the scope provides the start
		// and end of instructions!
		// All java applications run from the top line of a method scope to the end of the scope
		// - start - "{"
		// - end - "}"
		// You may also hear the scope of something being referred to as a "block"
		// this is a reference to a "block of instructions".
		// a scope might encapsulate multiple lines, everything inside will be instructions
		// informing java to perform an action.
		//
		// As you can see with "flowOfControl()", the scope expands to multiple lines
		// it is very important that scope begins but also ends!
		// After all - how would java know when to stop reading instructions!
		//
		// Classes
		// ========================================
		// Whilst we won't be going into classes in depth yet, it's an easy jump to show
		// that all "method"s are contained in the scope of a class.
		// ~ Think of class scopes like a dictionary, it contains a definition
		// of things - but they do not run from top to bottom - you can access any
		// entry you can see.
		//
		// If a method exists in a class - the class will inform java it can be run at
		// any requested moment!
		// All we need to do is know how to call a method from a class! :)
		
		// Please move to the:
		// `public static void start()` method.
	}
	
	public static void start() {
		// We've looked into Methods and Scopes, hopefully this isn't looking
		// as daunting as you might expect.
		
		// Below are methods that are inside this method "start()"
		// When a method is referred to in a method scope it is called
		// an invocation; as in we "invoke", call or run that method.
		//
		// To invoke a method you provide the name of the method as well
		// as its parameter list.
		//
		// Any instruction in java should end with a semicolon/";"
		// this lets java know that it should move onto the next line/instruction
		//
		// In this case a method can only be invoked when within a class
		// - this is not the rule and there are ways of calling methods from other
		// classes, but we'll keep it simple for the time being.
		//
		// let's follow the code!
		// when we invoke a method, we run all instructions in its scope and then return
		// back here on the next line!
		// 
		// notice that we've just come from flowOfControl!
		// so we have already done that line in "start()"
		// let us move onto "comments()"!
		
		// Exploration of java code
		flowOfControl();
		
		// exploration of comments
		comments();
		
		// Please move onto VariablesPractice.java
		// particularly at the `start()` method
	}
	
	protected static void comments() {
		// the '//' symbol combination can be used to inform java 
		// to ignore instruction on the line, thus nothing is happening currently.
		// It is particularly useful to write comments on code.
		//
		// !! HOWEVER !! writing comments are considered bad practice in the software industry,
		// this is because methods, variables and code in general should express
		// its purpose with clarity from naming conventions and flow.
		
		/*
		  Multi-lined comments such as this also allow a block of code to be ignored.
		  
		  Again, coding should primarily express itself clearly.
		  Writing comments means that there is a level of complexity 
		  in the coding that should be simplified.
		 */
		
		// javaDocs
		// ========================================
		// See the javaDocs() method below, hovering over it should give you
		// an information box, this form of comment is integrated into supported
		// editors.
		javaDocs();
		// In order to see how to implement this, review the line below
		// that begins with `protected static void javaDocs() {	}`	
	}
	
	/**
	 * <p>
	 * Multi-lined comments with two astrix are uniquely considered java-docs.
	 * The java-docs tool will help explain methods or classes, particularly
	 * if an IDE supports this feature.
	 * </br>
	 * </br>
	 * It's also a very good way to explain functionality through interfaces as part of
	 * a dependency, giving developers insight into code and its functionality! 
	 * </br>
	 * </br>
	 * To find out more about writing java-docs, see the following link:
	 * </br>
	 * <a href="https://www.oracle.com/uk/technical-resources/articles/java/javadoc-tool.html">java-doc</a>
	 * </p>
	 * @author MorickClive
	 */
	protected static void javaDocs() {	}
	
	
	/** Ignore this for now:
	 *  We don't want to create an instance of this class */
	private FlowControlPractice() { super();	}

}

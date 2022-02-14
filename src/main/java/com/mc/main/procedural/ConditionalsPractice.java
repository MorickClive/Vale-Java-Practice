package com.mc.main.procedural;

public class ConditionalsPractice {

	// When an application
	public static void start() {
		// Exploration of if, else, else-if and comparators
		ifStatements();
		// Exploration of multiple conditions and code execution
		switchCase();
		// Exploration of comparator control
		logicalOperators();
		
		// Next: IterationPractice.java
	}

	// if statements
	protected static void ifStatements() {

		// The keyword 'if' is used in conjunction with brackets
		// the brackets contain expression that resolve to either
		// 'true' or 'false'
		// if the condition is considered true, the scope that follows the if
		// keyword will execute.
		// If the condition is false the application will continue to execute after
		// the provided scope, ignoring the instructions within the scope.

		// below is an example of a basic successful if statement
		if (true) {
			System.out.println("Print this out");
		}

		// We could provide a false result in the brackets, but that code would never
		// execute.
		// however conditions may work with the results of a variable, the state of a
		// variable may
		// not always be the same when the if statement executes.
		boolean flag = false;

		flag = true;

		// Booleans can be used as a raw value to provide whether a condition is
		// true or false
		if (flag) {
			System.out.println("Print this out due to flag!");
		}

		// Notice that flag was original 'false', meaning we'd ignore the
		// instructions, however the code between initialisation changes flag
		// to a new value that means we can execute the if statement's scope.

		// Currently you might be thinking - there's not really a condition for this
		// code to run
		// it either does or does not.
		// this is because to fully utilise conditionals within the if bracket is to
		// use comparison symbols to help evaluate whether a situation is true or false.

		// The following symbols and their meaning are provided in the method
		// referenced here:
		comparators();
		
		// if statements can perform actions on true statements, but we can also
		// use a keyword to run a separate block of code should the if statement evaluate
		// by using the 'else' keyword in conjunction with a if statement block
		// we can provide an alternative set of instructions to execute
		// a scope block after the 'else' keyword.
		flag = false;
		
		if(flag) {
			System.out.println("The flag is equal to true");
		}else {
			System.out.println("The flag is equal to false");
		}
		
		// Additionally, if there's an additional condition that would be true
		// but not part of the original if statement we can use the 'else if'
		// condition keywords in combination
		// however, we must remember that the else if condition needs brackets
		float value = 12;
		
		if (value < 10) {
			System.out.println("value is less than 10");
		} else if(value > 10) {
			System.out.println("value is greater than 10");			
		} else {
			System.out.println("value is 10");		
		}
		
		// We can chain additional 'else if's, however we might be better crafting
		// a switch-case statement
	}
	
	// Grouped practice for comparators as part of ifStatements
	protected static void comparators() {
		
		boolean flag = true;
		
		// == - equals to; notice that double equals is a comparison, singular is an
		// assignment
		if (flag == true) {
			System.out.println("Flag is true");
		}

		// > - greater than
		// < - less than
		// the number that is on the left will be checked
		// with the value on the right
		if (5 > 2) {
			System.out.println("5 is greater than 2");
		}

		if (5 < 2) {
			System.out.println("5 is less than 2"); // will not run, causing a compile warning
		}
		
		// <= - less than or equals to
		// >= - greater than or equals to
		// if you experiment with the above statements you may notice
		// or consider than "5 < 5" or "5 > 5" will both evaluate false
		// this is because there's a unique "equals to" comparison symbols
		if (5 >= 5 ) {
			System.out.println("5 is equal to 5");
		}
		
		if (5 <= 5 ) {
			System.out.println("5 is equal to 5");
		}
		
		// compar Operator: !=
		// ========================================
		// In some cases, we want to check anything but a certain case
		// in this regard we can use the not equals comparator
		if(2 != 5) {
			System.out.println("2 is not 5"); // this will run
		}
		
		// Logic Operator: ! - NOT
		// ========================================
		// The 'NOT' operator; typically this would be covered in the OperatorsPractice
		// however there is a operator that we can apply to booleans that inverts their meaning.
		// because I'm covering conditionals, its application has a more meaningful demonstration.
		
		// if something uses the '!' symbol, the boolean value will flip to true
		boolean testFlag = false;
		
		if(!testFlag) {
			System.out.println("The value of testFlag is not true!");
		}
		
		// As you can see, this doesn't mean much when you read it, as such you should
		// consider only using the NOT operator when it read clearly, cases such as the one
		// below would potentially be an appropriate use of the "NOT" operator.
		if( !performAction() ) {
			System.out.println("An action hasn't been performed!");
		}
		
		// You can also apply this with a level of precedence by encapsulating an expression
		// within parenthesis
		if ( !(5 > 2) ) {
			// Will not run, because the condition is true, but evaluated
			// as false.
			System.out.println("");
		}
		
		// Keyword: instanceof
		// ========================================
		// For this section, you might want to look up Object-Oriented Programming section
		// for classes
		//
		// Sometimes we want to see if the data value matches the data type, this typically
		// is associated more with inheritance and confirming one data type is in fact
		// the data type you are storing. To appreciate this, check out Abstraction and Polymorphism.
		//
		String message = "sample";
		
		if(message instanceof String) {
			System.out.println("The message variable is of [String.class] Type");
		} else {
			System.out.println("The message variable is Not of [String.class] Type");
		}
		
		// Ternary Bitwise:  '? : '
		// ========================================
		// in some cases we might want to set a variable based on a conditional
		// circumstances, we could write it using the if-else keywords.
		// Alternatively we can use a bitwise operation which handles logic on a binary level
		
		String result = "The message variable is ";
		
		// As we can see below, we can use the structure of:
		// (condition) ? (if true, return this) : (if false, return this);
		// this is known as a ternary bitwise operation.
		result += message instanceof String ?  "of [String.class] Type" : "of [String.class] Type" ;
	}
	
	// Example method for comparators, relational operators
	private static boolean performAction() { 
			try {
			return true; 
			} catch(Exception e) {
				return false;
			}
		}

	// switch case
	protected static void switchCase() {
		// As described at the end of ifStatements
		// sometimes a variable might be any range of numeric or other
		// value that can vary distinctly
		
		// In this scenario, we can use a switch-case
		// in order to utilise this keyword combination we need a variable
		// to handle as part of the switch keyword:
		int value = 3;
		
		// The switch keyword uses a value for comparison, we can pass
		// a variable to represent the result we are looking for.
		// We can then set up the scope a switch keyword requires cases.
		// cases are usually just the 'case' keyword, a value and a colon.
		// a switch can have multiple cases
		switch(value) {
			case 1:
			case 2:
			case 3:
				System.out.println("Value equals 3");
		}
		
		// There is however a condition to the usage of switch cases
		// when a switch case finds the correct case, it'll perform instructions after
		// the colon.
		// consider if value was instead 2 or 1
		// the end result would still print out the String "Value equals 3"
		//
		// We can use control keywords to isolate case functionality
		// particularly the 'break' keyword will allow us to jump out of the scope
		// of the switch case.
		
		switch(value) {
			case 1:
				System.out.println("Value equals 1");
				break;
			case 2:
				System.out.println("Value equals 2");
				break;
			case 3:
				System.out.println("Value equals 3");
				break;	
		}
		
		// Now the value will determine which statement will run and then
		// break out of the switch-case statement.
		
		// However sometimes not all cases will match the value provided to the switch
		// in these circumstances, we can use the 'default' case:
		switch(value) {
			case 1:
				System.out.println("Value equals 1");
				break;
			case 2:
				System.out.println("Value equals 2");
				break;
			case 3:
				System.out.println("Value equals 3");
				break;
				
			default:
				System.out.println("Value is not a recognised value between 1-3");
				break;
		}
		
		// Just be aware that the default case can be applied in any order
		// but it is usually best practice to include it at the bottom of the
		// switch-case
		//
		// Just remember to keep it isolated with a 'break' keyword to keep
		// associated instructions isolated.
	}

	// logical control
	protected static void logicalOperators() {
		// When using the 'if' statement we can apply comparators
		// but we can also check more than one expression by
		// using logical operators to break up expressions.
		
		// Some of the logical operators can be seen below:
		
		float value = 5;
		
		// AND - &&
		// when we apply a logical AND, both sides of the statement must contain
		// a truthful expression to be considered true, even if one expression is false
		if(value == 5 && value <= 10) {
			System.out.println("value is 5 AND less than or equal to 10");
		}
		// OR - ||
		// when we apply a logical OR, either side of the statement must contain
		// a truthful expression to be considered true, even if one expression is false
		if(value == 2 && value < 50) {
			System.out.println("value is 5! BUT less than 50");			
		}
		
		// NOT - !
		// a revisit from our comparator method
		if(!performAction()) {
			System.out.println("An action hasn't been performed!");
		}
	}

	/** We don't want to create an instance of this class */
	private ConditionalsPractice() { super(); }
}

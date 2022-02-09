package com.mc.main.procedural;

public class OperatorsPractice {
	
	private OperatorsPractice() { super(); }
	
	public static void start() {		
		// Operations that are associated with standard mathematical operations
		arithmeticOps();
		
		// Operations that are associated with variable control
		assignmentOps();
	}
	
	// In the below example we can observe how we can control numeric data
	// stored within a variable value, for these examples we shall go over the initial
	// mathematical operations and how they are performed.
	// ========================================
	protected static void arithmeticOps() {
		float value = 0;
		
		// Addition
		value = 1 + 2; // value = 3.0
		
		// Subtraction
		value = 3 - 2; // value = 1.0
		
		// Multiplication
		value = 3 * 12; // value = 36.0
		
		// Division
		value = 12 / 3; // value = 4.0
		
		// Modulus
		//  ~ Unlike standard operations, the modulus doesn't appear to frequently
		// It's operation is similar to division, but return the remainder of the value
		// rather than the whole floating point value.
		// this can be useful for identifying patterns in mathematical sequences
		value = 12 % 3; // value = 0
		
		// Incremental
		// ========================================
		
		// Additionally, if we want to control values within a variable we can use 
		// incremental operators to push a value towards a positive or negative value:

		value++; // the number stored in value will be incremented by +1
		value--; // the number stored in value will be incremented by -1
		
		// Prefix vs Postfix
		// ========================================
		// The order of incremental operators is important to the value that'll be used
		float result = 5;
		
		value = 2 * result++; // value is now equal to 10
		value = 2 * ++result; // value is now equal to 12
		
		// Strings and Operators
		// ========================================
		
		// When you use a String or Char to represent a number, in a numeric operation
		// the result will usually be converted into a String result
		// this will perform an action that we'll review with Strings call
		// concatenation.
		
		// value = 1 + "1"; 
		// This will cause a compilation failure and the app won't execute.
		// This is because java is attempting to store a String value into a float Variable.
		
		// Order of Execution
		// ========================================
		// Operators can be chained, as we could see with prefix vs postfix the order of
		// how we write operators is very important.
		// java will generally perform operations in the order of:
		// PEMDAS
		// However java does distinguish between Precedence and Associativity
		value = 15 + (5 * 6 - 4) * 14 % 4;
		
		// In this case we need to resolve (5 * 6 - 4)
		// We now have 15 + 26 * 14 % 4
		// 15 + 364 % 4
		// 15 + 0
		// value = 15.0f;
		System.out.println("Value: " + value);
		
	}
	
	// Assignments
	// In some respect we've already used a major assignment operator already
	// as part of initialising or providing a value to a variable
	// the equals symbol allows us to allocate a value to a variable.
	protected static void assignmentOps() {
		// Below are examples of operators that handle relative operations
		// involving variables.
		
		// =
		// when we use the '=' sign, we are assigning some value in a variable
		float value = 5.0f;
		
		value = 8.0f; // now value is equal to 8.0f, rather than 5.0f;
		
		// +=
		// This is the relative incremental operator
		value += 5.0f; // the value is now equal to 13.0f
		
		// -=
		// This is the relative decremental operator
		value -= 2.0f; // the value is now equal to 11.0f
		
		// *=
		// This is the relative operator that multiplies the existing stored value 
		// by the value provided to the operator;
		value = 12.0f;
		value *= 5.0f;  // the value is now equal to 60.0f
		
		// /=
		// This is the relative operator that divides the existing stored value 
		// by the value provided to the operator;
		value = 12.0f;
		value /= 2.0f; // the value is now equal to 6.0f
		
		// %=
		// This is the relative operator that divides the existing stored value 
		// by the value provided to the operator;
		value = 13.0f;
		value %= 2.0f; // the value is now equal to 1.0f
		}
	
	// Some methods prepared to demonstrate
	protected static float addition(float x, float y) {
		return x + y;
	}
	protected static float subtraction(float x, float y) {
		return x - y;
	}
	protected static float multiplication(float x, float y) {
		return x * y;
	}
	protected static float division(float x, float y) {
		return x / y;
	}
	protected static float modulus(float x, float y) {
		return x % y;
	}
	// incremental operations
	protected static float incrementPositive(float x) {	return ++x;	}
	protected static float incrementNegative(float x) {	return --x;	}
	
}

package com.mc.main.procedural;

public class IterationPractice {
	
	/** We don't want to create an instance of this class */
	private IterationPractice() { super(); }

	public static void start() {
		// We've looked at handling values with variables, arrays, operators and
		// conditionals.
		// With the application sequentially executing instructions and invoking methods
		// you might find the idea of writing applications that continuously read or
		// perform actions for hundreds of operations.

		// But just like variables can be reused many times after they have been
		// declared,
		// methods can be invoked more than once.

		// Sometimes a method might require to do many instructions in repetition
		// in this case it is actually good design and practice to create methods
		// that avoid writing code that is a duplicate of instructions written elsewhere

		// If you need to perform a block of instructions more than once we can use
		// loops.

		// While Loops perform blocks of instructions based around a condition
		whileLoops();

		// for loops are driven by conditions set by loop structures or setup control
		// variables
		forLoops();

		// Extras are considerations and keywords that provide additional control
		// to using loops
		extras();
		
		// Next: StringPractice.java
	}

	protected static void whileLoops() {

		// while loops use the 'while' keyword
		boolean flag = true;
		float value = 0;

		// Much like the 'if' keyword, the while keyword has an expression requirement
		// as
		// well as a scope of instructions to perform.
		// once the scope is complete, the while loop checks the condition to see if
		// the expression resolves to 'true'.
		//
		// If the condition is still true after the scope is complete, java will
		// return to the instruction at the top of the scope and rerun the code

		// once our value has reached 10, we can exit the loop by changing the flag
		// to false
		while (flag) {
			System.out.println("while loop running - " + value);
			value++;
			if (value >= 10) {
				System.out.println("While loop exit value: " + value);
				flag = false;
			}
		}

		// reset values
		flag = false;
		value = 0;

		// Do-While
		// a do while loop is slightly different, sometimes you need the instructions
		// within the while loop needs to run at least once before considering
		// whether to rerun the loop.
		//
		// In this we can use a do-while loop, this works by using the 'do' keyword
		// followed by a scope, then the scope is followed by the 'while' keyword
		// WARNING: you need to use a semicolon to close the while loop instruction
		// as seen below:
		do {
			System.out.println("while loop running - " + value);
			value++;
			if (value >= 10) {
				System.out.println("While loop exit value: " + value);
				flag = false;
			} else {
				System.out.println("flag value: " + flag);
				System.out.println("While loop value: " + value);
			}
		} while (flag);
	}

	protected static void forLoops() {
		// for loop

		// A good use of loops is to navigate through an array.
		// This is because we can use the length of the array
		// as well as pointing to each item uniquely within the array.
		float[] listArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// A for loop is constructed like a while loop
		// instead of using an expression, there are 3 sections we can write in the
		// brackets
		// these sections are split between two semicolons ';'.
		// - The first section allows us to set up variables
		// - The second section is like the conditional statement, to run instructions
		// it should resolve to 'true'
		// - The third is the section that runs at the end of the loop,
		// typically this is used as an incremental phase.
		//
		// As part of the condition, we can use the length of the array
		// and increment a variable to represent the index of the array.
		// using that variable to check whether we've reached the end of the array.
		for (int x = 0; x < listArray.length; x++) {
			System.out.println("Array[" + x + "] value: " + listArray[x]);
		}

		// for-each
		// ========================================
		// In the case above, we definitely have good control over our loop
		// however we could use an enhanced for loop, which can also be referred to as
		// a for-each loop.
		//
		// The structure of this for loop uses a colon/':' to seperate the two sections
		// of
		// the brackets. The left-hand side is space to declare a variable of the data
		// type
		// of the item inside the array you want to iterate through, the right-hand side
		// is the
		// array you are using to control the for loop.
		// The for-each then uses the array structure to loop as many times as items in
		// the list
		// the left-hand side variable will represent the value in each item in the
		// array/list.
		for (float item : listArray) {
			System.out.println("list Array item: " + item);
		}
		// A difficulty with the array above is that there's no variable tracking,
		// this presents a difficulty with controlling where to stop in the array
		// as well as any bespoke interactions for unique positions in the array index

		// None-the-less it can be a useful short-hand approach to handling a full array
		// and
		// all of its items.
	}

	protected static void extras() {
		// Sometimes you might make a logically decision in which your loop
		// never reaches a condition in which the application can exit this
		// process; this can cause problems and use a lot of processing power.

		// In cases like this, whilst developing you can use testing to expose
		// this behaviour, both manual and automated testing can expose this as an
		// issue.
		//
		// Even if you do find this to be the case, you may not be able to stop the
		// application
		// luckily Integrated Development Environments like Exclipse can terminate such
		// applications
		// through buttons on the console.
		//
		// However in the case this runs as a compile java .jar application, it may
		// not be as clear as to how to stop the application from running.
		// in this cause you can use the 'ctrl + c' keystroke to inform the console to
		// stop the application.

		// Generally we should be in control of applications we write at all times.
		// There should be no reason that the application runs out of control, as such
		// we can use if statements and other conditions to break out of the loop.
		//
		// To build upon this there are additional keywords that are useful to know.
		// the following keywords can help provide additional control within the scope
		// of the for/while loops we use.

		// break;
		// ========================================
		// break, as seen used in switch cases, allow us to
		// break out of the scope we are currently in and proceed to instructions
		// that appear after the scope we were once inside.
		// so if we had 3 more loops to go, but a conditional force us to invoke
		// the break keyword, we'd ignore the last 3 loop iterations and continue after
		// that loop scope.

		for (int x = 0; x < 10; x++) {
			System.out.println("X: " + x);
			if (x == 8) {
				break;
			}
			// we ignore any more loops after X reaches 8, despite
			// the original condition of the loop looking for x to be less
			// than 10
		}

		// continue;
		// ========================================
		// continue is a softer form of the break keyword, instead
		// of completely ignoring the rest of the instructions for the entire loop
		// it'll simply skip end the current iteration and assume the scope has been
		// completed
		// jumping to the next phase of the loop.
		for (int x = 0; x < 10; x++) {
			if (x % 2 == 0) {
				continue;
			}
			System.out.println("X: " + x);
		}
	}

	protected static float sumForLoop(float[] array) {
		float result = 0;
		
		for(int x = 0; x < array.length; x++) {
			result += array[x];
		}
		
		return result;		
	}
	
	protected static float sumForEach(float[] array) {
		float result = 0;
		
		for(float val : array ) {
			result += val;
		}
		
		return result;		
	}

	protected static float sumWhile(float[] array) {
		float result = 0;
		
		int index = 0;
		
		while(index < array.length) {
			result += array[index];
			index++;
		}
		
		return result;
	}
	
	protected static float sumDoWhile(float[] array) {
		float result = 0;
		int index = 0;
		
		do {
			result += array[index];
			index++;
		} while(index < array.length);
		
		return result;
	}
}

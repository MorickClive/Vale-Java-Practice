package com.mc.main.procedural;

/**
* Provides a series of applications as values
* each value can use a run method to execute that
* particular group of instructions.
* 
* @author MorickClive
*/
public enum Application {
	
	PROCEDURAL,
	OOP,
	ADVANCED,
	JAVA8;
	
	/**
	* Runs the active grouped applications, group is based on the
	* available enumerated values.
	* 
	* This switch case determines
	* which application you would like to run
	* grouping instruction methods to execute
	*/
	public void run() {
		switch(this) {
			case PROCEDURAL:
				VariablesPractice.start();
				MethodPractice.start();
				FlowControlPractice.start();
				ArraysPractice.start();
				OperatorsPractice.start();
				ConditionalsPractice.start();
				IterationPractice.start();
				StringPractice.start();
				break;
				
			case OOP:
				break;
				
			case ADVANCED:
				ExceptionPractice.start();
				break;
				
			case JAVA8:
				break;
				
			default:
				System.out.println("An error has occured, please seek available cases.");
				break;
		}
		
		// View Runner.java, seeing how this code works
		// Enums will be covered in OOP.
	}

}

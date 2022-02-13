package com.mc.main.procedural;

public enum Application {
	
	PROCEDURAL,
	OOP,
	ADVANCED,
	JAVA8;
	
	public void run() {
		// This switch case determines
		// which application you would like to run
		// grouping instruction methods to execute
		switch(this) {
			case PROCEDURAL:
				VariablesPractice.start();
				MethodPractice.start();
				ArraysPractice.start();
				OperatorsPractice.start();
				ConditionalsPractice.start();
				IterationPractice.start();
				
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
	}

}

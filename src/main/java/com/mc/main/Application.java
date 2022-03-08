package com.mc.main;

import com.mc.main.advanced.DesignPatternPractice;
import com.mc.main.advanced.ExceptionPractice;
import com.mc.main.advanced.ui.ScannerPractice;
import com.mc.main.oop.ClassApp;
import com.mc.main.oop.WrapperClass;
import com.mc.main.oop.principles.AbstractionPractice;
import com.mc.main.oop.principles.EncapsulationPractice;
import com.mc.main.oop.principles.InheritancePractice;
import com.mc.main.oop.principles.PolymorphismPractice;
import com.mc.main.oop.structs.EnumerationPractice;
import com.mc.main.oop.structs.GenericsPractice;
import com.mc.main.procedural.ArraysPractice;
import com.mc.main.procedural.ConditionalsPractice;
import com.mc.main.procedural.FlowControlPractice;
import com.mc.main.procedural.IterationPractice;
import com.mc.main.procedural.MethodPractice;
import com.mc.main.procedural.OperatorsPractice;
import com.mc.main.procedural.StringPractice;
import com.mc.main.procedural.VariablesPractice;

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
		
		String div = "=".repeat(40);
		
		System.out.println( this.name() + "\n" + div );
		
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
				ClassApp.start();
				WrapperClass.start();
				EncapsulationPractice.start();
				InheritancePractice.start();
				PolymorphismPractice.start();
				AbstractionPractice.start();
				break;
				
			case ADVANCED:
				ExceptionPractice.start();
				EnumerationPractice.start();
				GenericsPractice.start();
				DesignPatternPractice.start();
				ScannerPractice.start();
				break;
				
			case JAVA8:
				break;
				
			default:
				System.out.println("An error has occured, please seek available cases.");
				break;
		}
		
		System.out.println(div + String.format("\nEND of %s\n", this.name()) + div + "\n");
		
		// View Runner.java, seeing how this code works
		// Enums will be covered in OOP.
	}

}

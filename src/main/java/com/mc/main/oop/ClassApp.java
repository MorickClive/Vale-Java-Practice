package com.mc.main.oop;

import com.mc.main.oop.classres.ClassAdvancedPractice;
import com.mc.main.oop.classres.ClassPractice;

public class ClassApp {
	
	private ClassApp() {	super();	}

	public static void start() {
		ClassPractice classPractice;
		ClassAdvancedPractice AdvanceClassPractice;
		
		classPractice = new ClassPractice("my_instance_1");
		AdvanceClassPractice = new ClassAdvancedPractice("my_advanced_instance_1");

		System.out.println( classPractice.returnName() );
		System.out.println( "Advance Class Practice, IdTracker: " + AdvanceClassPractice.getIdTracker() );
		ClassAdvancedPractice.idTracker++;
		System.out.println( "Advance Class Practice, IdTracker: " + AdvanceClassPractice.getIdTracker() );
	}
	
}

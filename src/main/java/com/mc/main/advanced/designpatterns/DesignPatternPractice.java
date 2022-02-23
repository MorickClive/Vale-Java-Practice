package com.mc.main.advanced.designpatterns;

import com.mc.main.util.Practice;

public class DesignPatternPractice extends Practice {
	
	private DesignPatternPractice() { super(); }

	public static void start() {
		printHeader("DesignPatternPractice");
		
		creational();
		structural();
		behavioural();
	}
	
	public static void creational() {
		//this.singletonPattern();
		//this.builderPattern();		
	}

	public static void structural() {
		//this.decoratorPattern();
		//this.adapterPattern();
	}

	public static void behavioural() {
		//this.iteratorPattern();
		//this.observerPattern();
	}


}

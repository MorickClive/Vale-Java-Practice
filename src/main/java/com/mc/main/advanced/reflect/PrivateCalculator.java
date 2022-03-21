package com.mc.main.advanced.reflect;

public class PrivateCalculator {
	
	private static final int myValue = 6;
	
	private PrivateCalculator() {
		super();
	}
	
	private static String message() {
		return "message!";
	}
	
	private int add(int x, int y) {
		return x + y;
	}

}

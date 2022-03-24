package com.mc.main.util;

public abstract class Practice {
	
	protected Practice() { super(); }
	
	protected static void printHeader(String className) {
		System.out.format("\n%s\n%s\n%s\n", StringConst.DIV, className, StringConst.DIV);
	}

}

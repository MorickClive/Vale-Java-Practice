package com.mc.main.util;

public abstract class Practice {
	
	protected Practice() { super(); }
	
	protected static void printHeader(String className) {
		System.out.println(
			String.format(
			"%s%s%s%s%s%s", "\n", "=".repeat(40), "\n", className, "\n", "=".repeat(40))
		);
	}

}

package com.mc.main.util;

public class ApplicationTime {

	private static final long startTime = System.currentTimeMillis();

	public static void printElapsedTime() {
		long runTime = System.currentTimeMillis() - startTime;

		System.out.println("Elapsed time: " + runTime + "ms");
	}
}

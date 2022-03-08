package com.mc.main.advanced.ui.scanner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

// This abstraction allows us to create fake input and output streams
// allowing us "mock" a input stream with potentially pending entries.
public abstract class ConsoleMock {
	
	private static ByteArrayOutputStream typeOut;
	private final static InputStream systemIn = System.in;
	private final static PrintStream systemOut = System.out;
	private final static String lineSep = System.getProperty("line.separator");
	
	public static void mockSetup() {
		//typeOut = new ByteArrayOutputStream();
		//System.setOut(new PrintStream(typeOut));

	    System.out.println("Mocking userinput!");
	}
	
	public static void mockCleanUp() {
		 System.setIn(systemIn);
	     System.setOut(systemOut);
	     System.out.println("Mock input streams reverted!");
	}
	
	public static void setMockInputStreamMessage(String str) {
		str = str.replace("\n", lineSep);
		str = str.trim();
		System.setIn(new ByteArrayInputStream(str.getBytes()));
	}
}

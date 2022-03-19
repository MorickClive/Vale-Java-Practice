package com.mc.main.advanced.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.mc.main.util.Practice;

public class IOPractice extends Practice {

	private static String testFolder;
	private static File file;
	private static final String message = "Hello World!";
	private static final String filePath = "\\src\\main\\resources\\";
	private static final String fileName = "testFile.txt";
	
	private IOPractice() { super(); }

	public static void start() {
		printHeader("Input/Output");

		// In order to create and read folders, we'll need a path in the form of a
		// string
		// this will allow us to target a location in which to read and write to.
		testFolder = new File("").getAbsolutePath() + filePath;
		file = new File(testFolder + fileName);

		// Let's explore how to write and read a respective file
		// we'll pass our message and file to a class we created called FileHandler.
		FileHandler.writeToNewFile(file, message);
		
		// There are different classes provided that can aid in the reading of the contents of a file
		// the follow methods are drive by their respective classes.
		System.out.println( FileHandler.readFile(file, Scanner.class) );
		System.out.println( FileHandler.readFile(file, BufferedReader.class) );
		System.out.println( FileHandler.readFile(file, FileReader.class) );
		
		// Remove file for rerun purposes
		FileHandler.deleteTargetFile(file);
	}
	

}

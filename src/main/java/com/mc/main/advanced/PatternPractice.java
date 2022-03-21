package com.mc.main.advanced;

import java.io.File;
import java.io.FileReader;

import com.mc.main.advanced.io.FileHandler;
import com.mc.main.util.Practice;

public class PatternPractice extends Practice {
	/** We don't want to create an instance of this class */
	private PatternPractice() {
		super();
	}

	public static void start() {
		printHeader("Regular Expressions/Pattern Matching");
		
		File myReadMeFile;
		String fileContents;
		
		myReadMeFile = new File( new File("").getAbsolutePath() + "\\README.md"); 
		fileContents = FileHandler.readFile(myReadMeFile, FileReader.class);
		
		System.out.println(fileContents);
	}
}

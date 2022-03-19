package com.mc.main.advanced.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileHandler {
	
	private FileHandler() { super(); }
	
	public static boolean writeToNewFile(File file, String msg) {
		// In order to create a files we'll need to use the .createNewFile method
		// of the File instance, however we'll also want to make changes to this file.
		//
		// We can use the FileWriter to target a file we'd like to make changes to
		try (FileWriter writeToFile = new FileWriter(file.getAbsolutePath())) {			
			writeToFile.write(msg);
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String readFile(File file, Class<? extends Closeable> readerType) {
		// This example is directed to another method
		// normally we'd attempt to keep a method focused only on what it should do
		// however in this practice there are multiple ways to achieve the same thing
		//
		// The example below uses the Scanner class to read through a file, but there's
		// also a way
		
		// let's set up a way to capture contents and establish the path for the 
		// to respective reader.
		String fileContents;
		String path = file.getAbsolutePath();		
		
		// review each of the specific methods to generate fileContents
		// to explore implementation methods for each approach.
		//
		// This isn't an exhaustive list, but it shows that there are a few ways
		// to read data in an iterative fashion.
		if(readerType == Scanner.class) {
			fileContents = readScanner(path);
		} else if(readerType == BufferedReader.class) {
			fileContents = readBuffer(path);
		} else if(readerType == FileReader.class) {
			fileContents = readFileReader(path);
		} else {
			fileContents = "Error, could not read file!";
		}
		
		return fileContents;
	}
	
	private static String readScanner(String filePath) {
		
		StringBuilder fileContents = new StringBuilder();
		
		try (Scanner readFile = new Scanner(new File(filePath))) {	
			
			while(readFile.hasNextLine()) {
				fileContents.append(readFile.nextLine());
			}
			
			return fileContents.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String readBuffer(String filePath) {
		
		StringBuilder fileContents = new StringBuilder();
		String line;
		
		try ( BufferedReader br = new BufferedReader(new FileReader(new File(filePath))) ) {	
			
			while ((line = br.readLine()) != null) {
				fileContents.append(line);
			}
			
			return fileContents.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String readFileReader(String filePath) {
		
		StringBuilder fileContents = new StringBuilder();
		String line;
		
		try ( FileReader reader = new FileReader(filePath) ) {	
	       int x;
	        
	        while ((x = reader.read()) != -1) {
	        	fileContents.append((char)x);
	    	}
			
			return fileContents.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean deleteTargetFile(File file) {
		return file.delete();
	}
		
}

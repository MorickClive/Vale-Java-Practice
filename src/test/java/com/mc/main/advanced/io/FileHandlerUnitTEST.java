package com.mc.main.advanced.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileHandlerUnitTEST {
	
	private static String testFolder;
	private static File file;
	private static final String message = "Hello World!\r\n";
	private static final String filePath = "\\src\\test\\resources\\";
	private static final String fileName = "testFile.txt";
	
	@BeforeAll
	public static void setup() {
		testFolder = new File("").getAbsolutePath() + filePath;
		file = new File(testFolder + fileName);
	}
	
	@AfterEach
	public void testCleanUp() {
		FileHandler.deleteTargetFile(file);
	}
	
	@Test
	public void writeToNewFile() {
		boolean expect = FileHandler.writeToNewFile(file, message);
		
		assertTrue(expect);		
	}
	
	@Test
	public void writeToNewFile_Failure() {
		File existingFile = new File(testFolder);
		boolean expect = FileHandler.writeToNewFile(existingFile, message);
		String msg = FileHandler.readFile(existingFile, Scanner.class);
		
		System.out.println(msg);
		
		assertNull(msg);
		assertFalse(expect);	
	}
	
	@Test
	public void writeToNewFile_Scanner() {
		FileHandler.writeToNewFile(file, message);
		String expect = FileHandler.readFile(file, Scanner.class);
		
		assertNotNull(expect);
		assertEquals(message, expect);
	}
	
	@Test
	public void writeToNewFile_ReadBuffer() {
		FileHandler.writeToNewFile(file, message);
		String expect = FileHandler.readFile(file, BufferedReader.class);
		
		assertNotNull(expect);
		assertEquals(message, expect);
	}



	@Test
	public void writeToNewFile_ReadFileReader() {
		FileHandler.writeToNewFile(file, message);
		String expect = FileHandler.readFile(file, FileReader.class);
		
		assertNotNull(expect);
		assertEquals(message, expect);
	}
	
	@Test
	public void writeToNewFile_ScannerFailure() {
		FileHandler.writeToNewFile(file, message);
		String expect = FileHandler.readFile(new File(""), Scanner.class);
		
		assertNull(expect);
		assertEquals(null, expect);
	}
	
	@Test
	public void writeToNewFile_ReadBufferFailure() {
		FileHandler.writeToNewFile(file, message);
		String expect = FileHandler.readFile(new File(""), BufferedReader.class);
		
		assertNull(expect);
		assertEquals(null, expect);
	}

	@Test
	public void writeToNewFile_ReadFileReaderFailure() {
		FileHandler.writeToNewFile(new File(""), message);
		String expect = FileHandler.readFile(file, FileReader.class);
		
		assertNull(expect);
		assertEquals(null, expect);
	}

	@Test
	public void writeToNewFile_NoReader() {
		FileHandler.writeToNewFile(file, message);
		String expect = FileHandler.readFile(file, Reader.class);
		
		assertNotNull(expect);
		assertEquals("Error, could not read file!", expect);
	}
	
	@Test
	public void deleteTargetFile() {
		FileHandler.deleteTargetFile(file);
		
		assertFalse(file.exists());
	}
		
}

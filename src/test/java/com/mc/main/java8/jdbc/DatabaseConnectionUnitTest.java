package com.mc.main.java8.jdbc;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DatabaseConnectionUnitTest {

	@Mock
	private static Connection testConnection;
	
	private static DatabaseConnection testDBConnection;
	
	@BeforeEach
	public void startTest() {
		testDBConnection = new DatabaseConnection(testConnection);
	}
	
	@Test
	public void getConnection() {
		Connection connection = testDBConnection.getConnection();
	}
	
	@Test
	public void initConnection() {
		// This method won't access a database, this is to be expected as we aren't spinning up
		// a test database as part of the call.
		//TODO: add test environment for testing purposes.
		Method testMethod;
		
		try {
			testMethod = DatabaseConnection.class.getDeclaredMethod("initConnection");
			testMethod.setAccessible(true);
			
			testMethod.invoke(testMethod, null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			fail();
		}
	}
	
	@Test
	public void readProperties() {
		Method testMethod;
		
		try {
			testMethod = DatabaseConnection.class.getDeclaredMethod("readProperties");
			testMethod.setAccessible(true);
			
			testMethod.invoke(testMethod, null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			fail();
		}
	}
	
	@Test
	public void close() {
		testDBConnection.close();
	}
	
	@AfterEach
	public void cleanUp() {
		testDBConnection.close();
	}
}

package com.mc.main.java8;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JDBCPracticeUnitTEST {

	@Mock
	private static Connection connection;
	@Mock
	private static Statement statement;
	@Mock
	private static ResultSet rs;
	
	@Test
	public void start() throws SQLException {
		// Mocks		
		Mockito.when(connection.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);
		
		try {
			JDBCPractice.start(connection);
		}catch (Exception e) {
			fail();
		}

		Mockito.verify(connection, Mockito.times(1)).createStatement();
		Mockito.verify(statement, Mockito.times(3)).executeQuery(Mockito.anyString());
	}	
	
	@Test
	public void startFailure1() throws SQLException {
		// Mocks		
		Mockito.when(connection.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(Mockito.anyString())).thenThrow(SQLException.class);
		
		try {
			JDBCPractice.start(connection);
		}catch (Exception e) {
			fail();
		}

		Mockito.verify(connection, Mockito.times(1)).createStatement();
		Mockito.verify(statement, Mockito.times(1)).executeQuery(Mockito.anyString());
	}
	
	@Test
	public void readExample() throws SQLException, NoSuchMethodException, SecurityException {
		// Mocks
		Mockito.when(rs.next()).thenReturn(true, false);
		Mockito.when(rs.getString(Mockito.anyInt())).thenReturn("Mock");
		
		Method testMethod = JDBCPractice.class.getDeclaredMethod("readExample", ResultSet.class);
		testMethod.setAccessible(true);

		try {
			testMethod.invoke(testMethod, rs);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail();
		}
		Mockito.verify(rs, Mockito.times(2)).next();
		Mockito.verify(rs, Mockito.times(2)).getString(Mockito.anyInt());
	}
	

}

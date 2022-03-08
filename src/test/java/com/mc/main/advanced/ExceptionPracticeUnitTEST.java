package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.mc.main.advanced.ExceptionPractice;

public class ExceptionPracticeUnitTEST {

	@Test
	public void exceptionStart() {
		try {
			ExceptionPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void genericExceptionTestSuccess() throws Exception {
	    ExceptionPractice.genericException("Hello World");
	}
	
	@Test
	public void genericExceptionTestFailure() {
	    Exception exception = assertThrows(Exception.class, () -> {
	    	ExceptionPractice.genericException(null);
	    });
	    
	    String expectedMsg = "Cannot invoke \"String.contains(java.lang.CharSequence)\" because \"message\" is null";
	    
	    assertTrue(exception instanceof Exception);
	    assertEquals(expectedMsg, exception.getMessage());
	}

	@Test
	public void explicitNumericTestSuccess(){
	    float result = ExceptionPractice.explicitNumericException(12.0f);
	    
	    assertEquals(12.0f, result);
	}
	
	@Test
	public void explicitNumericTestFailure() {
	    Exception exception = assertThrows(ArithmeticException.class, () -> {
	    	ExceptionPractice.explicitNumericException(0);
	    });
	    
	    String expectedMsg = "no positive value found!";
	    
	    assertTrue(exception instanceof Exception);
	    assertEquals(expectedMsg, exception.getMessage());
	}
}

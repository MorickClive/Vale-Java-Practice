package com.mc.main.oop.principles.res.encap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.oop.principles.res.encap.Person;

public class PersonUnitTEST {
	
	private Person person;
	
	@BeforeEach
	public void setupTest() {
		person = new Person("Alex", 29, "sampleAddress", "numbersprovided", "sample@Email.com", "fakePass");
	}
	
	@Test
	public void defaultConstructorTest() {
		person = new Person();
		
		assertTrue(person instanceof Person);
		assertEquals("???", person.getName());
		assertEquals(0, person.getAge() );
		assertEquals("???", person.getAddress() );
		assertEquals("???", person.getMobileNumber() );
		assertEquals("???", person.getEmail() );

		assertEquals(null, person.getPassword("passwordVerify"));
		
	    Exception exception = assertThrows(Exception.class, () -> {
	    	person.getPassword(null);
	    });
	    
	    String expectedMsg = "Cannot invoke \"String.equals(Object)\" because \"request\" is null";
	    
	    assertTrue(exception instanceof Exception);
	    assertEquals(expectedMsg, exception.getMessage());
	}
	
	@Test
	public void fullArgsConstructorTest() {		
		assertTrue(person instanceof Person);
		assertEquals("Alex", person.getName());
		assertEquals(29, person.getAge() );
		assertEquals("sampleAddress", person.getAddress() );
		assertEquals("numbersprovided", person.getMobileNumber() );
		assertEquals("sample@Email.com", person.getEmail() );

		assertEquals("fakePass", person.getPassword("passwordVerify"));
	}
	
	@Test
	public void accessNameTEST() {
		person.setName("Alan");
		
		assertEquals("Alan", person.getName());
	}
	
	@Test
	public void accessAgeTEST() {
		person.setAge(32);
		
		assertEquals(32, person.getAge());		
	}
	
	@Test
	public void accessAddressTEST() {
		person.setAddress("32. Beachside Avn");
		
		assertEquals("32. Beachside Avn", person.getAddress());
	}

	@Test
	public void accessEmailTEST() {
		person.setEmail("AlexD@Companyltd.com");
		
		assertEquals("AlexD@Companyltd.com", person.getEmail());
	}

	@Test
	public void accessMobileNumberTEST() {
		person.setMobileNumber("VariousNumbers");
		
		assertEquals("VariousNumbers", person.getMobileNumber());
	}

	@Test
	public void accessPasswordSuccessTEST() throws Exception {
		person.setPassword("passwordVerify", "sampleResult");
		
		assertEquals("sampleResult", person.getPassword("passwordVerify"));
	}
	
	@Test
	public void accessPasswordFailureTEST() throws Exception {
		// RESOURCES
	    String expectedMsg = "Invalid password provided, password unchanged!";
		
	    // ACTIONS
	    Exception exception = assertThrows(Exception.class, () -> {
			person.setPassword("wrongRequest", "sampleResult");
	    });
	    
	    // ASSERTIONS
	    assertTrue(exception instanceof Exception);
	    assertEquals(expectedMsg, exception.getMessage());
		assertEquals("INCORRECT SECURITY ANSWER!", person.getPassword("wrongRequest"));
	}
	
}

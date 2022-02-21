package com.mc.main.oop.principles;

import com.mc.main.oop.principles.res.EncapsulationAdvanced;
import com.mc.main.oop.principles.res.encap.Person;

public class EncapsulationPractice {
	
	/** We don't want anyone creating an instance of this */
	private EncapsulationPractice() { super();	}
	
	public static void start() {
		// Let's look at the definition of the Person class
		// to gain insight about encapsulation
		Person egPerson = new Person("Alex", 27, "AddressExample", "numbersprovided", "sample@Email.com", "samplePassword");
		
		// What happens if you print a class?
		System.out.println(egPerson);
		// Well Wrapper classes and String print out fine right?
		// unfortunately, meaningful information from a class is another thing that 
		// java helps us with for the previous examples.
		// 
		// You might find that java prints something like the following:
		// "com.mc.main.oop.principles.res.Person@4f3f5b24"
		//
		// this is because we are printing the "method reference", not the value
		// but Person has multiple "values", they are all stored as independent attributes!
		// when we look at inheritance, we'll look into this in more detail!
		
		// However, covering our accessor methods, we know we can retrieve these details by proxy!
		// Not only that, but we can determine if we SHOULD return these attributes!
		String password = egPerson.getPassword("passwordVerify");
		
		// This is the concept of Encapsulation, all classes should restrict access to data
		// it is responsible for within reason. These access modifiers allow us control over this data.
		System.out.println(egPerson.getName() + ", password: " + password);
		
		// Checkout the following for additional techniques:
		EncapsulationAdvanced.start();
	}

}

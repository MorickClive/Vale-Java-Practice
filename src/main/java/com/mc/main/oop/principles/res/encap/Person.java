package com.mc.main.oop.principles.res.encap;

/** 
 * This is an example for the Encapsulation principle of Object-Oriented Practices!
 * 
 * Object-Oriented practices and building complex data types begin to explore relationships
 * between data as well as visibility of functionality. We explore OOP principles in order
 * to understand the basis of how java classes/objects work and relate to the code we've written already.
 * 
 * ========================================
 * ENCAPSULATION:
 * ========================================
 * 
 * As we know we can build a class with attributes, constructors and methods!
 * 
 * These three major distinctions are also referred to as class members!
 * 
 * But up until now we've not really explored much about how classes relate to other
 * classes.
 * 
 * Encapsulation is underlined by how our class controls data, encapsulating data is a role
 * that all classes should consider - after all we don't want just anybody adjusting data
 * we store in a complex type.
 * 
 * In Wrapper classes we looked at how primitive data is stored inside a class and the benefits
 * of having data values with additional supporting functionality.
 * 
 * But let us take a class object whose responsibility resides to store information about
 * an individual in our application; first we need to build up what constitutes a person.
 * 
 * @author MorickClive
 */
public class Person {
	
	// ATTRIBUTES
	// ========================================
	// Typically these attributes might be stored inside
	// our Person objects, each instance storing unique data
	// for each detail!
	//
	// But when we use an access modifier like "public", we can access that value directly!
	// being able to access information directly like that will violate laws such as
	// the data protection act as well as data privacy!
	//
	// Instead we can set them to "private", meaning that they are only visible in the scope
	// of this class - if you tried to use the following, private will cause failure
	// because the visibility of the attributes is set private - therefore inaccessible!
	//
	// eg: Person x = new Person();
	//
	// System.out.print(x.name);
	// // This will cause a compilation failure, as x.name is private - therefore not visible!
	//
	private String name;
	private int age;
	private String password;
	private String address;
	private String email;
	private String mobileNumber;
	
	// So we have our attributes outlined, this is a good opportunity to explore the available
	// access modifiers and what they mean in terms of our java class!
	// eg:
	//
	// empty/default	- Visible to the package, the default.
	// private			- Visible to the class only.
	// public			- Visible to the whole application.
	// protected		- Visible to the package and all subclasses; the value of such is explored more with inheritance!
	
	
	// CONSTRUCTORS
	// ========================================
	// Constructors are typically public, however there can be value in using modifiers to the accessibility
	// of such.
	// If you recall in previous classes, their constructors were set to private.
	// Well if you can't access a method or attribute if it's private then you can't use the constructor
	// because it's not visible!
	// This is a good way to prevent developers creating instances of classes that aren't typically cases
	// of objects that would be created, class objects that only use a static context are perfect examples
	// where you may wish to prevent the instantiation of a class!
	
	// Default constructor
	// ====================
	// default constructors are constructors without parameters, they are required for
	// the ability to instantiate the class for use as a value!
	// 
	// In fact they are so important that if you don't provide one, java will automatically generate one
	// all default constructions contain one reference to the "super" keyword, this has more meaning
	// in inheritance, but the exclusion of the keyword is also handled by the compiler, adding it in if excluded.
	public Person() {
		super();
		// In the cases of attributes that are uninitialised, it is a good idea
		// to set default values if the user is unable to provide values; such as this constructor.
		// consider providing average examples, or non-specific details that can be overwritten in the future.
		this.name = "???";
		this.age = 0;
		this.email = "???";
		this.mobileNumber = "???";
		this.address = "???";
		this.password = null; // we could set to a default, but a null value will cause an error; we can use this prompt users
	}
	
	// Imagine a constructor with more attributes!
	// Luckily in Design Patterns, there's an elegant alternative to verbose constructors!
	public Person(String name, int age, String address, String mobileNumber, String email, String password) {
		this();
		this.name = name;
		this.age = age;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.password = password;
	}
	
	// METHODS
	// ========================================
	// When we deal with an instance, we typically want to access the details
	// when performing interactions in our application.
	//
	// Perhaps we want to get the persons name, but we need to respect the right visibility.
	// the term 'get-ters' and 'set-ters' may crop up when dealing with accessibility
	// to attributes that belong to an object.

	// "GET-TERS"
	// ========================================
	// Here are methods that represent our access to retrieval of attributes
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// This is where visibility becomes a little more clear.
	// when an attribute is visible, we can directly overwrite the value.
	// With an accessor method, we can determine if the correct procedure is respected before the value is returned!
	public String getPassword(String request) {
		
		String answer = this.checkDatabase(request);
		
		if(request.equals(answer)) {
			return this.password;
			}
		else {
			return "INCORRECT SECURITY ANSWER!";
		}
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	
	// "SET-TERS"
	// ========================================
	// Here are methods that represent our access to assign values to our attributes!
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// We can protect fields from change as well!
	public void setPassword(String request, String password) throws Exception {
		// let's just check our user still knows their password
		String answer = this.getPassword(request);
		
		if(answer.equals(this.password)) {
			this.password = password;
		} else {
			throw new Exception("Invalid password provided, password unchanged!");
		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	// Utility
	// ========================================
	// Here are methods the class might generally provide to broaden method capability
	
	private String checkDatabase(String request) {
		String answer;
		
		// here we'd put more complex operations to send user request to compare against security answers.
		// eg: connection.sendRequest(url, request);
		// in this case we are using an example to express an idea; we'll keep it unsafely associated with
		// the following:
		answer = "passwordVerify";
		
		// we shouldn't do this, but the idea is that we can control how users of our system might pass
		// data - and how that might stop the unrestricted access of attributes!
		
		return answer;		
	}
}

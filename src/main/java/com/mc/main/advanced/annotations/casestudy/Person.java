package com.mc.main.advanced.annotations.casestudy;

// Here we have our annotations applied
@JsonSerializable // A mark to imply this object can be translated into a JSON String
public class Person {
	
	@JsonElement // a marker of a field to provide.
	private String forename;

	@JsonElement
	private String surname;
	
	@JsonElement(key = "Age") // here we are using Key as a means to provide a bespoke label
	private String age;
	
	@Init // Marked to run as part of the initialising process
    private void initNames() {
		// This is a setup method, part of a process outside of this class
		// all we are doing is ensuring that fore-and-surnames start with capital letters
        this.forename = this.forename.substring(0, 1).toUpperCase() 
          + this.forename.substring(1);
        this.surname = this.surname.substring(0, 1).toUpperCase() 
          + this.surname.substring(1);
    }
	
	public Person() {
		super();
	}
	
	public Person(String forename, String surname, String age) {
		this.forename = forename;
		this.surname = surname;
		this.age = age;
	}

}

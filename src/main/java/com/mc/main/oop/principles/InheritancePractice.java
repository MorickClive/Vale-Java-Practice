package com.mc.main.oop.principles;

import com.mc.main.oop.principles.res.inherit.Book;

public class InheritancePractice {
	
	private InheritancePractice() {	super();	}
	
	public static void start() {		
		// When we define an object and state it inherits from another class
		// we are looking at the OOP principle of inheritance.
		// This is a nice way to share existing functionality of a class with another class,
		// after all, why would we write out duplicate code if we don't need to?
		//
		// Inheritance allows us to structure code in a way where commonality is shared
		// to child objects through associations, when we describe an association like
		// inheritance, we'd use to expression that it "is-a" example of the class it inherits from.
		
		// Let's take a look at the Media class object and how it relates to its child classes:
		// Book and CompactDisk.
		
		
		// Inheritance usage example:
		Book myBook = new Book("Example Book Title","Alex", "20/02/2022", "Educational", 202);
		Library myLibrary = new Library("Java Case Study Library", "local-home", myBook);
		
		// We can now extract our book from the Library and ask java
		// to provide us with the title of our book - a detail that is
		// only provided to Book by its relationship with Media.
		String bookTitle = myLibrary.getExampleBook().getTitle();
		
		System.out.println("The title of our book stored in " + myLibrary.getName() + ", is: " + bookTitle);
	}
	
	// Aggregation
	public static class Library {
		
		// Whilst inheritance is an example of an "is-a" relationship
		// this isn't the only case where another class relates to another class.
		// 
		// Looking at another relationship - a "has-a" relationship is an example
		// where a class owns or holds another class as an attribute!
		
		// ATTRIBUTES
		// ========================================
		private String name;
		private String address;
		
		// Here is an example of an "has-a" relationship
		private Book exampleBook;
		
		// In terms of relationships we typically represent classes and their relationships in UML diagrams 
		// (UML/Unified Modeling Language).
		// 
		// We have different links between classes, these are outlined below:
		// Association - a general, loose link between classes, this is particularly true of 
		//				 classes sharing an abstract class which we will cover later.
		// Aggregation - a has-a relationship is where one class can own another, but can exist without having an instance of that class.
		// Composition - a has-a relationship where both classes depend on their relationship.
		//
		// In this case, a Library can exist without books; whilst it is a bland example of a library
		// the ownership of books doesn't exclusively determine that this building is a library.
		//
		// An example of a composite relationship might be a person class, which "has-a" head attribute
		// without this object as part of a person - the person cannot exist!
		//
		// Once you've reviewed Library, investigate CompactDisk on the UML task to investigate
		// the researched relationships and how best to relate the has-a relationship CompactDisk contains.

		// CONSTRUCTORS
		// ========================================
		public Library() {
			super();
		}

		public Library(String name, String address, Book exampleBook) {
			super();
			this.name = name;
			this.address = address;
			this.exampleBook = exampleBook;
		}
		
		
		// METHODS
		// ========================================
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Book getExampleBook() {
			return exampleBook;
		}

		public void setExampleBook(Book exampleBook) {
			this.exampleBook = exampleBook;
		}
		
	}

}

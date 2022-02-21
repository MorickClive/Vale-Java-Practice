package com.mc.main.oop.principles.res.inherit;

/**
 * 
 * Notice that this class seems rather small, this fact is actually intentional
 * and begins to reveal the benefit of inheritance.
 * 
 * First observe the "extends" keyword, this allows us to inform java that we want
 * to establish the relationship of this class to another.
 * This will then enable the parent-child relationship of Media with Book.
 * 
 * As part of a "is-a" relationship, we would say that Book is-a Media or more appropriately
 * "Book is an example of Media". 
 * This means that anything Media can do or store, Book can also do as well.
 * 
 * This is why the class looks so small - it's only adding the unique details that books
 * provide to a class, relying on the Media definition to store its title, author and publish date.
 * 
 * Let's take a look at the constructor to see and appreciate the other subtle difference.
 * 
 * @author MorickClive
 *
 */
public class Book extends Media {
	
	// ATTRIBUTES
	// ========================================	
	private String genre;
	private int pageCount;
	
	// CONSTRUCTORS
	// ========================================
	public Book() {
		// The keyword super is a way for a child class
		// to reference a parent class.
		// 
		// In this case, we are calling the parents default constructor.
		// All objects in java are build upon an existing, predefined class object that
		// forms the basis for objects that you create.
		//
		// Even without a explicit reference(using extends), a standard java class you write
		// will use the super keyword during the creation of an instance.
		// This is because all class objects, inherit from the "Object" class.
		//
		// This also means that there are some pre-existing methods you might have noticed
		// that you didn't write that are included as methods to custom classes.
		super();
		this.genre = "UNKNOWN";
		this.pageCount = 0;
	}

	public Book(String title, String author, String datePublished, String genre, int pageCount) {
		// This example of super is how we store details that Media handles for us
		// by calling super and passing the title, author and datePublished, we are
		// asking Java to pass on the values to be stored in the "Media" part of Book.
		super(title, author, datePublished);
		
		// We can store the details that belong to this class directly, using the "this" keyword.
		// 
		// now we can see that "super" and "this" are linked by inherit inheritance and self
		// referential integrity.
		// we can refer to the parent object using super, e.g: super.getAuthor();
		// and we can refer to this active object by using the "this" keyword:
		// this.getGenre();
		this.genre = genre;
		this.pageCount = pageCount;
		
		// Let's look at the Overrides section
	}

	// METHODS
	// ========================================
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	// OVERRIDES
	// ========================================
	// Whilst we won't go into too much detail, remember that
	// that we said that super exists in all objects; meaning that inheritance is
	// always in play?
	//
	// In Polymorphism we will look at how child classes can build upon inheritance
	// and adapt existing inherited behaviour, changing it to be more specific to the child class!
	//
	// Let's look at CompactDisk!
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + pageCount;
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + ", genre=" + genre + ", pageCount=" + pageCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		Book other = (Book) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (pageCount != other.pageCount)
			return false;
		return true;
	}	

}

package com.mc.main.oop.principles.res;


/**
 * 
 * Media is a class/object that represents any sort of item you might expect to find
 * in a library, media varies greatly in example but all examples of media share
 * common attributes!
 * 
 * There is nothing unique or special about this class except that it is an example of
 * some kind of media, yet it can still be built upon using child classes.
 * 
 * Let's take a look at Book and then CompactDisk.
 * 
 * @author MorickClive
 */
public class Media {
	
	// ATTRIBUTES
	// ========================================	
	private String title;
	private String author;
	private String datePublished;

	// CONSTRUCTORS
	// ========================================
	public Media() {
		super();
		this.title = "MISSING";
		this.author = "MISSING";
		this.datePublished = "UNKNOWN";
	}
	
	public Media(String title, String author, String datePublished) {
		super();
		this.title = title;
		this.author = author;
		this.datePublished = datePublished;
	}
	
	// METHODS
	// ========================================
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}
	
	// OVERRIDES
	// ========================================
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((datePublished == null) ? 0 : datePublished.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (datePublished == null) {
			if (other.datePublished != null)
				return false;
		} else if (!datePublished.equals(other.datePublished))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[title=" + title + ", author=" + author + ", datePublished=" + datePublished;
	}
	
}

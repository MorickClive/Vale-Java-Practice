package com.mc.main.oop.principles.res;

import com.mc.main.Application;

/**
 * 
 * Again, just like Book, CompactDisk is an example of Media.
 * 
 * BUT, unlike Book, CompactDisks or CDs store different data; so they might
 * have a title, author and date of release, they do not necessarily have page numbers
 * or genres.
 * 
 * In this example, to express the power of Java and reflect digital media,
 * we are going to give this compactDisk two associations, one of a "has-a" and one of a "is-a" relationship.
 * 
 * This CompactDisk "is-a" example of Media, however
 * this CompactDisk "has-a" Application.
 * 
 * Feel free to investigate the rest of this class.
 * Once you are finished, begin to look at the nested class 'Library' in InheritancePractice.
 *  
 * ========================================
 * UML Task:
 * ========================================
 * ~ review this after investigating Library
 * 
 * Let's think about how important the has-a relationship is and how we might describe it.
 * In a UML diagram we could potentially show this relationship to be an example of a aggregate association.
 * Whilst a CD might exist, there is no reason why it has to contain any data or application on it initially/
 * 
 * @author MorickClive
 *
 */
public class CompactDisk extends Media /* Example of an 'is-a' relationship */{
	
	private Application app; // Example of has-a relationship.
	private boolean isReadOnly;

	public CompactDisk() {
		super();
	}

	public CompactDisk(String title, String author, String datePublished, Application app, boolean readOnly) {
		super(title, author, datePublished);
		this.setApp(app);
		this.isReadOnly = readOnly;
	}

	public Application getApp() {
		return app;
	}

	// Here we can force initialisation of an app that can be checked
	public void setApp(Application app) {
		// Idea: Could apply scanning hook here to check application is safe for use.
		this.app = app;
	}

	public boolean isReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((app == null) ? 0 : app.hashCode());
		result = prime * result + (isReadOnly ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		CompactDisk other = (CompactDisk) obj;
		if (app != other.app)
			return false;
		if (isReadOnly != other.isReadOnly)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", app=" + app + ", isReadOnly=" + isReadOnly + "]";
	}



}

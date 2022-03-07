package com.mc.main.advanced.designpatterns.structural.adapter;

// Here we store the German Interactions as a composite of the adapter
// this allows us to then map interactions from the GermanInteractions
// instance into the constraint of our LanguageInteractions interface
public class EnglishToGermanAdapter implements LanguageInteractions {
	
	// The stored instance will become a target for member translation
	// to the common interface - LanguageInteractions
	private GermanInteractions lang;
	// If the composite attribute is an interface, we could support the adaptation
	// of multiple classes to the LanguageInteractions.
	//
	// if certain subclasses of that interface require unique handling in order to translate
	// that method, the adapter may need to identify this first using the 'instanceof' comparison
	// first!
	
	public EnglishToGermanAdapter(GermanInteractions lang) {
		super();
		this.lang = lang;
	}

	// This method is also implemented by EnglishInteractions, aligning the
	// EnglishInteractions with GermanInteractions.
	// The method call will then access/map the respective call to the German method
	// of equivalent action.
	@Override
	public String greeting() {
		return this.lang.Gruﬂ();
	}

}

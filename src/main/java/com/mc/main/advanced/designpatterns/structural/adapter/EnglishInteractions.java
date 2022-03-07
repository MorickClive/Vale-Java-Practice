package com.mc.main.advanced.designpatterns.structural.adapter;

// EnglishInteractions will share the LanguageInteraction interface
// this will give the adapter class a structure to align for adaptation.
public class EnglishInteractions implements LanguageInteractions {
	
	public String greeting() {
		return "Hello!";
	}

}

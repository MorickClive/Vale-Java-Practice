package com.mc.main.advanced.designpatterns.structural.adapter;

// The GermanInteractions class uses German method names and is therefore incompatible with
// EnglishInteractions or the LanguageInteractions interface
// Let's observe the GermanToEnglishAdapter!
public class GermanInteractions {
	
	public String Gruﬂ() {
		return "Hallo, willkommen!";
	}

}

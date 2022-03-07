package com.mc.main.advanced.designpatterns.creational;

import com.mc.main.advanced.res.CharacterSheet;

// Whether it's nested inside the target class
// or defined in its own right, the builder pattern
// will encapsulate the target class for building
//
// The way to utilise this class is to create an instance of the builder,
// whether this be singleton statically or regularly through the new keyword.
//
// when the instance is created, we have it create our "build" class as an instance
// or alternatively it can have a copy of the attributes from the target class.
//
// by making this instance, we can use our builder to use its methods to
// provide values to the build object for specific attributes.
// each attribute provided will then change the build object, whilst the method
// will return this builder object - this allows us to chain methods from the builder.
//
// e.g 
// CharacterSheetBuilder myBuilder = new CharacterSheetBuilder();
// myBuilder.name("name") /* <- this will return myBuilder*/
// myBuilder.name("name").race("sample")......
//
// The final act is to utilise a finalisation step, this is achieved by
// providing a method that returns the built object in whatever state it's in.
// 
// Let's see this in action back in DesignPatterPractice.builderPattern();
public class CharacterSheetBuilder {

	private static CharacterSheet build;

	public CharacterSheetBuilder() {
		super();
		build = new CharacterSheet();
	}

	public CharacterSheetBuilder name(String name) {
		build.setName(name);
		return this;
	}

	public CharacterSheetBuilder race(String race) {
		build.setRace(race);
		return this;
	}

	public CharacterSheetBuilder profession(String profession) {
		build.setProfession(profession);
		return this;
	}

	public CharacterSheetBuilder level(int level) {
		build.setLevel(level);
		return this;
	}

	public CharacterSheetBuilder AC(int armourClass) {
		build.setArmourClass(armourClass);
		return this;
	}

	public CharacterSheetBuilder hitPoints(int[] hitpoints) {
		build.setHitpoints(hitpoints);
		return this;
	}

	public CharacterSheetBuilder abilityScores(int str, int dex, int cons, int intel, int wis, int charisma) {
		build.setStrength(str);
		build.setDexterity(dex);
		build.setConstitution(cons);
		build.setInteligence(intel);
		build.setWisdom(wis);
		build.setCharisma(charisma);
		return this;
	}

	public CharacterSheet build() {
		return build;
	}

}

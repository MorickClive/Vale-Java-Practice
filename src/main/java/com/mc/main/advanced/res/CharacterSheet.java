package com.mc.main.advanced.res;

import java.util.Arrays;

// Builder example
//
// This class is an example Dungeons & Dragons character sheet
// it contains a lot of details surrounding itself and won't 
// fully model all aspects of the Character.
//
// It'll distinctly remain a POJO - Plain Old Java Object
// meaning that it won't inherit, implement or otherwise
// interact with any other code beyond what is written within it.
public class CharacterSheet {
	
	// As we can see, there are a considerable number of attributes
	// the Constructor for this class will end up being very, very large
	// and difficult to work with.
	//
	// for this, we'll create a builder class, which will help provide
	// a means to use method chaining to build upon the object in question.
	private String name, race, profession;
	private int level, armourClass;
	private int[] hitPoints = new int[2];
	private int strength, dexterity, constitution, intelligence, wisdom, charisma;
	
	// We can provide default values and additional constructors
	// but this will detract from the example slightly.
	public CharacterSheet() { super(); }

	// Setters are very important here, getters will be useful for when we want
	// to access our regular POJO.
	//
	// Setters provide a fundamental means of "building" this class instance
	// as part of the pattern, we could provide these attributes in the builder
	// but the POJO maybe used in the future - why duplicate attribute values in memory?
	//
	// Let's observer CharacterSheetBuilder
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArmourClass() {
		return armourClass;
	}

	public void setArmourClass(int armourClass) {
		this.armourClass = armourClass;
	}

	public int[] getHitpoints() {
		return hitPoints;
	}

	public void setHitpoints(int[] hitpoints) {
		hitPoints = hitpoints;
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getInteligence() {
		return intelligence;
	}

	public void setInteligence(int inteligence) {
		this.intelligence = inteligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	@Override
	public String toString() {
		return "[ - Character Sheet:"
				+ "\n - Name: " + name 
				+ ",\n\t- Race: " + race 
				+ ",\n\t- Class: " + profession 
				+ ",\n\t- Level: " + level 
				+ ",\n\t- AC: " + armourClass
				+ ",\n\t- Hit Points: "+ Arrays.toString(hitPoints)
				+ ",\n\t- [ Strength=" + strength 
				+ ", Dexterity=" + dexterity 
				+ ", Constitution=" + constitution
				+ ", Intelligence=" + intelligence 
				+ ", Wisdom=" + wisdom 
				+ ", Charisma=" + charisma + " ]\n]";
	}
	
}

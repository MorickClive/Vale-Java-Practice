package com.mc.main.advanced.res;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.advanced.designpatterns.creational.CharacterSheetBuilder;

public class CharacterSheetUnitTEST {
	
	private static CharacterSheet charSheet;
	
	@BeforeEach
	public void setup() {
		charSheet = new CharacterSheetBuilder()
				.name("Caspian")
				.race("Human")
				.profession("Chronurgy Wizard")
				.level(9)
				.AC(12)
				.hitPoints(new int[]{52,52})
				.abilityScores(8, 14, 14, 20, 13, 14)
				.build();
	}
	
	@Test
	public void defaultConstructor() { 
		charSheet = new CharacterSheet();
		
		assertTrue(charSheet instanceof CharacterSheet);
	}

	@Test
	public void accessName() {
		String expected = "Zone";
		charSheet.setName(expected);
		
		assertEquals(expected, charSheet.getName());
	}

	@Test
	public void accessRace() {
		String expected = "Tiefling";
		charSheet.setRace(expected);
		
		assertEquals(expected, charSheet.getRace());
	}

	@Test
	public void accessProfession() {
		String expected = "Sorcerer";
		charSheet.setProfession(expected);
		
		assertEquals(expected, charSheet.getProfession());
	}

	@Test
	public void accessLevel() {
		int expected = 17;
		charSheet.setLevel(expected);
		
		assertEquals(expected, charSheet.getLevel());
	}

	@Test
	public void accessArmourClass() {
		int expected = 19;
		charSheet.setArmourClass(expected);
		
		assertEquals(expected, charSheet.getArmourClass());
	}

	@Test
	public void accessHitpoints() {
		int[] expected = {250, 250};
		charSheet.setHitpoints(expected);
		
		assertEquals(expected, charSheet.getHitpoints());
	}

	@Test
	public void accessStrength() {
		int expected = 8;
		charSheet.setStrength(expected);
		
		assertEquals(expected, charSheet.getStrength());
	}

	@Test
	public void accessDexterity() {
		int expected = 14;
		charSheet.setDexterity(expected);
		
		assertEquals(expected, charSheet.getDexterity());
	}

	@Test
	public void accessConstitution() {
		int expected = 16;
		charSheet.setConstitution(expected);
		
		assertEquals(expected, charSheet.getConstitution());
	}

	@Test
	public void accessInteligence() {
		int expected = 12;
		charSheet.setInteligence(expected);
		
		assertEquals(expected, charSheet.getInteligence());
	}

	@Test
	public void accessWisdom() {
		int expected = 13;
		charSheet.setWisdom(expected);
		
		assertEquals(expected, charSheet.getWisdom());
	}

	@Test
	public void accessCharisma() {
		int expected = 20;
		charSheet.setCharisma(expected);
		
		assertEquals(expected, charSheet.getCharisma());
	}

	@Test
	public void testToString() {
		String expected = "[ - Character Sheet:\n"
				+ " - Name: Caspian,\n"
				+ "	- Race: Human,\n"
				+ "	- Class: Chronurgy Wizard,\n"
				+ "	- Level: 9,\n"
				+ "	- AC: 12,\n"
				+ "	- Hit Points: [52, 52],\n"
				+ "	- [ Strength=8, Dexterity=14, Constitution=14, Intelligence=20, Wisdom=13, Charisma=14 ]\n"
				+ "]";

		assertEquals(expected, charSheet.toString());
	}
	
}

package com.mc.main.advanced.designpatterns.creational;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.main.advanced.res.CharacterSheet;

public class CharacterSheetBuilderUnitTEST {

	private static CharacterSheetBuilder builder;
	private static CharacterSheet build;

	@BeforeEach
	public void setup() {
		builder = new CharacterSheetBuilder()
				.name("Caspian")
				.race("Human")
				.profession("Chronurgy Wizard")
				.level(9)
				.AC(12)
				.hitPoints(new int[]{52,52})
				.abilityScores(8, 14, 14, 20, 13, 14);
		build = builder.build();
	}
	
	@Test
	public void defaultConstructor() {
		builder = new CharacterSheetBuilder();
		
		assertTrue(builder instanceof CharacterSheetBuilder);
	}
	
	@Test
	public void provideName() {
		String expected = "Zone";
		CharacterSheet character = new CharacterSheetBuilder()
				.name(expected)
				.build();
		
		assertEquals(expected, character.getName());
	}
	
	@Test
	public void provideRace() {
		String expected = "Tiefling";
		CharacterSheet character = new CharacterSheetBuilder()
				.race(expected)
				.build();
		
		assertEquals(expected, character.getRace());
	}
	
	@Test
	public void provideProfession() {
		String expected = "Sorcerer";
		CharacterSheet character = new CharacterSheetBuilder()
				.profession(expected)
				.build();
		
		assertEquals(expected, character.getProfession());
	}
	
	@Test
	public void provideLevel() {
		int expected = 18;
		CharacterSheet character = new CharacterSheetBuilder()
				.level(expected)
				.build();
		
		assertEquals(expected, character.getLevel());
	}
	
	@Test
	public void provideAC() {
		int expected = 19;
		CharacterSheet character = new CharacterSheetBuilder()
				.AC(expected)
				.build();
		
		assertEquals(expected, character.getArmourClass());
	}
	
	@Test
	public void provideHitPoints() {
		int[] expected = {250, 250};
		CharacterSheet character = new CharacterSheetBuilder()
				.hitPoints(expected)
				.build();
		
		assertEquals(expected, character.getHitpoints());
	}
	
	@Test
	public void provideAbilityScores() {
		int[] expected = {8, 14, 18, 12, 14, 20};
		CharacterSheet character = new CharacterSheetBuilder()
				.abilityScores(8, 14, 18, 12, 14, 20)
				.build();

		assertEquals(expected[0], character.getStrength());
		assertEquals(expected[1], character.getDexterity());
		assertEquals(expected[2], character.getConstitution());
		assertEquals(expected[3], character.getInteligence());
		assertEquals(expected[4], character.getWisdom());
		assertEquals(expected[5], character.getCharisma());
	}
	
	@Test
	public void build() {
		builder = new CharacterSheetBuilder()
				.name("Caspian")
				.race("Human")
				.profession("Chronurgy Wizard")
				.level(9)
				.AC(12)
				.hitPoints(new int[]{52,52})
				.abilityScores(8, 14, 14, 20, 13, 14);
		
		CharacterSheet actual = builder.build();
		String expected = "[ - Character Sheet:\n"
				+ " - Name: Caspian,\n"
				+ "	- Race: Human,\n"
				+ "	- Class: Chronurgy Wizard,\n"
				+ "	- Level: 9,\n"
				+ "	- AC: 12,\n"
				+ "	- Hit Points: [52, 52],\n"
				+ "	- [ Strength=8, Dexterity=14, Constitution=14, Intelligence=20, Wisdom=13, Charisma=14 ]\n"
				+ "]";
		
		assertTrue(actual instanceof CharacterSheet);
		assertEquals(expected, actual.toString());
	}

}

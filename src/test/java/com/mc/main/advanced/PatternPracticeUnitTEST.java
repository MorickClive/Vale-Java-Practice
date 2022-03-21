package com.mc.main.advanced;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileReader;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.mc.main.advanced.io.FileHandler;
import com.mc.main.util.Practice;

public class PatternPracticeUnitTEST {
	
	@Test
	public void patternStart() {
		try {
			PatternPractice.start();
		}catch (Exception e) {
			fail();
		}
	}
}

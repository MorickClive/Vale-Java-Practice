package com.mc.main.advanced;

import java.io.File;
import java.io.FileReader;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.mc.main.advanced.io.FileHandler;
import com.mc.main.util.Practice;

public class PatternPractice extends Practice {
	/** We don't want to create an instance of this class */
	private PatternPractice() {
		super();
	}

	public static void start() {
		printHeader("Regular Expressions/Pattern Matching");
		
		File myReadMeFile;
		String fileContents;
		Stream<MatchResult> matches;
		long count;
		
		// Let's load in the README File and attempt to match every case where "Java" appears
		myReadMeFile = new File( new File("").getAbsolutePath() + "\\README.md"); 
		fileContents = FileHandler.readFile(myReadMeFile, FileReader.class);
		
		// When we use regular expression, there's a unique way of using characters, wild cards and symbols
		// to express patterns within files based on certain character combinations.
		//
		// We won't cover Regex here, but for the time being we'll use the simple combo of
		// match "up to and including Java".
		matches = patternMatcher(fileContents, ".*Java");
		
		matches.forEach(x -> System.out.println(x.group()) );
	}
	
	private static Stream<MatchResult> patternMatcher(String src, String pattern) {
		// First we use a Pattern, so we use the Pattern.compile - using a string that represents our regular
		// expression.
		Pattern filter = Pattern.compile(pattern);
		// We can then use the pattern and apply it to a source String.
		Matcher check = filter.matcher(src);
		
		// There are many things we can do once we've applied the matcher, in this case
		// we'll return it as a Stream - but we could do many things with the matched results
		// sorted in "check"
		return check.results();
	}
	
}

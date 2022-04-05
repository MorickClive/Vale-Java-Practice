package com.mc.main.advanced;

import com.mc.main.advanced.annotations.ExampleAnnotation;
import com.mc.main.advanced.annotations.casestudy.ObjectToJsonConverter;
import com.mc.main.advanced.annotations.casestudy.Person;
import com.mc.main.util.Practice;
import com.mc.main.util.ReportFormater;

// Let's review ExampleAnnotation
@ExampleAnnotation
public class AnnotationPractice extends Practice {

	private AnnotationPractice() {
		super();
	}
	
	public static void start() {
		printHeader("Annotations");
		
		String result;	
		Person person = new Person("caspian", "lovett", "28");
		
		try {
			result = ObjectToJsonConverter.convertToJson(person);
			ReportFormater.reportDivided("\tPerson JSON output:", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Annotations are useful as a means to provide data about our classes
		// similar to a form of abstraction, we can use annotations as a standard
		// or warning.
	}
	
}

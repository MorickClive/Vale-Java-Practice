package com.mc.main.advanced.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * As outlined by Oracle documentations:
 * ========================================
 * Information for the compiler
 * 		— Annotations can be used by the compiler to detect errors or suppress warnings.
 * Compile-time and deployment-time processing 
 * 		— Software tools can process annotation information to generate code, XML files, and so forth.
 * Runtime processing 
 * 		— Some annotations are available to be examined at runtime.
 * ========================================
 * 
 * In certain recent examples, you might see @Override or in some cases @SuppressWarnings
 * These are annotations, but in particularly these are annotations that informs the compiler about details
 * about code that indicate a state or useful scenario that helps with the construction of executable code.
 * 
 * Perhaps you want to help inform the compiler that a warning isn't actually applicable as a result of a
 * false/positive or some other case where the warning is not actually a problem.
 * 
 * Override allows us to inform the compiler that a child class is overriding parent implementation.
 * 
 * Compile-time annotations help us produce implementation or some process that occurs prior to the execution of code
 * this can build upon the application to provided resources or implementation that can be inferred from
 * existing implementation. Project Lombok is an example of a particularly example of some of the capabilities
 * of this annotation, where certain accessor methods can be generated as a result of the appropriate annotations.
 * 
 * In general, Annotations are designed to be some form of Meta data - data about data.
 * 
*/

// In order to create a custom annotation we simply declare our interface with the @ symbol
// as part of the interface keyword.
//
// This will allow us to use @Example Annotation
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ExampleAnnotation {
	
	// Annotations aren't really part of the end result of code, more like a set of instructions
	// to provide information about our data to the compiler.
	//
	// As such we can control when this annotation is triggered, but also we can determine what it precisely
	// controls information about using the @Target annotation to define it's focus based on the ElementType:
	// TYPE
	// Field
	// Constructor
	// Method
	// Parameter
	// etc...
	
	// Retention focuses more on the cycle of compilation, either "Runtime" or "Source"
	// Runtime will focus on active code and providing a reference opportunity through annotations
	//
	//
	// Source focuses on providing detailing about implementation, but wouldn't effect the code running
	// it's like a comment, but with opportunity to inform the compiler about the instructions provided.
	// Consider:
	// 		- @Override
	//		- @SuppressWarnings

	// Let's investigate AnnotationPractice.start()
}

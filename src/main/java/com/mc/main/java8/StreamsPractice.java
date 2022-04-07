package com.mc.main.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mc.main.util.Practice;
import com.mc.main.util.ReportFormater;

public class StreamsPractice extends Practice {
	
	private static final int[] even = {2, 4, 6, 8, 10, 12, 14};
	private static final int[] odd = {1, 3, 5, 7, 9, 11, 13};
	private static List<Integer> evenList, oddList;
	
	private StreamsPractice() {
		super();
	}

	public static void start() {
		printHeader("Streams");
		
		// let's first observe the challenges faced by standard arrays
		// and how we can collect the results of streaming to convert
		// a basic array into a streamable collection
		listsToStreams();
		
		// With our even and odd Collections ready for streaming, let's observe some
		// other techniques that allow us to control and collect data based
		// on a functional/lambda approach.
		streamTechniques();
		
		//TODO: Parallel/Concurrent streams
	}
	
	private static void listsToStreams() {
		// Streaming allows us to take advantage of writing functional statements
		// using functional interfaces to create lambda styled expressions
		//
		// In particular, streaming typically works for any array of data, applying
		// a predicate(method implementation as a parameter) to apply an expression to each
		// item in the array.
		//
		// it's very similar to foreach, but the usage of lambda expressions refine this down
		// to a singular statement; rather than excessive block scope.
		// In fact Streams include a process for handling each object like a foreach!
		
		// Let's look at how we can convert a primitive array to a wrapper class array List!
		collect();

		ReportFormater.reportHeader("Stream().forEach");
		// Now that we've translated our primitive even and odd array to an auto-boxed collection
		// we can stream the list, using a simple print method on the results.
		System.out.print("ForEach even: ");
		evenList.stream().forEach(x -> System.out.format("%s ",x));

		System.out.print("\nForEach odd: ");
		oddList.stream().forEach(x -> System.out.format("%s ",x));
		System.out.println();
	}

	private static void collect() {
		// Here we will use the Arrays object to stream our primitive array
		evenList = Arrays.stream(even).boxed().collect(Collectors.toList());
		oddList = Arrays.stream(odd).boxed().collect(Collectors.toList());
		// notice we then use the boxed method in order to apply a standard operation
		// provided by the IntStream object in order to wrap the primitive value into
		// it's - equivalent!
		
		// finally we use ".collect" to store each result and use the Collectors object
		// to store our entries into a new list
		
		// As a result we've used streams to translate int[] into List<Integer>
		// this is quite useful as Streams can have some anomalous interactions with primitive arrays.
		// Using a form of Collection type is going to provide more direct support.
	}
	
	private static void streamTechniques() {
		// We've already observed .stream, .forEach, ".collect()" & Collectors
		// let's observe some other actions we can take when streaming through collections
		// whilst applying predicates.
		filter();
		map();
		sorted();
		reduce();
	}
	
	private static void map() {
		ReportFormater.reportHeader("Stream().map()");
		// Map allows us to apply some kinda of implementation via predicate
		// the end result is returned allowing us the capability of applying
		// a standardised operation to each element of the collection.
		
		List<Integer> squaredEventList;
		
		squaredEventList= evenList.stream().map(x -> x*x).collect(Collectors.toList());
		System.out.format("EvenList squared: %s\n", squaredEventList);
		
		squaredEventList = oddList.stream().map(x -> x*x).collect(Collectors.toList());
		System.out.format("OddList squared: %s\n", squaredEventList);
	}
	
	private static void filter() {
		ReportFormater.reportHeader("Stream().filter()");
		// Let's use filter to apply a check againest our data, passing the data to a collection if it meets
		// out requirements based on a filter!		
		List<Integer> divByThree;
		
		divByThree = oddList.stream().filter(x -> x % 3 == 0).collect(Collectors.toList());
		System.out.format("Odds divisible by Three: %s\n", divByThree);
		
		divByThree = evenList.stream().filter(x -> x % 3 == 0).collect(Collectors.toList());
		System.out.format("Evens divisible by Three: %s\n", divByThree);
	}
	
	private static void sorted() {
		ReportFormater.reportHeader("Stream().sorted()");
		// Let's inverse the evens list, then have streams sort the collection back to ascending order!
		List<Integer> correctedList;
		
		Collections.reverse(evenList);
		System.out.format("EvenList invert order: %s\n", evenList);
		
		correctedList = evenList.stream().sorted().collect(Collectors.toList());
		System.out.format("EvenList sorted order: %s\n", correctedList);
		Collections.reverse(evenList); // let's reset this list now we've shown the sorting method.
	}
	
	private static void reduce() {
		ReportFormater.reportHeader("Stream().reduce()");
		// The focus of the reduce method depends on which overload of the method you access
		// the general principle is that reduce will attempt to summarise the stream into a single value
		// This is done by taking the result of the last iteration and factoring it into the current iteration
		//
		// let's add the total of all stored even numbers:
		int result;
		
		System.out.println(evenList);
		
		// .reduce(accumulator);
		// ========================================
		result = evenList.stream().reduce((a, b) -> a+b).orElseThrow();
		System.out.println("Total: " + result);
		
		// .reduce(identity, accumulator);
		// ========================================
		// The next overload is an accumulator format of reduce.
		// It uses the first parameter as a base value to build on, rather than assuming our first
		// entry has nothing to pass through.
		result = evenList.stream().reduce(result, (a,b) -> a+b);
		System.out.println("Total accumalated: " + result);
	}
}

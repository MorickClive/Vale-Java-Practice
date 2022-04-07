package com.mc.main.java8.streams;

// Here we are providing the functional interface to expect some kind of Parameter
// the implementation provided should by extension, provide some kind of implementation
// for our x parameter in the body of implementation that is requested.
@FunctionalInterface
public interface PrintableParam {
	
	public void print(Object x);

}

package com.mc.main.advanced.threads.concurrency;

public class CounterPOJO implements Counter<Integer> {
	
	private static int count;
	private int iterations;
	
	public CounterPOJO(int iterations) {
		super();
		count = 0;
		this.iterations = iterations > 0 ? iterations : 1;
	}
	
	public void increment() {
		for(int x = 0; x < 5000 ; x++) {
			count++;
		}
	}
	
	public void decrement() {
		for(int x = 0; x < 5000 ; x++) {
			count--;
		}
	}
	
	public Integer value() {
		return count;
	}

}

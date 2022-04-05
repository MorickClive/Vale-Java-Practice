package com.mc.main.advanced.threads.concurrency;

public class CounterSync implements Counter<Integer> {
	
	private static int count;
	private int iterations;
	
	public CounterSync(int iterations) {
		super();
		count = 0;
		this.iterations = iterations > 0 ? iterations : 1;
	}
	
	public synchronized void increment() {
		for(int x = 0; x < iterations ; x++) {
			count++;
		}
	}
	
	public synchronized void decrement() {
		for(int x = 0; x < iterations ; x++) {
			count--;
		}
	}
	
	public Integer value() {
		return count;
	}

}

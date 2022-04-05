package com.mc.main.advanced.threads.concurrency;

public interface Counter<T> {

	void increment();
	void decrement();
	T value();

}

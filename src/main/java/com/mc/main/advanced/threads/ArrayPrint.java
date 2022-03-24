package com.mc.main.advanced.threads;

import java.util.Collection;

public class ArrayPrint<T> extends Thread {

	private Collection<T> array;

	public ArrayPrint(Collection<T> array) {
		this.array = array.size() > 0 && (array != null) ? array : null;
	}

	public void run() {
		super.run();
		
		int y = 0;
		
		if (array != null) {
			for(Object item : array) {
				System.out.format("%s: - #%d : %s\n", Thread.currentThread().getName(), ++y, item);
			}
		}

	}

}

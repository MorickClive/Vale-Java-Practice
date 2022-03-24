package com.mc.main.advanced.threads;

public class MessageInterrupt implements Runnable {
	@Override
	public void run() {
		String[] list = { "cat", "dog", "penguin", "seagul", "car" };
		try {
			for (String msg : list) {
				System.out.format("%s :\t- %s\n", Thread.currentThread().getName(), msg);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.format("%s : WARNING: did not complete full task!\n", Thread.currentThread().getName());
		}
	}
}

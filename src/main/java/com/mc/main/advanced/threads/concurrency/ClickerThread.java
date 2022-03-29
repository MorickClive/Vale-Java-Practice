package com.mc.main.advanced.threads.concurrency;

public class ClickerThread implements Runnable {

	private Counter count;
	private boolean flag;
	
	public ClickerThread(Counter count, boolean increment) {
		super();
		this.count = count;
		this.flag = increment;
	}
	
	@Override
	public void run() {
		if(flag) {
			count.increment();
		} else {
			count.decrement();
		}
		System.out.format("Counter%s Value: %d\n", flag ? "++" : "--", count.value());
	}

}

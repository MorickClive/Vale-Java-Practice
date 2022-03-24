package com.mc.main.advanced.threads;

public class InterruptThread extends Thread {
	
	public InterruptThread() {
		super();
	}
	
	@Override
	public void run() {
		super.run();
		
		try{
			crunchNumbers();
		}catch (Exception e) {
			System.out.format("%s : %s\n", Thread.currentThread().getName(),e);
			return;
		}
	}
	
	private void crunchNumbers() throws InterruptedException {
		
		int value = 0;
		
		for(int x = 0; x < 100; x++) {
			
			value += algorithm(x);
			
			if(Thread.interrupted()) {
				throw new InterruptedException();
			}
		}
	}
		
	private double algorithm(int x)  {
		if (x > 90) { this.interrupt(); }
		return x * 2;
	}

}

package com.mc.main.advanced.threads;

public class ThreadLifeCycle extends Thread {

	public ThreadLifeCycle() {
		super();
	}

	public void run() {
		super.run();
		
        try {
            Thread.sleep(1500);
            System.out.println("Thread State: " + this.getState().toString());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
	}
	
}

package com.mc.main.advanced.threads.concurrency;

public class TradeExchange {
	
	private String hold;
	private boolean empty;
	
	public TradeExchange() {
		super();
		empty = true; // ensure that we don't default to false
	}

	public synchronized void put(String msg) {
        // Wait until message has been retrieved.
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        
        // Store message
        this.hold = msg;
        // Ensure that empty status for loop
        empty = false;

        // Notify consumer that status has changed.
        notifyAll();
	}
	
	public synchronized String retrieve() {
		String localHold = null;
		
        // Wait until message is available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        
        // Toggle status.
        localHold = hold;
        hold = null;
        empty = true;
        
        // Notify producer that status has changed.
        notifyAll();
        return localHold;
	}

}

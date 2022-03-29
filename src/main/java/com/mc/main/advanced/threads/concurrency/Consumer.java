package com.mc.main.advanced.threads.concurrency;

import java.util.Random;

public class Consumer implements Runnable {

	private TradeExchange exchange;
	
	public Consumer(TradeExchange exchange) {
		super();
		this.exchange = exchange;
	}
	
	@Override
	public void run() {
		
        Random random = new Random();
        for (String message = exchange.retrieve();
        		! message.equals("DONE"); 
        		message = exchange.retrieve()) {
            	System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {}
        }
	}
	
}

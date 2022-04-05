package com.mc.main.advanced.threads.concurrency;

import java.util.Random;

public class Provider implements Runnable {
	
	private TradeExchange exchange;
	
	public Provider(TradeExchange exchange) {
		super();
		this.exchange = exchange;
	}
	
	@Override
	public void run() {
        String messageList[] = {
                "Message 1",
                "Message 2",
                "Message 3",
                "Message 4"
            };
            Random random = new Random();

            for (int x = 0; x < messageList.length; x++) {
            	exchange.put(messageList[x]);
                try {
                	Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {}
            }
            exchange.put("DONE");
	}
	
}

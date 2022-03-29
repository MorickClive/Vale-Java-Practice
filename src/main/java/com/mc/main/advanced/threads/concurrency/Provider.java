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
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };
            Random random = new Random();

            for (int i = 0;
                 i < importantInfo.length;
                 i++) {
            	exchange.put(importantInfo[i]);
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {}
            }
            exchange.put("DONE");
	}
	
}

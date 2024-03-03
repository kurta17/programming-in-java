package com.harbourspace.lesson08;

import java.util.concurrent.atomic.AtomicInteger;

class CoffeeRunnable implements Runnable {
    private final static AtomicInteger orderId = new AtomicInteger(1);
    private final AtomicInteger orders;
    private final  String baristaName;

    public CoffeeRunnable(AtomicInteger orders, String baristaName) {
        this.orders = orders;
        this.baristaName = baristaName;
    }

    @Override
    public void run() {
        while (orders.get() > 0) {
            System.out.println(baristaName + " is making your coffee for order " + orderId.getAndIncrement());
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                   throw new RuntimeException(e);
            }
            System.out.println("Your coffee for order " + (orderId.get() - 1) + " is ready. Enjoy!");
            orders.decrementAndGet();
        }
    }
}

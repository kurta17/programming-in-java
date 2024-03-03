package com.harbourspace.lesson08;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class CoffeeRunnableSemaphore implements Runnable {
    private static AtomicInteger orderId = new AtomicInteger(1);
    private final AtomicInteger orders;
    private final String baristaName;
    private final Semaphore coffeeMachine;

    public CoffeeRunnableSemaphore(AtomicInteger orders, String baristaName, Semaphore coffeeMachine) {
        this.orders = orders;
        this.baristaName = baristaName;
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void run() {
        while (orders.get() > 0) {
            try {
                coffeeMachine.acquire(); // Acquire permit for the coffee machine
                System.out.println(baristaName + " is making your coffee for order " + orderId.getAndIncrement());
                Thread.sleep(5000); // Simulate making coffee
                System.out.println("Your coffee for order " + (orderId.get() - 1) + " is ready. Enjoy!");
                orders.decrementAndGet();
                coffeeMachine.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


package com.harbourspace.lesson08;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class main {

    public static void main(String[] args) {
        //runnable
//        thread t = new thread();
//        Thread t1 = new Thread(t);
//        t1.start();
        //atomic
//        AtomicInteger orders = new AtomicInteger(8); // 5 orders waiting to be processed
//        CoffeeRunnable coffeeRunnable1 = new CoffeeRunnable(orders, "Barista 1");
//        CoffeeRunnable coffeeRunnable2 = new CoffeeRunnable(orders, "Barista 2");
//
//        Thread thread1 = new Thread(coffeeRunnable1);
//        Thread thread2 = new Thread(coffeeRunnable2);
//
//        thread1.start();
//        thread2.start();

        //semaphore
        AtomicInteger orders = new AtomicInteger(4);
        Semaphore coffeeMachine = new Semaphore(1);
        CoffeeRunnableSemaphore coffeeRunnable1 = new CoffeeRunnableSemaphore(orders, "Barista 1",coffeeMachine);
        CoffeeRunnableSemaphore coffeeRunnable2 = new CoffeeRunnableSemaphore(orders, "Barista 2",coffeeMachine);

        Thread thread1 = new Thread(coffeeRunnable1);
        Thread thread2 = new Thread(coffeeRunnable2);
        Thread thread3 = new Thread(coffeeRunnable1);

        thread1.start();
        thread2.start();
        thread3.start();



    }
}

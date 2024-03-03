package com.harbourspace.lesson08;

//public class thread extends Thread {
//    public void run() {
//        System.out.println("Barista is making your coffee");
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Your coffee is ready. Enjoy!");
//    }
//
//
//}


public class thread implements Runnable {
    public void run() {
        System.out.println("Barista is making your coffee");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Your coffee is ready. Enjoy!");
    }


}
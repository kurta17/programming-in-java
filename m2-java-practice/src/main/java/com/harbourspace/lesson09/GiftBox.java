package com.harbourspace.lesson09;

public class GiftBox<T> {
    private T gift;

    public void put(T gift) {
        this.gift = gift;
    }

    public T get() {
        return gift;
    }


}

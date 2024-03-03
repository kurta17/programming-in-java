package com.harbourspace.lesson09;

import java.util.function.BiFunction;

public class Magic {
    public static <T, U, R> R doMagic(T item1, U item2, BiFunction<T, U, R> magic) {
        return magic.apply(item1, item2);
    }
}


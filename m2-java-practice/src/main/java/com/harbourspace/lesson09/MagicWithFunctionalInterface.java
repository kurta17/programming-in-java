package com.harbourspace.lesson09;

import java.util.function.BiFunction;

public class MagicWithFunctionalInterface {
    public static <T1, T2, R> R doMagic(T1 item1, T2 item2, MagicFunction<T1, T2, R> magic) {
        return magic.apply(item1, item2);
    }
}

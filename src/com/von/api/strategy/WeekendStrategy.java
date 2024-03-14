package com.von.api.strategy;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public enum WeekendStrategy {
        EXIT("x", ()-> " "),
        MON("1", ()-> "Monday");


    private final String key;
    private final Supplier<String> supplier;

    WeekendStrategy(String key, Supplier<String> supplier) {
        this.key = key;
        this.supplier = supplier;
    }

    public static String extracted(Scanner sc) {
        String a = sc.next();

        return Stream.of(values())
                .filter(o->o.key.equals(a))
                .findAny()
                .orElseGet(()->EXIT)
                .supplier.get();
    }
}

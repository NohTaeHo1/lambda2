package com.von.api.proxy;

import java.util.function.Function;

public class TypeProxy {
    public static Function<?, String> string = String::valueOf; // String으로 변환
    public static Function<String, Integer> integerType = Integer::valueOf;
    public static Function<String, Double> doubleType = Double::valueOf;



}
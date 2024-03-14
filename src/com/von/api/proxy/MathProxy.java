package com.von.api.proxy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer, Integer> absInt = Math::abs;
    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Double, Double, Double> maxDouble = Math::max;
    public static BiFunction<Integer, Integer, Integer> minInt = Math::min;
    public static BiFunction<Double, Double, Double> minDouble = Math::min;
    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Integer, Integer, Integer> rangeRandomInt = (a, b)->(int)(Math.random()*(b-a));
    public static BiFunction<Double, Double, Double> rangeRandomDouble = (a, b)->(Double)(Math.random()*(b-a));
    public static Function<Double, Double> ceilDouble = Math::ceil;
    public static Function<Double, Integer> ceilInt = (a) -> (int) Math.ceil(a);
    public static Function<Double, Double> floorDouble = Math::floor;
    public static Function<Double, Integer> floorInt = (a) -> (int) Math.floor(a);
    public static Function<Float, Integer> roundInt = Math::round;
    public static Supplier<LocalDate> nowDate = LocalDate::now;
    public static Supplier<LocalTime> nowTime = LocalTime::now;
//Math.sqrt(double a): 주어진 숫자의 제곱근을 반환합니다.
//Math.pow(double a, double b): 주어진 숫자의 거듭제곱을 계산합니다.
    //Math.sin(double a): 주어진 각도의 사인 값을 반환합니다.
    //Math.cos(double a): 주어진 각도의 코사인 값을 반환합니다.
    //Math.exp(double a): e^a.
    //Math.log(double a): 주어진 숫자의 자연로그 값을 반환합니다.
    //Math.atan2(double y, double x): y 좌표 및 x 좌표를 사용하여 각도를 반환합니다.
    //Math.toDegrees(double angrad): 라디안 값을 각도로 변환합니다.
    //Math.toRadians(double angdeg): 각도 값을 라디안으로 변환합니다.
}
package com.hillogy.functionaljava.methodandconstructorreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(34,67,8,23,67,89,90);

        // Object Method reference example  object :: instanceMethod
        Consumer<Integer> consumer = System.out :: println ;

        consumer.accept(56);

        printElements(list, consumer);

        // Class Static Method reference example  Class :: staticMethod
        Supplier<Double> randomNumber = Math :: random;

        System.out.println(randomNumber.get());

        // Class Instance Method reference example  Class :: instanceMethod
        List<String> listOfString = Arrays.asList("Kit", "Kat", "Shake");

        Function<String, Integer> function = String :: length;

        List<Integer> newList = map(listOfString, function);

        System.out.println(newList);

    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer) {

        list.forEach(x ->
                consumer.accept(x)
        );

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {

        List<R> newList = new ArrayList<>();

        list.forEach(x ->
                newList.add(function.apply(x))
        );

        return newList;
    }
}
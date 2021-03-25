package com.hillogy.functionaljava.predefined.functional.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(34,67,8,23,67,89,90);

        Consumer<Integer> consumer = e -> System.out.println(e);

        consumer.accept(56);

        printElements(list, consumer);

    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer) {

        list.forEach(x ->
                consumer.accept(x)
        );

    }

}
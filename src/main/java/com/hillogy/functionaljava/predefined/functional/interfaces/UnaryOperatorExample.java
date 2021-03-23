package com.hillogy.functionaljava.predefined.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args){

        List<Integer> list = List.of(10, 20, 30, 40, 50);

        UnaryOperator<Integer> operator = i -> i * 100;

        List<Integer> newList = mapper(list, operator);

        System.out.println(newList);

    }

    private static <T> List<T> mapper(List<T> list, UnaryOperator<T> operator) {

        List<T> newList = new ArrayList<>();

        list.forEach(x -> {
            T element = operator.apply(x);
            newList.add(element);
        });

        return newList;

    }

}

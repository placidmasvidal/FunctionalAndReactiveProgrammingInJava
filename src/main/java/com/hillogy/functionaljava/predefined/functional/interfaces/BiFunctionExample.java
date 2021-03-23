package com.hillogy.functionaljava.predefined.functional.interfaces;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args){

        BiFunction<String, String, String> biFunction =
                (a,b) -> a + b;

        System.out.println(biFunction.apply("Hillogy", "Software"));



    }

}

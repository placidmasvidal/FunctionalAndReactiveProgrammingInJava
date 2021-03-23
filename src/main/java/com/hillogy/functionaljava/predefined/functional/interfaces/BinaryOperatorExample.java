package com.hillogy.functionaljava.predefined.functional.interfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args){

        BinaryOperator<String> operator = (a, b) -> a + "." + b;

        System.out.println(operator.apply("hillogy", "com"));

    }

}

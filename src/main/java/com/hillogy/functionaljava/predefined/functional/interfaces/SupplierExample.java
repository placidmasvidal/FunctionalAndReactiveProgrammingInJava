package com.hillogy.functionaljava.predefined.functional.interfaces;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> new String("A String");

        System.out.println(stringSupplier.get());

        Supplier<Double> randomNumber = () -> Math.random();

        System.out.println(randomNumber.get());

    }

}

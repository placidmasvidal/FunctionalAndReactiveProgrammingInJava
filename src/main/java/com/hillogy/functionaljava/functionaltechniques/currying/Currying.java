package com.hillogy.functionaljava.functionaltechniques.currying;

import java.util.function.Function;

public class Currying {

    public static void main(String[] args){

        Function<Integer, Function<Integer, Integer>> fun1 =
                u -> v -> u + v;

        Function<Integer, Integer> fun2 = fun1.apply(1);

        Integer sum1 = fun2.apply(2);

//        System.out.println(sum);


//        System.out.println(fun1.apply(1).apply(2));

        Integer sum2 = fun2.apply(3);

    }

}

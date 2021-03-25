package com.hillogy.functionaljava.functionalprogramming.referentialtransparency;

/*
* Referential transparency is a property of a function,
* variable or expression whereby the expression can be
* replaced by its (evaluated) value without affecting the
* behaviour of the program
* Maths example: x = 7 * (2*4)  =   x = 7 * (8)
* */
public class ReferentialTransparency {

    public static void main(String[] args){

        int result = add(2, multiply(2,4));
        // int result = add(2, 8); //same result
        // int result = add(2, multiply(2, multiply(2,2))); //same result
        System.out.println(result);
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static int multiply(int a, int b){
        return a*b;
    }

}

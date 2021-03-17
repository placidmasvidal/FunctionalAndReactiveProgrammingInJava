package com.hillogy.functionaljava.lambda.usecases;

public class MethodWithMultipleStatements {

    // original method to be converted to lambda
    public int length(String s){
        int l = s.length();
        System.out.println("Length of the String is " + l);
        return l;
    }

    public static void main(String[] args) {

        //Step 1:
        // Lambdas doesn't need name for methods
        /*public int (String s){
            int l = s.length();
            System.out.println("Length of the String is " + l);
            return l;
        }*/

        //Step 2:
        // Lambdas doesn't need return type
        /*public length(String s){
            int l = s.length();
            System.out.println("Length of the String is " + l);
            return l;
        }*/

        //Step 3: Lambdas doesn't access modifiers
        /*(String s){
            int l = s.length();
            System.out.println("Length of the String is " + l);
            return l;
        }*/

        //Step 4: Convert code to lambda by adding ->
        /*(String s) -> {
            int l = s.length();
            System.out.println("Length of the String is " + l);
            return l;
        }*/

        //Step 5: Using type inference, compiler can guess parameter types
        //so can remove them also
        /* (s) -> {
            int l = s.length();
            System.out.println("Length of the String is " + l);
            return l;
        } */

        //Step 6: Lambdas doesn't need () when passing a single parameter
        /* s -> {
            int l = s.length();
            System.out.println("Length of the String is " + l);
            return l;
        } */

        LengthOfString len = str -> {
            int l = str.length();
            System.out.println("The length of the given String is " + l);
            return l;
        };

        int length = len.length("Hillogy");
        System.out.println(length);
    }
}
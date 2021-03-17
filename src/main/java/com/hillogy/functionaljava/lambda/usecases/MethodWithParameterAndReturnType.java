package com.hillogy.functionaljava.lambda.usecases;

public class MethodWithParameterAndReturnType {

    // original method to be converted to lambda
    public int length(String s){
        return s.length();
    }

    public static void main(String[] args) {

        //Step 1:
        // Lambdas doesn't need name for methods
        /*public int (String s){
            return s.length();
        }*/

        //Step 2:
        // Lambdas doesn't need return type
        /*public (String s){
            return s.length();
        }*/

        //Step 3: Lambdas doesn't access modifiers
        /*(String s){
            return s.length();
        }*/

        //Step 4: Convert code to lambda by adding ->
        /*(String s) -> {
            return s.length();
        }*/

        //Step 5: Lambdas with only one statement doesn't need {}
        /* (String s) -> return s.length(); */

        //Step 6: Using type inference, compiler can guess parameter types
        //so can remove them also
        /* (s) -> return s.length(); */

        //Step 6: Lambdas with only one statement doesn't need return keyword
        /* (s) -> s.length(); */

        LengthOfString len = (str) -> str.length();
        int length = len.length("Hillogy");
        System.out.println(length);

    }
}

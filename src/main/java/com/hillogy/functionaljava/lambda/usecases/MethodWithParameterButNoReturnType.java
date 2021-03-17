package com.hillogy.functionaljava.lambda.usecases;

public class MethodWithParameterButNoReturnType {

    // original method to be converted to lambda
    public void operation(int a, int b){
        System.out.println(a+b);
    }

    public static void main(String[] args){

        //Step 1:
        // Lambdas doesn't need name for methods
    /*    public void (int a, int b){
        System.out.println(a+b);
        }*/

        //Step 2: Lambdas doesn't need return type
        /*public (int a, int b){
            System.out.println(a+b);
        }*/

        //Step 3: Lambdas doesn't access modifiers
        /*(int a, int b){
            System.out.println(a+b);
        }*/

        //Step 4: Convert code to lambda by adding ->
        /*(int a, int b) -> {
            System.out.println(a+b);
        }*/

        //Step 5: Lambdas with only one statement doesn't need {}
        /*(int a, int b) -> System.out.println(a+b);
        */

        //Step 6: Using type inference, compiler can guess parameter types
        //so can remove them also
        /*(a, b) -> System.out.println(a+b);    */

        //Finally you have your lambda implementation for your functional interface
        MathOperation add = (a, b) -> System.out.println(a+b);

        //Invoke your functional interface
        add.operation(10, 20);

        //Let's create a different implementation for your functional interface
        MathOperation multiply = (a, b) -> System.out.println(a*b);

        multiply.operation(10, 90);
    }
}

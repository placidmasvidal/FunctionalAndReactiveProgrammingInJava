package com.hillogy.functionaljava.lambda.usecases;

public class MethodWithNoParameterAndNoReturnType {

    // original method to be converted to lambda
    public void myName(){
        System.out.println("Hillogy");
    }

    public static void main(String[] args){

        //Step 1:
        // Lambdas doesn't need name for methods
        /*public void () {
            System.out.println("Hillogy");
        }*/

        //Step 2:
        //Lambdas doesn't need the return type
        /* public () {
               System.out.println("Hillogy");
           }
         */

        //Step 3:
        //Lambdas doesn't need access modifiers
        /* () {
               System.out.println("Hillogy");
           }
         */

        //Step 4:
        //Convert this code into a lambda by adding -> between () and {
        /* () -> {
               System.out.println("Hillogy");
           }
         */

        //Step 5:
        //Lambdas with only one statement doesn't need {}
        /* () ->    System.out.println("Hillogy");
         */

        //Finally you have your lambda implementation for your functional interface
        Name name = () -> System.out.println("Hillogy");

        //Invoke your functional interface
        name.myName();

    }

}

package com.hillogy.functionaljava.methodandconstructorreference;

import java.util.function.Function;

public class ConstructorReference {

    public static void main(String[] args){

        // Example Case: we need to execute some tasks parallely,
        // so we will be needing threads to execute those tasks parallely

        // Here is the lambda we can use to get threads by passing a runnable
//        Function<Runnable, Thread> threadGenerator = r -> new Thread(r);

        // Let's convert it to constructor reference
        Function<Runnable, Thread> threadGenerator = Thread :: new;

        Runnable task1 = () -> System.out.println("Task 1 executed");

        Runnable task2 = () -> System.out.println("Task 2 executed");

        Thread thread1 = threadGenerator.apply(task1);

        Thread thread2 = threadGenerator.apply(task2);

        thread1.start();
        thread2.start();

        // We can code that in a more compact way
        threadGenerator.apply(() -> System.out.println("Task 3 executed")).start();
    }

}

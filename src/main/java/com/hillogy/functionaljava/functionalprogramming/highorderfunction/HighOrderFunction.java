package com.hillogy.functionaljava.functionalprogramming.highorderfunction;

/*
* Use case for the example:
* we have to create a factory that produces and
* configures items and then supplies the items
* */

public class HighOrderFunction {

    public static void main(String[] args){

        IFactory<Integer> createFactory = createFactory(() -> Math.random()*100, r -> r.intValue());
        Integer product = createFactory.create();
        System.out.println(product);
    }

    public static <T,R> IFactory<R> createFactory(IProducer<T> producer,
                                                IConfigurator<T,R> configurator){
        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }
}

package com.hillogy.functionaljava.functionalprogramming.highorderfunction;

@FunctionalInterface
public interface IConfigurator<T,R> {

    R configure(T t);

}

package com.hillogy.functionaljava.functionaltechniques.functionchaining;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    // default allows an interface to provide an implementation
    default Consumer<T> thenAccept(Consumer<T> next){

        Objects.requireNonNull(next);

        return (T t) -> {
            this.accept(t);
            next.accept(t);
        };
    }
}

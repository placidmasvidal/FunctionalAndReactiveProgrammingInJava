package com.hillogy.functionaljava.functionalprogramming.designpatterns.decorator;

import com.hillogy.functionaljava.functionaltechniques.functioncomposition.Function;

public class BurgerShop {

    Function<Burger, Burger> decoration;

    public BurgerShop(Function<Burger, Burger> decoration){
        this.decoration = decoration;
    }

    public Burger use(Burger baseBurger){
        System.out.println("Base Burger: " + baseBurger);
        return decoration.apply(baseBurger);
    }


}

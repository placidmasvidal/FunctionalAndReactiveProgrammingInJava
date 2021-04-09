package com.hillogy.functionaljava.functionalprogramming.designpatterns.factoryMethod;

public class FactoryMethodPattern {

  public static void main(String[] args) {

      Flooring floor = FlooringFactory.getFlooring(-1, 18);
      floor.installation();
  }
}

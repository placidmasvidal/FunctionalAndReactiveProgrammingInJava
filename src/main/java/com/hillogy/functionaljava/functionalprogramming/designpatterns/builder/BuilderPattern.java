package com.hillogy.functionaljava.functionalprogramming.designpatterns.builder;

public class BuilderPattern {

  public static void main(String[] args) {

      MobileBuilder builder = new MobileBuilder();
/*      builder.with(myBuilder -> {
          myBuilder.ram = 4;
          myBuilder.battery = 4000;
          myBuilder.processor = "A12 Bionic";
      }).createMobile();*/

      builder.with(myBuilder -> {
          myBuilder.ram = 4;
          myBuilder.battery = 4000;
          myBuilder.processor = "A12 Bionic";
      });

      builder.with(myBuilder -> myBuilder.processor = "M1");

      Mobile mobile1 = builder.createMobile();
    System.out.println(mobile1.toString());
  }
}

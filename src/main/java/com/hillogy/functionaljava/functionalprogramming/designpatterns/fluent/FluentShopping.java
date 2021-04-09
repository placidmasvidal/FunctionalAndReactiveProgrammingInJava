package com.hillogy.functionaljava.functionalprogramming.designpatterns.fluent;

public class FluentShopping {

  public static void main(String[] args) {

    /*    Order myOrder = new Order();
    myOrder.add("Shoes");
    myOrder.add("Headphones");
    myOrder.deliverAt("Street no 45, Jodhpur");

    myOrder.place();*/

/*     new Order()
            .add("Shoes")
            .add("Headphones")
            .deliverAt("Street no 45, Jodhpur")
            .place(); */

    Order.place(order ->
            order.add("shoes")
            .add("headphones")
            .deliverAt("Street no 45, Jodhpur")
            );
  }
}

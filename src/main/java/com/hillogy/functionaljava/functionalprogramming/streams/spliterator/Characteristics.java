package com.hillogy.functionaljava.functionalprogramming.streams.spliterator;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Characteristics {

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(7);
    list.add(9);
    list.add(0);
    list.add(1);

    Stream<Integer> stream = list.stream();
    Spliterator<Integer> spliterator = stream.spliterator();
    int bits = spliterator.characteristics();
    System.out.println(Integer.bitCount(bits));

    // OR
    System.out.println(Integer.bitCount(bits | Spliterator.ORDERED));

    // AND
    System.out.println(Integer.bitCount(bits & Spliterator.ORDERED));
    System.out.println(bits & Spliterator.ORDERED);

    System.out.println(spliterator.hasCharacteristics(Spliterator.ORDERED));


    // State of stream in performance optimization:
    // Suppose we have te case:
    /*
      SortedSet<Integer> set = new TreeSet<>();
      set.stream()
      .sorted()
      .forEach(System.out::println);
     */
    // how this pipeline will get executed?
    //the sorted() intermediate operation will not be performed
    //because has been already sorted by SortedSet
    //sorted() preserved the sort characteristic in this case
    //so operations may inject, preserve or clear a characteristic

  }
}

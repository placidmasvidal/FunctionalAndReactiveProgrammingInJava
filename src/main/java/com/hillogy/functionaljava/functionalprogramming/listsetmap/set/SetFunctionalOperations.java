package com.hillogy.functionaljava.functionalprogramming.listsetmap.set;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetFunctionalOperations {

  public static void main(String[] args) {

    Set<Integer> set = Set.of(3, 56, 7, 82, 39);

    // TRAVERSAL

    set.forEach(System.out::println);

    System.out.println("\n----------------\n");

    // SORTING

    set.stream().sorted().forEach(System.out::println);

    System.out.println("\n----------------\n");

    // this sorted stream couldn't be collected into a Set, because hashSets doesn't preserve sorted order
    // if we want to collect that set sorted we should do it into a TreeSet, and don't need to sort the stream
    // because is sorted automatically, see how:

    TreeSet<Integer> sortedSet = set.stream()
            .collect(Collectors.toCollection(TreeSet::new));

    sortedSet.forEach(System.out::println);

    System.out.println("\n----------------\n");

    // FILTER

    set.stream().filter(e -> e % 2 == 0).forEach(System.out::println);

    System.out.println("\n----------------\n");

    // MAPPING

    Set<Double> hashSet = set.stream().map(e -> Double.valueOf(e)).collect(Collectors.toSet());

    hashSet.forEach(System.out::println);

    System.out.println("\n----------------\n");

    // REDUCE

    int sum = set.stream()
            .mapToInt(e -> e)
            .sum();

    System.out.println(sum);
  }
}

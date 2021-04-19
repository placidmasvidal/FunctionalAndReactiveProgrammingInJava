package com.hillogy.functionaljava.functionalprogramming.collectors.customcollectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {

  public static void main(String[] args) {

      List<Integer> numbers = List.of(2,6,8,9,0,1,52,5,61,8,9,96,0,18,23);

      //To create our custom collector we don't need any class to implement the Collector interface
      //The Collector interface itself offers a method to create a custom collector: Collector.of
      Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(
              //1. supplier
              /*() -> new ArrayList<>()*/ ArrayList::new,
              //2. accumulator (BiConsumer)
              (list, e) -> list.add(e),
              //3. combiner (BiFunction)
              (list1, list2) -> {
                  list1.addAll(list2);
                  return list1;
              },
              //5. Characteristics, Step 4, finisher (function), skipped, because IDENTITY_FINISH is an identity function
              //that returns the input value back without modifying anything, which means the accumulated or
              //combined result is the final result
              Collector.Characteristics.IDENTITY_FINISH);

      List<Integer> evens = numbers.stream()
              .filter(e -> e % 2 == 0)
              .collect(toList);

    evens.forEach(System.out::println);


    Collector<Integer, List<Integer>, List<Integer>> toSortedListCollector =
            Collector.of(
            ArrayList::new, //supplier
            (list, e) -> list.add(e) , //BiConsumer
            (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            },
            (list)->{
                Collections.sort(list);
                return list;
            },
            Collector.Characteristics.UNORDERED
    );

      List<Integer> sortedList = numbers.stream()
              .collect(toSortedListCollector);

      sortedList.forEach(System.out::println);

  }
}

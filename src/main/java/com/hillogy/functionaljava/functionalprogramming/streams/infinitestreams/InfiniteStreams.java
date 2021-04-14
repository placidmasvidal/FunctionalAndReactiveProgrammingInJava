package com.hillogy.functionaljava.functionalprogramming.streams.infinitestreams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {

  public static void main(String[] args) {

    Stream.iterate(0, i -> i + 1);

    //1. Generate infinite stream by iterate, using a seed and a UnaryOperator
    IntStream.iterate(0, i -> i - 1).limit(15).forEach(System.out::println);

    //2. Generate infinite stream by generate, using a supplier (takes nothing, returns something)

    Stream.generate(new Random() :: nextInt).limit(10).forEach(System.out::println);
  }
}

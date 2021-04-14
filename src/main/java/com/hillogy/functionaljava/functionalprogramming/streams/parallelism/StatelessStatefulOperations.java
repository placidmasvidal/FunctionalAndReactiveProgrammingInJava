package com.hillogy.functionaljava.functionalprogramming.streams.parallelism;

import java.util.List;
import java.util.stream.Collectors;

public class StatelessStatefulOperations {

  public static void main(String[] args) {

    //Stateless Operations do not need any kind of outside information
    //Stateful Operations uses outside information

    //In Javadoc, you can see if any java method is stateless or stateful operation

    List<Integer> list = List.of(1,2,4,5,6,7,9);

    List<Integer> collect = list
            .parallelStream()   //we should avoid use parallel here because skip and limit are stateful
            .skip(2)  //skip is stateful
            .limit(5) //limit is stateful
            .collect(Collectors.toList());


  }
}

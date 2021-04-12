package com.hillogy.functionaljava.functionalprogramming.streams.introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObservingTheStream {

  public static void main(String[] args) {

    List<Book> books = new ArrayList<>();

    //Stream Pipeline
    List<Book> popularHorrorBooks =
        books.stream()  //source
            .filter((book) -> book.getGenre().equalsIgnoreCase("Horror")) //intermediate operation
            .filter((book) -> book.getRating() > 3) //intermediate operation
            .collect(Collectors.toList());  //terminal operation

    //Step 1. Source, a stream
    Stream<Book> stream = books.stream();

    //Step 2. Intermediate operation, gets a stream and returns a stream
    Stream<Book> horrorBooks = stream.filter((book) -> book.getGenre().equalsIgnoreCase("Horror"));

    //Step 2. Intermediate operation, gets a stream and returns a stream
    Stream<Book> pHorrorBooks = stream.filter((book) -> book.getRating() > 3);

    //Step 3. Terminal operation, no side effects
    pHorrorBooks.collect(Collectors.toList());

  }
}

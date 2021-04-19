package com.hillogy.functionaljava.functionalprogramming.listsetmap.list;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListFunctionalOperations {

  public static void main(String[] args) {

    List<Movie> movies =
        Arrays.asList(
            new Movie("Spotlight", 2015, "Hollywood"),
            new Movie("Avengers: Infinity War", 2018, "Hollywood"),
            new Movie("Inception", 2010, "Hollywood"),
            new Movie("Forest Gump", 1994, "Hollywood"),
            new Movie("3 Idiots", 2009, "Bollywood"),
            new Movie("Beauty and the beast", 2017, "Hollywood"),
            new Movie("Slumdog Millionaire", 2008, "Bollywood"));

    // TRAVERSAL

    movies.forEach(System.out::println);

    System.out.println("\n----------------\n");

    // SORTING
    movies.sort((obj1, obj2) -> obj2.getReleaseYear() - obj1.getReleaseYear());
    movies.forEach(System.out::println);

    System.out.println("\n----------------\n");

    // FILTER

    movies.stream()
        .filter(movie -> movie.getIndustry().equalsIgnoreCase("Bollywood"))
        .forEach(System.out::println);

    System.out.println("\n----------------\n");

    // MAPPING

    movies.stream().map(movie -> movie.getName()).forEach(System.out::println);

    System.out.println("\n----------------\n");

    // REDUCE

    Optional<String> moviesString = movies.stream()
            .map(movie -> movie.getName())
            .reduce((m1, m2) -> m1 + " | " + m2);

    System.out.println(moviesString);
  }
}

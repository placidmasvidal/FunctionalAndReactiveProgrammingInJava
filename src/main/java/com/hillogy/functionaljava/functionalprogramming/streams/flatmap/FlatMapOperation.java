package com.hillogy.functionaljava.functionalprogramming.streams.flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOperation {

  public static void main(String[] args) {

    Stream<String> a = Stream.of("Hello ", "there! ");
    Stream<String> b = Stream.of("Learning ", "Java? ");

    Stream<Stream<String>> c = Stream.of(a, b);

    Stream<String> flatMap = Stream.of(a, b).flatMap(e -> e);

    Path p =
        Paths.get(
            "src/main/java/com/hillogy/functionaljava/functionalprogramming/streams/flatmap/random_generated_text.txt");
    try (Stream<String> linesFromFile = Files.lines(p);) {

      List<String> collect = linesFromFile
              .flatMap(line -> Arrays.stream(line.split(" ")))
              .collect(Collectors.toList());

      collect.forEach(System.out::println);

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}

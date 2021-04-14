package com.hillogy.functionaljava.functionalprogramming.streams.spliterator.customspliterator;

import com.hillogy.functionaljava.functionalprogramming.streams.introduction.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadingObjectsFromFile {

  public static void main(String[] args) {

    Path path =
        Paths.get(
            "src/main/java/com/hillogy/functionaljava/functionalprogramming/streams/spliterator/customspliterator/Books.txt");
    try (Stream<String> lines = Files.lines(path); ) {

      // we are going to use the already present spliterator used to stream the lines
      // to customize it to get our custom spliterator
      Spliterator<String> baseSpliterator = lines.spliterator(); // get the lines spliterator
      Spliterator<Book> bookSpliterator = new BookSpliterator(baseSpliterator);

      Stream<Book> stream = StreamSupport.stream(bookSpliterator, false);
      stream.forEach(System.out::println);

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}

package com.hillogy.functionaljava.functionalprogramming.collectors.cascadingcollectors;

import com.hillogy.functionaljava.functionalprogramming.collectors.Employee;
import com.hillogy.functionaljava.functionalprogramming.collectors.analogouscollectors.EmployeeSpliterator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.nio.file.Files.lines;

public class DownstreamCollectors {

  public static void main(String[] args) {

    Path path =
        Paths.get(
            "src/main/java/com/hillogy/functionaljava/functionalprogramming/collectors/analogouscollectors/EmployeeData.txt");
    try (Stream<String> lines = lines(path); ) {

      Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
      Spliterator<String> wordSpliterator = words.spliterator();
      Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

      List<Employee> employeeList =
          StreamSupport.stream(employeeSpliterator, false).collect(Collectors.toList());

      Map<String, Long> countByDesignation =
          employeeList.stream()
              .collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.counting()));
      System.out.println(countByDesignation);

      Map<String, Double> funDistribution =
          employeeList.stream()
              .collect(
                  Collectors.groupingBy(
                      e -> e.getDesignation(), Collectors.summingDouble(e -> e.getSalary())));
      System.out.println(funDistribution);

      Map<String, Optional<Employee>> maxSalaryEmployees =
          employeeList.stream()
              .collect(
                  Collectors.groupingBy(
                      e -> e.getDesignation(),
                      Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
      System.out.println(maxSalaryEmployees);

      Map<String, Optional<Double>> maxSalaries =
          employeeList.stream()
              .collect(
                  Collectors.groupingBy(
                      e -> e.getDesignation(),
                      Collectors.mapping(
                          e -> e.getSalary(),
                          Collectors.maxBy(Comparator.comparing(sal -> sal)))));
// unknown error                         Collectors.maxBy(Comparator.comparing(Function.identity())))));
      System.out.println(maxSalaries);


    } catch (IOException e) {
      System.out.println(e);
    }
  }
}

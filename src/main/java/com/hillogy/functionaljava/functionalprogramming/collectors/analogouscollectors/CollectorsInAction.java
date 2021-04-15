package com.hillogy.functionaljava.functionalprogramming.collectors.analogouscollectors;

import com.hillogy.functionaljava.functionalprogramming.collectors.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.nio.file.Files.*;

public class CollectorsInAction {

  public static void main(String[] args) {

    Path path =
        Paths.get(
            "src/main/java/com/hillogy/functionaljava/functionalprogramming/collectors/analogouscollectors/EmployeeData.txt");
    try (Stream<String> lines = lines(path); ) {

      Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
      Spliterator<String> wordSpliterator = words.spliterator();
      Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

      Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

      //      employees.forEach(System.out::println);

      List<Employee> employeeList = employees.collect(Collectors.toList());

      List<String> employeeNames =
          employeeList.stream().map(employee -> employee.getName()).collect(Collectors.toList());

      Set<String> employeeDesignations =
          employeeList.stream()
              .map(employee -> employee.getDesignation())
              .collect(Collectors.toSet());

      System.out.println("--- SET: Employee Designations ---");
      employeeDesignations.forEach(System.out::println);
      System.out.println("");
      System.out.println("--- LIST: Employee Names ---");
      employeeNames.forEach(System.out::println);

      TreeSet<Employee> employeesSorted =
          employeeList.stream()
              //              .collect(Collectors.toCollection(() -> new TreeSet()));
              .collect(Collectors.toCollection(TreeSet::new));

      System.out.println("--- TREE SET: Employee ---");
      employeesSorted.forEach(System.out::println);

      Map<Integer, String> getNameById =
          employeeList.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));

      System.out.println(getNameById);

      Map<Boolean, List<Employee>> partitionedByGender =
          employeeList.stream().collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));

      System.out.println("--- MAPPED BY GENDER: Employee ---");
      System.out.println(partitionedByGender);

      List<Employee> maleEmployees = partitionedByGender.get(true);
      List<Employee> femaleEmployees = partitionedByGender.get(false);

      Map<String, List<Employee>> getByDesignation =
          employeeList.stream().collect(Collectors.groupingBy(e -> e.getDesignation()));
      System.out.println("--- MAPPED BY DESIGNATION: Employee ---");
      System.out.println(getByDesignation);

      String employeeNamesString =
          employeeList.stream().map(e -> e.getName()).collect(Collectors.joining(","));
      System.out.println("--- STRING WITH ALL NAMES ---");
      System.out.println(employeeNamesString);

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}

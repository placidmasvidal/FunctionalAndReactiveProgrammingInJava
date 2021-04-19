package com.hillogy.functionaljava.functionalprogramming.listsetmap.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapFunctionalOperations {

  public static void main(String[] args) {

    Map<String, String> contacts = new HashMap<>();
    contacts.put("1237589020", "John");
    contacts.put("1237009020", "John");
    contacts.put("7890291111", "Neal");
    contacts.put("2647210290", "Raju");
    contacts.put("9999999999", "Peter");
    contacts.put("9081234567", "Neha");

    // TRAVERSAL

    /*    for (Map.Entry<String, String> entry : contacts.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }*/

    contacts.forEach((k, v) -> System.out.println(k + " - " + v));

    System.out.println("\n----------------\n");

    // SORTING

    LinkedHashMap<String, String> sortedContacts =
        contacts.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(
                Collectors.toMap(
                    c -> c.getKey(), c -> c.getValue(), (v1, v2) -> v1, LinkedHashMap::new));

    sortedContacts.forEach((k, v) -> System.out.println(k + " - " + v));

    System.out.println("\n----------------\n");

    // FILTER

    contacts.entrySet().stream()
        .filter(contact -> contact.getValue().startsWith("N"))
        .forEach(System.out::println);

    System.out.println("\n----------------\n");

    Map<String, String> contactsStartingWithN =
        contacts.entrySet().stream()
            .filter(contact -> contact.getValue().startsWith("N"))
            .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));

    System.out.println(contactsStartingWithN);

    System.out.println("\n----------------\n");

    // MAP

    Set<String> contactNames =
        contacts.entrySet().stream().distinct().map(c -> c.getValue()).collect(Collectors.toSet());

    System.out.println(contactNames);

    System.out.println("\n----------------\n");

    // REDUCE

    Map<String, Double> marks = new HashMap<>();
    marks.put("Science", 66.00);
    marks.put("Maths", 78.00);
    marks.put("English", 90.00);

    OptionalDouble average = marks.values().stream()
            .mapToDouble(m -> m)
            .average();

    System.out.println(average);
  }
}

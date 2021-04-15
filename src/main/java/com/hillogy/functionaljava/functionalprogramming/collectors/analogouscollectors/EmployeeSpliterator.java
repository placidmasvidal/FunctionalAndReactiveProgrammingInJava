package com.hillogy.functionaljava.functionalprogramming.collectors.analogouscollectors;

import com.hillogy.functionaljava.functionalprogramming.collectors.Employee;

import java.sql.Date;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EmployeeSpliterator implements Spliterator<Employee> {

  private int id;
  private String name;
  private char gender;
  private Date dob;
  private String city;
  private String designation;
  private Date joiningDate;
  private double salary;

  private Spliterator<String> wordSpliterator;

  public EmployeeSpliterator(Spliterator<String> wordSpliterator) {
    this.wordSpliterator = wordSpliterator;
  }

  @Override
  public boolean tryAdvance(Consumer<? super Employee> action) {
    if (this.wordSpliterator.tryAdvance(id -> this.id = Integer.valueOf(id))
        && this.wordSpliterator.tryAdvance(name -> this.name = name)
        && this.wordSpliterator.tryAdvance(gender -> this.gender = gender.charAt(0))
        && this.wordSpliterator.tryAdvance(dob -> this.dob = Date.valueOf(dob))
        && this.wordSpliterator.tryAdvance(city -> this.city = city)
        && this.wordSpliterator.tryAdvance(designation -> this.designation = designation)
        && this.wordSpliterator.tryAdvance(
            joiningDate -> this.joiningDate = Date.valueOf(joiningDate))
        && this.wordSpliterator.tryAdvance(salary -> this.salary = Double.valueOf(salary))) {

      action.accept(
          new Employee(
              this.id,
              this.name,
              this.gender,
              this.dob,
              this.city,
              this.designation,
              this.joiningDate,
              this.salary));
      return true;
    }

    return false;
  }

  @Override
  public Spliterator<Employee> trySplit() {
    return null;
  }

  @Override
  public long estimateSize() {
    return wordSpliterator.estimateSize()/8;
  }

  @Override
  public int characteristics() {
    return wordSpliterator.characteristics();
  }
}

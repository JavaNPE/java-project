package com.hediancha.java3;


import com.hediancha.java2.Employee;
import com.hediancha.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Dali
 * @Date 2021/8/10 17:30
 * @Version 1.0
 * @Description
 */
public class StreamAPITest2 {

    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        System.out.println("***************************");

        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 5000);
        System.out.println(anyMatch);
        System.out.println("***************************");

        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);
        System.out.println("***************************");

        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);
        System.out.println("***************************");

        Optional<Employee> employee1 = employees.parallelStream().findAny();
        System.out.println(employee1);
    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        System.out.println("***************************");

        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);
        System.out.println("***************************");
        Optional<Double> maxSalary1 = employees.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(maxSalary1);

        System.out.println("***************************");

        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);
        System.out.println("***************************");

        employees.stream().forEach(System.out::println);
        System.out.println("***************************");

        employees.forEach(System.out::println);
    }


    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("**************************");
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sumMoney = salaryStream.reduce((d1, d2) -> d1 + d2);
        System.out.println(sumMoney.get());
    }


    @Test
    public void test4() {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println("***************************");

        employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("***************************");

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);


    }
}

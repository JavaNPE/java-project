package com.hediancha.java3;


import com.hediancha.java2.Employee;
import com.hediancha.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author Dali
 * @Date 2021/8/10 15:29
 * @Version 1.0
 * @Description
 */
public class StreamAPITest {
    //创建 Stream方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        System.out.println(stream);

        System.out.println("********************");

        Stream<Employee> employeeStream = employees.parallelStream();
        System.out.println(employeeStream);
    }

    //创建 Stream方式二：通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);
        System.out.println(stream);

        System.out.println("********************");
        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建 Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        System.out.println(stream);
    }

    //创建 Stream方式四：创建无限流
    @Test
    public void test4() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        System.out.println("**********************************");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}

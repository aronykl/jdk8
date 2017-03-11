package com.shengsiyuan.jdk8.stream2;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

/**
 *
 * @Author: zhouwen
 * @Date: 2017/3/7 21:14
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wanglu", 100);
        Student student4 = new Student("zhaoliu", 80);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        List<Student> students1 = students.stream().collect(toList());

        students1.forEach(System.out::println);

        System.out.println("----------------");

        System.out.println("count: " + students1.stream().collect(counting()));
        System.out.println("count: " + students1.stream().count());

        System.out.println("----------------");

        students1.stream().collect(minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        students1.stream().collect(maxBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        System.out.println(students1.stream().collect(averagingInt(Student::getScore)).doubleValue());
        System.out.println(students1.stream().collect(summingInt(Student::getScore)));
        IntSummaryStatistics intSummaryStatistics = students1.stream().collect(summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);

        System.out.println("----------------");

        System.out.println(students.stream().map(Student::getName).collect(joining()));
        System.out.println(students.stream().map(Student::getName).collect(joining(", ")));

        System.out.println("----------------");

        Map<Integer, Map<String, List<Student>>> resultMap = students.stream().
                collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(resultMap);

        System.out.println("----------------");

        Map<Boolean, List<Student>> map = students.stream().collect(partitioningBy(student -> student.getScore() > 80));
        System.out.println(map);

        System.out.println("----------------");

        Map<Boolean, Map<Boolean, List<Student>>> map1 = students.stream().
                collect(partitioningBy(student -> student.getScore() > 80, partitioningBy(student -> student.getScore() > 90)));
        System.out.println(map1);

        System.out.println("----------------");

        Map<String, Student> map2 = students.stream().
                collect(groupingBy(Student::getName, collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)),
                        Optional::get)));
        System.out.println(map2);

    }


}

package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/7 21:54
 */
public class StreamTest13 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 30);
        Student student3 = new Student("wangwu", 80, 30);
        Student student4 = new Student("zhangsan", 70, 50);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        System.out.println(list.stream().collect(Collectors.groupingBy(Student::getName)));

        System.out.println(list.stream().collect(Collectors.groupingBy(Student::getAge)));

        System.out.println(list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting())));

        StreamTest13 streamTest13 = new StreamTest13();
        streamTest13.changeStudent(student1);

        System.out.println(student1.getAge());
        System.out.println(student1.getName());
        System.out.println(student1.getScore());

    }

    public void changeStudent(Student student) {
        student.setAge(0);
        student.setName("zhaoliu");
        student.setScore(0);
    }
}

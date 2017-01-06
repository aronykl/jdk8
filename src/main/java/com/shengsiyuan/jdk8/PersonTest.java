package com.shengsiyuan.jdk8;

import javax.jnlp.PersistenceService;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/1/6 17:34
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);

        PersonTest test = new PersonTest();
        List<Person> personResult = test.getPersonsByUsername("zhangsan", persons);
        personResult.forEach(person -> System.out.println(person.getUsername()));

        List<Person> personResult2 = test.getPersonsByAge(25, persons);
        personResult2.forEach(person -> System.out.println(person.getUsername()));

        List<Person> personResult3 = test.getPersonsByAge2(20, persons, (age, personList) ->
            personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList())
        );
        personResult3.forEach(person -> System.out.println(person.getUsername()));
    }

    public List<Person> getPersonsByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(username)).
                collect(Collectors.toList());
    }

    public List<Person> getPersonsByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) ->
                persons.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonsByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }
}

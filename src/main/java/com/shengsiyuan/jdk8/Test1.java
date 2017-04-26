package com.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2016/12/19 22:48
 */
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        System.out.println("-----------------------");
//
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//
//        System.out.println("-----------------------");

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("-----------------------");

        list.forEach(integer -> {
            System.out.println(integer);
        });

        System.out.println("-----------------------");
        // methodreference references方法引用创建函数式接口的对象（）
        list.forEach(System.out::println);

        System.out.println(list.indexOf(8));
        Test1 test1 = new Test1();

        int test = 2;
        test1.test(test);
        System.out.println("-----------------------");
        System.out.println(test);

    }

    public void test(int test) {
        test = 1;
    }
}

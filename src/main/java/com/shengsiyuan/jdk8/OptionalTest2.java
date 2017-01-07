package com.shengsiyuan.jdk8;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/1/7 13:03
 */
public class OptionalTest2 {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee1 = new Employee();
        employee1.setName("lisi");

        Company company = new Company();
        company.setName("company1");
//        company.setEmployees(Arrays.asList(employee, employee1));

        Optional<Company> optional = Optional.ofNullable(company);

        System.out.println(optional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));


        System.out.println(optional.flatMap(theCompany -> Optional.ofNullable(theCompany.getEmployees())).orElse(Collections.emptyList()));
    }
}

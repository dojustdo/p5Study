package com.study.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxq
 * @title: Employee
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/28 16:00
 */
public class Employee {

    public void checkNumberOfCourse() {
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courses.add(new Course());
        }
        System.out.println(courses.size());
    }

}

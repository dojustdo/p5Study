package com.study.design.principle.simpleresponsibility.clazz;

/**
 * @author dxq
 * @title: Course
 * @projectName reflex
 * @description: 类的单一职责原则
 * @date 2020/5/28 14:42
 */
public class Course {
    public void study(String args) {
        if ("直播课".equals(args)) {
            System.out.println("不能快进");
        } else {
            System.out.println("可以任意回放");
        }
    }
}

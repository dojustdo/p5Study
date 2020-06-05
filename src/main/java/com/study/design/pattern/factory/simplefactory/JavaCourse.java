package com.study.design.pattern.factory.simplefactory;

/**
 * @author dxq
 * @title: JavaCourse
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 10:52
 */
public class JavaCourse implements ICourse {

    @Override
    public void ready() {
        System.out.println("准备java课程");
    }
}

package com.study.design.pattern.factory.simplefactory;

/**
 * @author dxq
 * @title: PythonCourse
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 10:53
 */
public class PythonCourse implements ICourse {
    @Override
    public void ready() {
        System.out.println("准备Python课程");
    }
}

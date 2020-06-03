package com.study.design.pattern.factory.factorymethond;

/**
 * @author dxq
 * @title: JavaFactory
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 14:40
 */
public class JavaFactory implements CourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}

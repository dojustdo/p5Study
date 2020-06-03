package com.study.design.pattern.factory.factorymethond;

/**
 * @author dxq
 * @title: PythonFactory
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 14:42
 */
public class PythonFactory implements CourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}

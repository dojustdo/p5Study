package com.study.design.pattern.factory.abstractfactory;

/**
 * @author dxq
 * @title: PythonCourse
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 10:53
 */
public class PythonCourse extends CourseFactory {

    @Override
    protected INote createNote() {
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        return new PythonVideo();
    }
}

package com.study.design.pattern.factory.abstractfactory;

/**
 * @author dxq
 * @title: JavaVideo
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 17:20
 */
public class JavaCourse extends CourseFactory {

    @Override
    protected INote createNote() {
        super.init();
        return new JavaNote();
    }

    @Override
    protected IVideo createVideo() {
        return new JavaVideo();
    }
}

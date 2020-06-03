package com.study.design.pattern.factory.abstractfactory;

/**
 * @author dxq
 * @title: CourseFactory
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 10:54
 */
public abstract class CourseFactory {
    public void init() {
        System.out.println("初始化");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();
}

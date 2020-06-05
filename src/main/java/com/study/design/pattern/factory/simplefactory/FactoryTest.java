package com.study.design.pattern.factory.simplefactory;

/**
 * @author dxq
 * @title: FactoryTest
 * @projectName reflex
 * @description: 工厂模式demo
 * @date 2020/6/2 10:50
 */
public class FactoryTest {
    /**
     * 工厂模式来实现对象的创建
     * 只需要传入工厂类的参数，对于如何创建对象的逻辑不需要关心。
     *
     * @param args
     */
    public static void main(String[] args) {
        ICourse iCourse = new CourseFactory().create(JavaCourse.class);
        iCourse.ready();
    }
}

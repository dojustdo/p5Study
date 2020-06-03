package com.study.design.pattern.factory.factorymethond;

/**
 * @author dxq
 * @title: FactoryTest
 * @projectName reflex
 * @description: 工厂方法模式demo
 * @date 2020/6/2 10:50
 */
public class FactoryTest {
    /**
     * 工厂方法让类的实列化推迟到子类中进行
     *
     * @param args
     */
    public static void main(String[] args) {
        ICourse iCourse = new JavaFactory.create();
        iCourse.ready();
    }
}

package com.study.design.pattern.factory.abstractfactory;

/**
 * @author dxq
 * @title: AbstractTest
 * @projectName reflex
 * @description: 抽象工厂demo
 * @date 2020/6/2 17:12
 */
public class AbstractTest {
    /**
     * 不依赖于产品实列如何被创建，实现等细节。
     * 强调一系列相关的产品对象（属于同一产品族）一起使用创建对象需要大量重复代码。
     * 提供一个产品类的库，所有产品以同样的接口出现，从而使客户端不依赖于具体实现。
     *
     * @param args
     */
    public static void main(String[] args) {
        CourseFactory factory = new JavaCourse();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}

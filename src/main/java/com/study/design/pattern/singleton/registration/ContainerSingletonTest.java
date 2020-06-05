package com.study.design.pattern.singleton.registration;

/**
 * @author dxq
 * @title: ContainerSingletonTest
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/5 10:24
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object o = ContainerSingleton.getInstance("com.study.design.pattern.singleton.registration.Pojo");
        System.out.println(o);
    }

}

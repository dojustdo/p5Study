package com.study.design.pattern.singleton.registration;

import com.study.design.pattern.singleton.registration.EnumSingleton;

/**
 * @author dxq
 * @title: EnumSingletonTest
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/5 10:03
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.setData(new Object());
        System.out.println(enumSingleton);
    }
}

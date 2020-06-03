package com.study.design.pattern.singleton;

/**
 * @author dxq
 * @title: HungryStaticSingleton
 * @projectName reflex
 * @description: 饿汉式单列模式的另外一种写法
 * @date 2020/6/3 16:15
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON;

    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {

    }

    private static HungryStaticSingleton getInstance() {
        return HUNGRY_STATIC_SINGLETON;
    }

}

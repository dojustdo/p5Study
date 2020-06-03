package com.study.design.pattern.singleton;

/**
 * @author dxq
 * @title: HungrySingleton
 * @projectName reflex
 * @description: 饿汉式单例模式
 * @date 2020/6/3 16:02
 */
public class HungrySingleton {
    /**
     * 确保一个类在任何情况下都绝对只有一个实列，并提供一个全局访问点
     * 优点：执行效率高，性能高，没有任何锁
     * 缺点：某些情况下，可能会造成内存浪费
     *
     */
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {
    }

    public HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }
}

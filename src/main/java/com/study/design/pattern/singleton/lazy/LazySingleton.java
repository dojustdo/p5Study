package com.study.design.pattern.singleton.lazy;

/**
 * @author dxq
 * @title: LazySingleton
 * @projectName reflex
 * @description: 懒汉式单例模式
 * @date 2020/6/3 16:43
 */
public class LazySingleton {
    /**
     * 优点：节省了内存资源
     * 缺点： 线程不安全，（用锁则性能变差）
     */
    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    public synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}

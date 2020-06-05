package com.study.design.pattern.singleton.lazy;

/**
 * @author dxq
 * @title: LazySingleton
 * @projectName reflex
 * @description: 懒汉式单例模式 双重检查锁
 * @date 2020/6/3 16:43
 */
public class LazyDoubleCheckSingleton {
    /**
     * 优点：性能提升上来了
     * 缺点：可读性差，不够优雅
     */
    // volatile 解决指令重排序的问题
    private volatile static LazyDoubleCheckSingleton lazySingleton;

    private LazyDoubleCheckSingleton() {
    }

    public LazyDoubleCheckSingleton getInstance() {
        // 检测是否要阻塞
        if (lazySingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                // 检查是否要重新创建实列
                if (lazySingleton == null) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }

}

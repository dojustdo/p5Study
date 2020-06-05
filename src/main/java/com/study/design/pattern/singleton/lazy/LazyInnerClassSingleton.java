package com.study.design.pattern.singleton.lazy;

/**
 * @author dxq
 * @title: LazyInnerClassSingleton
 * @projectName reflex
 * @description: 懒汉式 内部内单列
 * @date 2020/6/4 10:27
 */
public class LazyInnerClassSingleton {
    /**
     * 类加载的时候并不会加载内部类
     * classPath：LazyInnerClassSingleton.class
     * LazyInnerClassSingleton$LazyHolder.class
     * 优点：写法优雅，利用了java本身语法特点，性能高，避免了内存浪费
     * 缺点：能够被反射破坏
     */
    private LazyInnerClassSingleton() {
    }

    public static LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }
}

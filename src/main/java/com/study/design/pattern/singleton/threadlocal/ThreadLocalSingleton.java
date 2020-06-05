package com.study.design.pattern.singleton.threadlocal;

/**
 * @author dxq
 * @title: ThreadLocalSingleton
 * @projectName reflex
 * @description: ThreadLocal单例模式
 * @date 2020/6/5 11:33
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> INSTANCE = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return INSTANCE.get();
    }
}

package com.study.design.pattern.singleton.threadlocal;

/**
 * @author dxq
 * @title: ThreadLocalSingletonTest
 * @projectName reflex
 * @description: 测试
 * @date 2020/6/5 11:39
 */
public class ThreadLocalSingletonTest {
    /**
     * 保证线程内部的全局唯一，线程天生安全
     * ThreadLocal 内部是一个map，已当前线程做一个key
     * 所以说ThreadLocal对每一个线程都是唯一的
     */
    public static void main(String[] args) {
        ThreadLocalSingleton s1 = ThreadLocalSingleton.getInstance();
        Thread thread = new Thread(() -> {
            System.out.println(ThreadLocalSingleton.getInstance());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(ThreadLocalSingleton.getInstance());
        });
        thread.start();
        thread2.start();
        System.out.println(s1);
    }

}

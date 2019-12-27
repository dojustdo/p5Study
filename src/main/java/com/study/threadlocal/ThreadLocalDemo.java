package com.study.threadlocal;

/**
 * @author dxq
 * @title: ThreadLocalDemo
 * @projectName 线程安全分析
 * @description: ThreadLocal 隔离线程
 * @date 2019/12/27 9:20
 */
public class ThreadLocalDemo {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        //demo.noThreadLocal();
        demo.useThreaLocal();
    }

    public static int num = 0;

    /**
     * 多个线程共享变量，存在有序性问题。
     * 线程顺序随机
     */
    public void noThreadLocal() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                num += 5;
                System.out.println(Thread.currentThread().getName() + "->" + num);
            }, "Thread" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    /**
     * 使用threadLocal
     * 线程隔离
     */
    public void useThreaLocal() {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                int num = threadLocal.get();
                num += 5;
                threadLocal.set(num);
                System.out.println(Thread.currentThread().getName() + "->" + num);
            }, "ThreadLocal" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

package com.study.volatiledemo;

/**
 * @author dxq
 * @title: VolatileDemo
 * @projectName 线程安全分析
 * @description: volatile 解决可见性，有序性问题，实际为jvm的lock指令
 * @date 2019/12/26 14:31
 */
public class VolatileDemo {
    /**
     * 如果没加上 volatile 关键字
     * thread线程就感知不到stop变量的变化
     */
    public volatile static boolean stop = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (stop) {
                i++;
            }
            System.out.println(i);
        });
        thread.start();
        System.out.println("main begin ");
        Thread.sleep(1000);
        stop = false;
    }
}

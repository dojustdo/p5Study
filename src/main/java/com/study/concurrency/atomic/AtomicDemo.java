package com.study.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dxq
 * @title: AtomicDemo
 * @projectName 线程安全分析
 * @description: 原子类Atomic
 * @date 2019/12/26 19:16
 */
public class AtomicDemo {


    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void incr() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {

        }
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::incr).start();
        }
        Thread.sleep(4000);
        System.out.println("result" + atomicInteger.get());
    }

}

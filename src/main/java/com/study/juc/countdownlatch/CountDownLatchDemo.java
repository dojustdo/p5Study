package com.study.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author dxq
 * @title: CountDownLatchDemo
 * @projectName JUC 同步工具类
 * @description: 线程倒数
 * @date 2019/12/27 21:00
 */
public class CountDownLatchDemo {

    /**
     * 倒数三个线程
     */
    public static CountDownLatch countDownLatch = new CountDownLatch(3);

    /**
     * 可用来指定某个或多个任务，在特定的另一个任务之前执行
     * 它允许一个或多个线程一直等待，直到其它线程执行完毕
     * 初始化倒数三个线程
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            countDownLatch.countDown();
        }).start();
        try {
            // 主线程的阻塞状态在倒数完毕后被唤醒
            countDownLatch.await();
            System.out.println("倒数完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

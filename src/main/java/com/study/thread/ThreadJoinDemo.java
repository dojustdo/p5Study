package com.study.threadJoinDemo;

import javax.sound.midi.Soundbank;

/**
 * @author dxq
 * @title: ThreadJoinDemo
 * @projectName reflex
 * @description: 线程demo
 * @date 2019/12/24 10:46
 */
public class ThreadJoinDemo {
    public static int i = 1;
    public static int x = 2;

    // Thread.join 等待状态,保证线程执行结果的可见性
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            i = 3;
        });

        Thread t2 = new Thread(() -> {
            i = x + 2;
        });

        t1.start();
        try {
            // 阻塞主线程，必须t1线程执行完成，再唤醒
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        System.out.println("result" + i);
    }
}

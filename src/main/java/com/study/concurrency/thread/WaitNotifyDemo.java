package com.study.concurrency.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dxq
 * @title: WaitNotifyDemo
 * @projectName 线程
 * @description: 线程的 wait notify通信demo
 * @date 2019/12/25 10:03
 */
public class WaitNotifyDemo {

    /**
     * wait notify本质上是一种条件竞争
     * 通过synchronized实现互斥。
     * 既然它们是一个通信，那就需要一个载体，
     * 就是用synchronized 来实现的，保持两者在同一个频道，同一个锁的范围。
     */
    public static void main(String[] args) {
        int count = 10;
        Queue<String> bags = new LinkedList<>();
        Producter producter = new Producter(count, bags);
        Saller saller = new Saller(count, bags);
        Thread thread = new Thread(producter,"producter");
        Thread thread1 = new Thread(saller,"saller");
        thread.start();
        thread1.start();
    }
}

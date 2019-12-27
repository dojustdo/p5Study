package com.study.thread;

import java.util.Queue;

/**
 * @author dxq
 * @title: Producter
 * @projectName 线程
 * @description: 生产者
 * @date 2019/12/25 10:14
 */
public class Producter implements Runnable {
    public int count;
    public Queue<String> bags;

    public Producter(int count, Queue<String> bags) {
        this.count = count;
        this.bags = bags;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            synchronized (bags) {
                System.out.println(Thread.currentThread().getName() + "启动时间是" + System.currentTimeMillis());
                if (bags.size() == count) {
                    System.out.println("bags已经满了");
                    try {
                        bags.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String bag = "bag" + i;
                System.out.println("生产了bag" + i);
                bags.add(bag);
                bags.notifyAll();
            }
        }
    }
}

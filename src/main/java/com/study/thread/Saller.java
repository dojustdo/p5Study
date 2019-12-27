package com.study.thread;

import java.util.Queue;

/**
 * @author dxq
 * @title: Saller
 * @projectName 线程
 * @description: 销售者
 * @date 2019/12/25 10:14
 */
public class Saller implements Runnable {
    public int count;
    public Queue<String> bags;

    public Saller(int count, Queue<String> bags) {
        this.count = count;
        this.bags = bags;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (bags) {
                System.out.println(Thread.currentThread().getName() + "启动时间是" + System.currentTimeMillis());

                while (bags.isEmpty()) {
                    System.out.println("bag已经售空了");
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
                String bag = bags.remove();
                System.out.println("售出：" + bag);
                bags.notifyAll();
            }
        }
    }
}

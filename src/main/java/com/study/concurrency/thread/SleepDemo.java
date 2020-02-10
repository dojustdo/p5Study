package com.study.concurrency.thread;

/**
 * @author dxq
 * @title: sleepDemo
 * @projectName 线程
 * @description: Thread.sleep
 * @date 2019/12/24 11:09
 */
public class SleepDemo extends Thread {

    /**
     * 超时等待设置的1000毫秒，并不是一定准时的1000毫秒。
     * 可能当前进程并未执行完
     * 可能当前进程并不是优先级最高的线程
     */
    @Override
    public void run() {
        System.out.println("start:" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
            System.out.println("end:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

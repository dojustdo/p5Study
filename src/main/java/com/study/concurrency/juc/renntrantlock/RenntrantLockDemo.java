package com.study.concurrency.juc.renntrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dxq
 * @title: RenntrantLockDemo
 * @projectName JUC 核心
 * @description: 重入锁
 * @date 2019/12/27 16:19
 */
public class RenntrantLockDemo {
    public static int count = 0;

    /**
     * 继承了 AbstractQueuedSynchronizer
     * 对多线程，排队，阻塞，唤醒的处理
     * 可多解读源码
     */
    public static Lock lock = new ReentrantLock();

    /**
     * 锁，保证了原子性
     * 一个持有锁的线程，在释放锁之前，如果再次访问加了该同步锁的其它方法，
     * 这个线程不用再次挣抢锁，只需要记录重入次数。
     * 如果不是重入锁，会出现同一个线程抢占了锁，等自己解锁的死锁情况
     */
    public static void incr() {
        try {
            // 锁
            lock.lock();
            count++;
            // 如果不是重入锁，同一个线程就会是死锁
            decr();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    public static void decr() {
        lock.lock();
        count--;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(RenntrantLockDemo::incr).start();
        }
        Thread.sleep(4000);
        System.out.println("result" + count);
    }
}

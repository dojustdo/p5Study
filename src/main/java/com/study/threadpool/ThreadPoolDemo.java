package com.study.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dxq
 * @title: ThreadPoolDemo
 * @projectName 线程池
 * @description: java 中线程池的使用
 * @date 2019/12/28 14:40
 */
public class ThreadPoolDemo implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolDemo poolDemo = new ThreadPoolDemo();
        // 固定线程数量线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 固定一个线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 根据实际情况创建线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        poolDemo.doing(cachedThreadPool);
    }


    public void doing(ExecutorService executorService) {
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThreadPoolDemo());
        }
    }
}

package com.study.concurrency.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dxq
 * @title: ThreadPoolDemo
 * @projectName 线程池
 * @description: 有返回值的线程使用处理
 * @date 2019/12/28 14:40
 */
public class CallableFutureDemo implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("hello");
        return "hello";
    }

    public static void main(String[] args) {
        CallableFutureDemo demo = new CallableFutureDemo();
        FutureTask futureTask = new FutureTask(demo);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

package com.study.concurrency.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author dxq
 * @title: ImporFIle
 * @projectName reflex
 * @description: TODO
 * @date 2019/12/28 11:29
 */
public class ImporFIle extends Thread {

    private String path;

    private CyclicBarrier cyclicBarrier;

    public ImporFIle(String path,CyclicBarrier cyclicBarrier) {
        this.path = path;
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        System.out.println("导入文件"+path);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}

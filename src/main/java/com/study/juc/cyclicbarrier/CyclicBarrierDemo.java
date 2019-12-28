package com.study.juc.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author dxq
 * @title: CyclicBarrier
 * @projectName JUC
 * @description: CyclicBarrier 让一组线程达到一个屏障时被阻塞
 * @date 2019/12/28 11:13
 */
public class CyclicBarrierDemo extends Thread {

    @Override
    public void run() {
        System.out.println("上游任务完成，最后处理");
    }

    public static void main(String[] args) {
        // 等待三个线程
        // 注意如果未达到三个线程，会一直等待
        // cyclicBarrier.await(time,timeUnit) 设置超时解锁时间
        // 或reset
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CyclicBarrierDemo());

        new ImporFIle("path1", cyclicBarrier).start();
        new ImporFIle("path2", cyclicBarrier).start();
        new ImporFIle("path3", cyclicBarrier).start();
    }

}

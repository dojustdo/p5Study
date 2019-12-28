package com.study.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author dxq
 * @title: SemaphoreDemo
 * @projectName JUC
 * @description: semaphore 信号灯，线程限流
 * @date 2019/12/28 9:33
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 五个许可，限流五个
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();
        }
    }

    static class Car extends Thread {
        private int num;

        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                // 获取许可，信号灯作用，可用才进入
                semaphore.acquire();
                System.out.println(num + "号车停入车位");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(num + "号车走了");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

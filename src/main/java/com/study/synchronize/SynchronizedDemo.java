package com.study.synchronize;

/**
 * @author dxq
 * @title: SynchronizedDemo
 * @projectName reflex
 * @description: synchronized 同步锁
 * @date 2019/12/25 17:41
 */
public class SynchronizedDemo {

    /**
     * 对象锁运行demo
     */
    public void runDemo() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();

        new Thread(() -> {
            synchronizedDemo.demo("第一个线程");
        }).start();

        // 与第一个线程并不是同一个实列对象，锁不生效
        new Thread(() -> {
            synchronizedDemo1.demo("第二个线程");
        }).start();

        // 与第一个线程是同一个实列对象，锁生效所以是互斥的
        // 先处于阻塞状态，等第一个线程执行完再执行
        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronizedDemo.demo("第三个线程");
        }).start();
    }

    /**
     * 静态方法对象锁运行demo3
     */
    public void runDemo3() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();

        new Thread(() -> {
            synchronizedDemo.demo3("第一个线程");
        }).start();

        // 与第一个线程并不是同一个实列对象，锁也生效
        new Thread(() -> {
            synchronizedDemo1.demo3("第二个线程");
        }).start();

        // 与第一个线程是同一个实列对象，锁生效所以是互斥的
        // 先处于阻塞状态，等第一个线程执行完再执行
        new Thread(() -> {
            synchronizedDemo.demo3("第三个线程");
        }).start();
    }

    /**
     * 对象锁
     * 作用在方法上
     */
    public synchronized void demo(String out) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(out);
    }

    /**
     * 作用在代码块
     */
    public void demo2() {
        // 对象锁
        synchronized (this) {

        }
    }

    public void demo4() {
        // 类级别锁
        synchronized (SynchronizedDemo.class) {

        }
    }

    /**
     * 静态方法的类级别锁
     * 作用在方法上
     */
    public synchronized static void demo3(String out) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(out);
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        // 互斥在于它所争抢的资源
//        demo.runDemo();
        demo.runDemo3();
    }
}

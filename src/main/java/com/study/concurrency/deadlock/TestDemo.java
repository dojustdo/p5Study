package com.study.concurrency.deadlock;

/**
 * @author dxq
 * @title: TestDemo
 * @projectName p5study
 * @description: TODO
 * @date 2019/12/28 22:19
 */
public class TestDemo {
    public static void main(String[] args) {
        Account account = new Account("张三", 10000);
        Account account1 = new Account("李四", 20000);
        AllLock allLock = new AllLock();

        new Thread(new TransferDemo(account, account1, 1, allLock)).start();
        new Thread(new TransferDemo(account1, account, 2, allLock)).start();
    }
}

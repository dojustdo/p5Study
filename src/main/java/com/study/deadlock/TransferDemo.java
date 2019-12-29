package com.study.deadlock;

import lombok.Data;

/**
 * @author dxq
 * @title: TransferDemo
 * @projectName p5study
 * @description: 交易
 * @date 2019/12/28 21:58
 */
@Data
public class TransferDemo implements Runnable {

    private Account fromAccount;

    private Account toAccount;

    private double amount;

    private AllLock allLock;

    public TransferDemo(Account fromAccount, Account toAccount, double amount, AllLock allLock) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.allLock = allLock;
    }

    @Override
    public void run() {
        while (true) {
            // 要抢占两个资源，会出现死锁。
        /*synchronized (fromAccount) {
            synchronized (toAccount) {
                if (fromAccount.getBalance() >= amount) {
                    fromAccount.debit(amount);
                    toAccount.credebit(amount);
                }
                System.out.println(fromAccount.getName() + "--转出---" + fromAccount.getBalance());
                System.out.println(toAccount.getName() + "--到帐---" + toAccount.getBalance());
            }
        }*/

            // 合并成一个资源 不会出现死锁
            if (allLock.apply(fromAccount, toAccount)) {

                try {
                    synchronized (fromAccount) {
                        synchronized (toAccount) {
                            if (fromAccount.getBalance() >= amount) {
                                fromAccount.debit(amount);
                                toAccount.credebit(amount);
                                System.out.println(fromAccount.getName() + "--转出---" + fromAccount.getBalance());
                                System.out.println(toAccount.getName() + "--到帐---" + toAccount.getBalance());
                            }
                        }
                    }
                } finally {
                    allLock.free(fromAccount, toAccount);
                }
            }
        }
    }
}

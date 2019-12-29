package com.study.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxq
 * @title: AllLock
 * @projectName p5study
 * @description: TODO
 * @date 2019/12/28 22:26
 */
public class AllLock {
    List<Account> accounts = new ArrayList<>();

    /**
     * 申请资源
     *
     * @param fromAccount
     * @param toAccount
     * @return
     */
    synchronized boolean apply(Account fromAccount, Account toAccount) {
        if (accounts.contains(fromAccount) || accounts.contains(toAccount)) {
            return false;
        } else {
            accounts.add(fromAccount);
            accounts.add(toAccount);
            return true;
        }
    }

    /**
     * 释放资源
     */
    synchronized void free(Account fromAccount, Account toAccount) {
        accounts.remove(fromAccount);
        accounts.remove(toAccount);
    }

}

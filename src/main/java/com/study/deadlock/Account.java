package com.study.deadlock;

import lombok.Data;

/**
 * @author dxq
 * @title: 死锁问题 - 账户
 * @projectName p5study
 * @description: 账户信息
 * @date 2019/12/28 21:03
 */
@Data
public class Account {

    private String name;

    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void debit(double amount) {
        balance -= amount;
    }

    public void credebit(double amount) {
        balance += amount;
    }

}
package com.study.concurrency.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author dxq
 * @title: ForkJoinDemo
 * @projectName 多线程拓展
 * @description: fork/join 并行执行任务,将一个任务分成多个任务，提高性能。
 * @date 2019/12/29 15:38
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    // 分割的阔值, 分割规则
    private final int THREHOLD = 2;
    private int start;
    private int end;


    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        Integer sum = 0;
        boolean canCompute = (end - start) <= THREHOLD;
        if (canCompute) {
            System.out.println("start:" + start + "  end:" + end);
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            left.fork();
            right.fork();
            Integer leftResult = (Integer) left.join();
            Integer rightResult = (Integer) right.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1, 10);
        Future<Integer> future = forkJoinPool.submit(forkJoinDemo);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

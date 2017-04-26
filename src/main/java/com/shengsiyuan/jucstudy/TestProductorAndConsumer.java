package com.shengsiyuan.jucstudy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用juc Lock 完成生产者消费者问题
 * @Author: zhouwen
 * @Date: 2017/3/17 23:04
 */
public class TestProductorAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(productor, "生产者 A").start();
        new Thread(consumer, "消费者 A").start();

        new Thread(productor, "生产者 B").start();
        new Thread(consumer, "消费者 B").start();
    }
}

class Clerk {
    private int product;

    private Lock lock = new ReentrantLock();

    private Condition cond = lock.newCondition();

//    private Condition nullCond = lock.newCondition();

    public void get() {
        lock.lock();
        try {
            while (product >= 1) {
//                System.out.println("产品已满！！！");
                try {
                    cond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + ++product);
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void sale() {
        lock.lock();
        try {
            while (product <= 0) {
//                System.out.println("产品已空！！！");
                try {
                    cond.await();
                } catch (Exception e) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + --product);
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}
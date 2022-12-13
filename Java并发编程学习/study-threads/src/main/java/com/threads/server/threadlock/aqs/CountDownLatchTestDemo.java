package com.threads.server.threadlock.aqs;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 类位于 java.util.concurrent 包下，利用它可以实现类似计数器的功能。比如有
 * 一个任务 A，它要等待其他 4 个任务执行完毕之后才能执行，此时就可以利用 CountDownLatch
 * 来实现这种功能了。
 */
public class CountDownLatchTestDemo {
    static final CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            }
        }.start();

        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            }
        }.start();
        System.out.println("等待 2 个子线程执行完毕...");
        latch.await();
        System.out.println("2 个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    }
}

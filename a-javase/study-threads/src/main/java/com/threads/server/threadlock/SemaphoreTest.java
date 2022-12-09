package com.threads.server.threadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 〈〉
 *
 * @author luo_zm
 * @create 2019-7-23
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程:" + Thread.currentThread().getName() + "进入,当前已有" + (3 - sp.availablePermits()) + "并发");
                    try {
                        Thread.sleep((long) Math.random() * 10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程:" + Thread.currentThread().getName() + "即将离开");
                    sp.release();
                    System.out.println("线程:" + Thread.currentThread().getName() + "已离开,当前已有" + (3 - sp.availablePermits()) + "并发");
                }
            };
            executorService.execute(runnable);
        }
    }
}


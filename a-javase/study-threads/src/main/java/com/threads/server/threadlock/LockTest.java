package com.threads.server.threadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈线程锁测试〉
 *
 * @author luo_zm
 * @create 2019-7-1
 */
public class LockTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    OutPuter.out("helloWorld");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    OutPuter.out("Worldhello");
                }
            }
        }).start();
    }

    static class OutPuter {
        static Lock lock = new ReentrantLock();

        public static void out(String name) {
            int length = name.length();
            lock.lock();
            try {
                for (int i = 0; i < length; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }
}


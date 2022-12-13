package com.threads.server.thread;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Thread.yield()方法作用是：暂停当前正在执行的线程对象（及放弃当前拥有的cup资源），
 * 并执行其他线程。yield()做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其
 * 他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
 * 但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 * 结论：
 * yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状
 * 态转到可运行状态，但有可能没有效果。
 * <p>
 * suspend()和resume()方法
 * 不推荐使用 suspend() 去挂起线程的原因，是因为 suspend() 在导致线程暂停的同时，并不会去释放任何锁资源。其他线程都无法访问被它占用的锁。
 * 直到对应的线程执行 resume() 方法后，被挂起的线程才能继续，从而其它被阻塞在这个锁的线程才可以继续执行。
 * 但是，如果 resume() 操作出现在 suspend() 之前执行，那么线程将一直处于挂起状态，同时一直占用锁，这就产生了死锁。而且，对于被挂起的线程，它的线程状态居然还是 Runnable。
 */
public class ThreadOne {
    public static void main(String[] args) throws InterruptedException {
        Thread.yield();//Thread的静态native方法。 yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。


        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1:" + Thread.currentThread().getName());
                    System.out.println("this:" + this.getName());
                }
            }
        };
        thread.start();
        if (1 == 1) {
            thread.interrupt();
        }

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2:" + Thread.currentThread().getName());
                }
            }
        });
        thread2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Runnable:" + Thread.currentThread().getName());
                }
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread:" + Thread.currentThread().getName());
                }
            }
        }.start();
    }
}


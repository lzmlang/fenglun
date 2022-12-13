package com.threads.server.threadlock.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 罗泽民
 * @description
 * @date 2022/12/6 17:28
 */
public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock();
    //Lock lock=new ReentrantLock(true);//公平锁
    //Lock lock=new ReentrantLock(false);//非公平锁
    private Condition condition = lock.newCondition();//创建 Condition

    public void testMethod() {
        try {
            lock.lock();//lock 加锁
//1：wait 方法等待：
            //System.out.println("开始 wait");
            condition.await();
//通过创建 Condition 对象来使线程 wait，必须先执行 lock.lock 方法获得锁
//:2：signal 方法唤醒
            condition.signal();//condition 对象的 signal 方法可以唤醒 wait 线程
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


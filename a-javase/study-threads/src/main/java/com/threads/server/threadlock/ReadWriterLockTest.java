package com.threads.server.threadlock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 〈读写锁〉
 *
 * @author luo_zm
 * @create 2019-7-1
 */
public class ReadWriterLockTest {
    public static void main(String[] args) {
        final Queue1 queue1 = new Queue1();
        Runnable runnable = () -> {
            while (true) {
                queue1.get();
            }
        };
        Runnable runnable2 = () -> {
            while (true) {
                queue1.put(new Random().nextInt(10000));
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
            new Thread(runnable2).start();
        }

    }
}

class Queue1 {
    private Object data;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "ready to read data");
            Thread.sleep(new Random().nextInt(2000));
            System.out.println(Thread.currentThread().getName() + "read data " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }

    public void put(Object data) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "ready to writer data");
            Thread.sleep(new Random().nextInt(2000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "writer data " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }
}

//关于读写锁的一些应用
class CachedData {
    ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData() {
        return new Object();
    }

    public void userDate(Object data) {
        System.out.println(data.toString());
    }

    void processCacheData() {
        rwl.readLock().lock();
        Object data = getData();
        if (data == null) {
            //满足条件
            rwl.readLock().unlock();

            rwl.writeLock().lock();
            try {
                //给data赋值,实际业务中去数据库查询
                data = getData();
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock();// Unlock write, still hold read

            }
        }
        try {
            //把数据给其他业务逻辑使用
            userDate(data);
        } finally {
            rwl.readLock().unlock();
        }
    }
}

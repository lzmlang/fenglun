package com.threads.server.threadlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈〉
 *
 * @author luo_zm
 * @create 2019-7-2
 */
public class ConditionCummuncation {

    public static void main(String[] args) {
        Bussiness bussiness = new Bussiness();
        Bussiness2 bussiness2 = new Bussiness2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 50; i++) {
                    bussiness2.sub(i);
                }
            }
        });
        thread1.setName("子线程");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 50; i++) {
                    bussiness2.main(i);
                }
            }
        });
        thread2.setName("主线程");
        thread2.start();
    }
}

//要用到的共同的数据(包括同步锁)或共同的算法的若干个方法应该归在同一个类身上,这种设计正好提心了高内聚和程序的健壮性
class Bussiness {
    private boolean flag = true;

    public synchronized void sub(int i) {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j <= 10; j++) {
            System.out.println(Thread.currentThread().getName() + i + "次" + "loop of" + j);
        }
        flag = false;
        this.notify();//通知其他线程当前锁以打开,可以进来获取锁的对象
    }

    public synchronized void main(int i) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j <= 15; j++) {
            System.out.println(Thread.currentThread().getName() + i + "次" + "loop of" + j);
        }
        flag = true;
        this.notify();
    }
}

//锁和condition方式是到线程阻塞的目的
class Bussiness2 {
    private boolean flag = true;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void sub(int i) {
        lock.lock();
        try {

            while (!flag) {
                try {
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j <= 10; j++) {
                System.out.println(Thread.currentThread().getName() + i + "次" + "loop of" + j);
            }
            flag = false;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void main(int i) {
        lock.lock();
        try {


            while (flag) {
                try {
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j <= 15; j++) {
                System.out.println(Thread.currentThread().getName() + i + "次" + "loop of" + j);
            }
            flag = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}


package com.threads.server.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈子线程循环10次,接着主线程循环100次.接着又回到子线程10次,接着再回到主线程100,如此循环50次〉
 *
 * @author luo_zm
 * @create 2019-6-10
 */
public class TraditionalThreadCommunication {
    //原子自增类,当一个线程持有改对象时.可以对其他线程互斥
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        Bussiness bussiness = new Bussiness();
        for (int i = 0; i < 20; i++) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    //for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "  atomicInteger before " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + "  atomicInteger after " + atomicInteger.get());
                    // }
                }
            });
            thread1.start();

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    //for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "  atomicInteger before " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + "  atomicInteger  after " + atomicInteger.get());
                    //}
                }
            });
            thread2.start();
        }

    }

    /*public static void main(String[] args) {
        Bussiness bussiness = new Bussiness();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 50; i++) {
                    bussiness.sub(i);
                }
            }
        });
        thread1.setName("子线程");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 50; i++) {
                    bussiness.main(i);
                }
            }
        });
        thread2.setName("主线程");
        thread2.start();
    }*/

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
        this.notify();//通知其他线程当前锁以打开,可以进来获取锁的对象.必须在synchronized同步的监视器内使用
    }

    public synchronized void main(int i) {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j <= 100; j++) {
            System.out.println(Thread.currentThread().getName() + i + "次" + "loop of" + j);
        }
        flag = true;
        this.notify();
    }
}


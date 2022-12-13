package com.threads.server.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 〈线程共享变量,同一个线程调用多个程序,几个程序之间共享的是同一个线程中的变量.〉
 *
 * @author luo_zm
 * @create 2019-6-10
 */
public class ThreadScopeShareData {
    public static int data = 0;
    //将需要共享的变量设置成类的成员变量
    public static Map<Thread, Integer> map = new HashMap<Thread, Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    map.put(Thread.currentThread(), data);
                    System.out.println(Thread.currentThread().getName() + "has put data:" + data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                int data = new Random().nextInt();
                map.put(Thread.currentThread(),data);
                System.out.println(Thread.currentThread().getName() + "has put data:" + map.get(Thread.currentThread()));
                new A().get();
                new B().get();
            }
        }).start();*/
    }

    static class A {
        public void get() {
            int data = map.get(Thread.currentThread());
            System.out.println("A from" + Thread.currentThread().getName()
                    + "get data:" + data);
        }
    }

    static class B {
        public void get() {
            int data = map.get(Thread.currentThread());
            System.out.println("B from" + Thread.currentThread().getName()
                    + "get data:" + data);
        }
    }
}


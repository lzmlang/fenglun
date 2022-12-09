package com.threads.server.threadlock;

/**
 * @author 罗泽民
 * @description Synchronized实现原理
 * @date 2022/12/4 11:06
 */
public class SynchronizedByteClass {
    Object objMonitor = new Object();

    public synchronized static void method2() {
        System.out.println("Hello synchronized 2");
    }

    public static void main(String[] args) {
    }

    public synchronized void method1() {
        System.out.println("Hello synchronized 1");
    }

    public void method3() {
        synchronized (objMonitor) {
            System.out.println("Hello synchronized 2");
        }
    }

    public void method4() {
        synchronized (objMonitor) {
            System.out.println("Hello synchronized 2");
            throw new RuntimeException();
        }
    }
}

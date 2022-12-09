package com.threads.server.thread;

/**
 * 程序中可以直接使用 thread.stop()来强行终止线程，但是 stop 方法是很危险的，就象突然关
 * 闭计算机电源，而不是按正常程序关机一样，可能会产生不可预料的结果，不安全主要是：
 * thread.stop()调用之后，创建子线程的线程就会抛出 ThreadDeatherror 的错误，并且会释放子
 * 线程所持有的所有锁。
 * 一般任何进行加锁的代码块，都是为了保护数据的一致性，如果在调用
 * thread.stop()后导致了该线程所持有的所有锁的突然释放(不可控制)，那么被保护数据就有可能呈
 * 现不一致性，其他线程在使用这些被破坏的数据时，有可能导致一些很奇怪的应用程序错误。因
 * 此，并不推荐使用 stop 方法来终止线程。
 */
public class ThreadStopTest {
    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadSafe.interrupt();
    }

    public static class ThreadSafe extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) { //非阻塞过程中通过判断中断标志来退出
                try {
                    Thread.sleep(1 * 1000);//阻塞过程捕获中断异常来退出
                    System.out.println("waiting for interrupted()");
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println("捕获InterruptedException来退出循环");

                    break;//捕获到异常之后，执行 break 跳出循环
                }
            }
        }
    }
}

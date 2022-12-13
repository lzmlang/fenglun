package com.threads.server.threadlock.aqs;

/**
 * @author 罗泽民
 * @description
 * @date 2022/12/6 17:12
 */
public class NonReentrantLockDemoTest {
    private static NonReentrantLock nonReentrantLock = new NonReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                nonReentrantLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    nonReentrantLock.unlock();
                }
            });
            thread.start();
        }
    }
}

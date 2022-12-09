package com.threads.server.threadlock;

/**
 * @author 罗泽民
 * @description
 * @date 2022/12/4 11:49
 */
public class VolatileTest implements Runnable {
    public static volatile int count = 0;

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        Thread t1 = new Thread(vt);
        Thread t2 = new Thread(vt);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);//结果应该⼩于等于200000。问题就出现在 count++ 这个操作不是原⼦性。
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            count++;
            count = count + 1;//这个等同于count++，可以用javap -v 编译一下class文件
        }
    }
}

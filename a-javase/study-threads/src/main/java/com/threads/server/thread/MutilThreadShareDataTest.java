package com.threads.server.thread;

/**
 * 〈多线程共享变量测试.设计4个线程.其中两个线程每次对j增加1,另外两个线程每次减一,主要目的是多个线程操作同一个变量〉
 *
 * @author luo_zm
 * @create 2019-6-30
 */
public class MutilThreadShareDataTest {
    private static ShareData1 shareData1 = new ShareData1();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new MyRunnable1(shareData1)).start();
            new Thread(new MyRunnable2(shareData1)).start();
        }
    }

    //方式二:一个类实现一个runnable接口,将共享类设为外部类的一个成员属性.
    //实现类
    static class MyRunnable1 implements Runnable {
        private ShareData1 shareData1;

        public MyRunnable1(ShareData1 shareData1) {
            this.shareData1 = shareData1;
        }

        @Override
        public void run() {
            //while (true){
            shareData1.increment();
            // }
        }
    }

    static class MyRunnable2 implements Runnable {
        private ShareData1 shareData1;

        public MyRunnable2(ShareData1 shareData1) {
            this.shareData1 = shareData1;
        }

        @Override
        public void run() {
            //while (true){
            shareData1.decrement();
            // }
        }
    }


    /*public static void main(String[] args) {
        ShareData1 data1 = new ShareData1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // while (true) {
                data1.decrement();
                //  }
            }
        }) {
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // while (true) {
                data1.increment();
                // }
            }
        }) {
        }.start();
    }*/
    //共享类
    static class ShareData1 {
        //方式一:定义一个类中的两个方法都用synchronized关键字修饰,并且都是用同一个成员变量
        private int j = 100;

        public synchronized void increment() {
            j++;
            System.out.println(Thread.currentThread().getName() + "j++=" + j);
        }

        public synchronized void decrement() {
            j--;
            System.out.println(Thread.currentThread().getName() + "j--=" + j);
        }
    }
}


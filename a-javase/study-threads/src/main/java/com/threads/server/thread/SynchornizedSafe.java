package com.threads.server.thread;

/**
 * 〈多线程的安全问题〉
 *
 * @author luo_zm
 * @create 2019-6-2
 */
public class SynchornizedSafe {
    public static void main(String[] args) {
        new SynchornizedSafe().init();

    }

    private void init() {
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.outPut("helloshuaige");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Outputer.outPut3("hellomeinv");
                }
            }
        }).start();
    }

    static class Outputer {
        String s = "";

        public void outPut(String name) {
            if (name.length() == 0) {
                System.out.println("参数为空");
            }
            //加上这个synchronized(s)或者(this)关键字的代码可以维护多线程的安全问题,效果和outPut2是一样的
            //加上这个synchronized(Outputer.class)这样的效果才是和outPut3是一样的
            synchronized (this) {
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    System.out.print(name.charAt(i));
                }
                //打印空格
                System.out.println();
            }
        }

        //要实现线程的同步安全也可以在方法上面加上synchronized关键字,这样表示当前方法的锁对象是this(this代表的是当前对象)
        public synchronized void outPut2(String name) {
            if (name.length() == 0) {
                System.out.println("参数为空");
            }
            //在这个方法中加上synchronized(this)可能会出现死锁的情况
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();

        }

        /**
         * 此时,要实现线程的同步安全也可以在方法上面加上synchronized关键字,
         * 这样表示当前方法的锁对象是OutPuter.class(代表的是当前对象字节码文件)
         * 静态方法的优先级是在当前对象被创建之前就有的,在这之前最开始的加载的是class文件(字节码文件)
         */
        public static synchronized void outPut3(String name) {
            if (name.length() == 0) {
                System.out.println("参数为空");
            }
            //加上这个synchronized关键字的代码可以产生互斥反应
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();

        }
    }
}


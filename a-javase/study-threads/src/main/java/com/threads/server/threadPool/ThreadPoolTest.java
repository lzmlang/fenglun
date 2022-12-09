package com.threads.server.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈〉
 *
 * @author luo_zm
 * @create 2019-6-30
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);//线程池的大小需要给定
        ExecutorService executorService1 = Executors.newCachedThreadPool();//动态线程池,根据你提叫的任务数量开多少量的线程
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();//只有一个线程的线程池(可以解决如何实现线程死掉后重新启动一个新线程?)
        for (int j = 0; j < 10; j++) {
            final int task = j;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "loop of " + i + "fro " + task);
                    }
                }
            });
        }
        executorService.shutdown();//执行完提交到线程池招中所有的方法后才关闭
        // executorService.shutdownNow();//执行完一次提交的任务就关闭线程池

        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("boming");
            }
        }, 5, TimeUnit.SECONDS);//5秒之后执行一次
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("boming");
            }
        }, 5, 2, TimeUnit.SECONDS);//5秒之后执行第一次,之后每隔两秒执行一次
    }
}


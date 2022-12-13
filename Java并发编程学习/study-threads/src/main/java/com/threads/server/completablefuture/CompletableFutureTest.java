package com.threads.server.completablefuture;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author luo_zm
 * @DESCRIPTION
 * @create 2020/9/14 12:23
 */
public class CompletableFutureTest {
    //    public static ExecutorService executor = Executors.newFixedThreadPool(10);
    //手动创建线程池
    public static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thead-cs-Bearing-%d").build();
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), threadFactory);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果" + i);
//        }, excutor);

//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//            int i = 10 / 0;
//            System.out.println("运行结果" + i);
//            return i;
//        }, excutor).whenComplete((res, exception) -> {
//            //虽然能得到异常信息,但是没有办法修改返回的数据
//            System.out.println("异步任务完成了...结果是:" + res + ";出现的异常是:" + exception);
//        }).exceptionally(throwable -> {
//            return 10;
//        });
        //捕获异常
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程" + Thread.currentThread().getId() + Thread.currentThread().getName());
            int i = 10 / 0;
            System.out.println("运行结果" + i);
            return i;
        }, executor).handle((res, exception) -> {
            if (res != null) {
                return res;
            }
            if (exception != null) {
                return 0;
            }
            return -1;
        });
        System.out.println("main方法结束:" + future1.get());
        executor.shutdown();
    }
}

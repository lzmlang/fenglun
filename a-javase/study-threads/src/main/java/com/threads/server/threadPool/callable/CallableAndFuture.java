package com.threads.server.threadPool.callable;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 〈〉
 *
 * @author luo_zm
 * @create 2019-7-1
 */
public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.execute();//此方法执行任务不需要返回结果如果需要返回结果就用submit()方法
        Future<String> future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws InterruptedException {
                Thread.sleep(2000);
                return "hello world";
            }
        });
        System.out.println("waitting for result");
        System.out.println("get result" + future.get());
        executorService.shutdown();
        //提交一组任务给callable<T>然后返回Future<T>到CompletionService中
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService2);
        for (int i = 0; i < 10; i++) {
            final int acount = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws InterruptedException {
                    Thread.sleep(new Random().nextInt(5000));
                    return acount;
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(completionService.take().get());
        }
        executorService2.shutdown();
    }
}


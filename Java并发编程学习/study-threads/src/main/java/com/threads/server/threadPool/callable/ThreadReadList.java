package com.threads.server.threadPool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 〈〉<br>
 *
 * @author luo_zm

 * @create 2019/8/15
 * @since 1.0.0
 */
public class ThreadReadList {

    static final int THREAD_SIZE = 10;

    public static void main(String[] args) {
        threadPoolForList();
    }


    private static void threadPoolForList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        // 推送游戏开始
        long start = System.currentTimeMillis();
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / THREAD_SIZE + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % THREAD_SIZE == 0;
        // 创建一个线程池
        ExecutorService executorPool = Executors.newFixedThreadPool(threadNum);
        // 定义一个任务集合
        List<Callable<String>> tasks = new ArrayList<Callable<String>>();
        Callable<String> task = null;
        List<Integer> cutList = null;
        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(THREAD_SIZE * i, dataSize);
            } else {
                cutList = list.subList(THREAD_SIZE * i, THREAD_SIZE * (i + 1));
            }
            List<Integer> userList = cutList;
            task = new BearingCallable(userList);
            tasks.add(task);
        }
        try {
            //invokeAll 可以提交多个任务，在任务完成前该方法会阻塞，直到所有任务完成或中断或超时，返回Future列表。
            List<Future<String>> results = executorPool.invokeAll(tasks);
            results.forEach(
                    e -> {
                        try {
                            System.out.println(e.get());
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
            );
        } catch (Exception e) {
            System.out.println(e.getMessage() + new RuntimeException("消息模板推送出现错误!!!"));
        } finally {
            // 关闭线程池
            executorPool.shutdown();
        }
        System.out.println("执行任务结束>>>消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }

}

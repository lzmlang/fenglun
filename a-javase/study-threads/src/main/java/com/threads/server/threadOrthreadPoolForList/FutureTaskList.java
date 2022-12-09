package com.threads.server.threadOrthreadPoolForList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 〈〉<br>
 *
 * @author luo_zm
 * @company 潭州教育网络科技有限公司
 * @create 2019/8/15
 * @since 1.0.0
 */
public class FutureTaskList {

    static final int THREAD_SIZE = 1000;

    public static void main(String[] args) {
        //threadPoolForList();
        listForeach2();
    }

    private static void listForeach2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
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
        List<Integer> cutList = null;
        List<List<Integer>> dataList = new ArrayList<>();
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
            dataList.add(cutList);
        }
        dataList.stream().forEach(list1 -> {
            WechatTemplateTask wechatTemplateTask = new WechatTemplateTask(list1.get(0), list1);
            new Thread(wechatTemplateTask).start();
        });
        System.out.println(Thread.currentThread().getName() + ":执行任务结束>>>消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    private static void threadPoolForList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
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
            final List<Integer> userList = cutList;
            task = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("time:" + System.currentTimeMillis() + "--thread name:" + Thread.currentThread().getName() + "--线程：" + userList.size());
                    userList.stream().forEach(intNum -> {
                        System.out.println("time:" + System.currentTimeMillis() + "--thread name:" + Thread.currentThread().getName() + "--线程：" + intNum);

                    });
                    return "SUCCESS";
                }
            };
            tasks.add(task);
        }
        try {
            //invokeAll 可以提交多个任务，在任务完成前该方法会阻塞，直到所有任务完成或中断或超时，返回Future列表。
            List<Future<String>> results = executorPool.invokeAll(tasks);
        } catch (Exception e) {
            System.out.println(e.getMessage() + new RuntimeException("消息模板推送出现错误!!!"));
        } finally {
            // 关闭线程池
            executorPool.shutdown();
        }
        System.out.println("执行任务结束>>>消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }

}

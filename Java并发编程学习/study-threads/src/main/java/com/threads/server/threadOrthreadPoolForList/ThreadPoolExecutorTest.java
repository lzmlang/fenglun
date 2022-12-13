package com.threads.server.threadOrthreadPoolForList;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.threads.server.utils.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈多线程获取list集合对象〉<br>
 *
 * @author luo_zm
 * @company
 * @create 2019/7/29
 * @since 1.0.0
 */
public class ThreadPoolExecutorTest {

    static final int THREAD_SIZE = 200;

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("wechat-send-%d").build();
    //ThreadPoolExecutor的拒绝策略 最后一个参数是拒绝策略
    // 默认的拒绝策略就是AbortPolicy。直接抛出异常。
    //    CallerRunsPolicy在任务被拒绝添加后，会调用当前线程池的所在的线程去执行被拒绝的任务
    //    DiscardOldestPolicy策略的作用是，当任务呗拒绝添加时，会抛弃任务队列中最旧的任务也就是最先加入队列的，再把这个新任务添加进去。
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
            20,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(50),
            build,
            new AbortPolicy());

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/saul/Desktop/4月尚域抖音订单(1).xlsx");
        InputStream inputStream = new FileInputStream(file);
        List<Object[]> objects = ExcelUtils.importExcel(inputStream,0);
        assert objects != null;
        List<String> list = new ArrayList<>();

        for (Object[] datas : objects) {
//            System.out.println(datas[0] + "\t" + datas[1] + "\t" + datas[2]);
            list.add((String) datas[0]);
        }
// 推送游戏开始
        long start = System.currentTimeMillis();
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / THREAD_SIZE + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % THREAD_SIZE == 0;
        List<String> cutList = null;
        List<List<String>> dataList = new ArrayList<>();
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

        for (List<String> tids : dataList) {
            TradeDownOrDeleteTask tradeDownOrDeleteTask = new TradeDownOrDeleteTask("141035", tids);
            threadPoolExecutor.submit(tradeDownOrDeleteTask);
        }
        threadPoolExecutor.shutdown();
    }


    private static void WechatTemplateTaskTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
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

        for (List<Integer> list1 : dataList) {
            WechatTemplateTask wechatTemplateTask = new WechatTemplateTask(1, list1);
            threadPoolExecutor.submit(wechatTemplateTask);
        }
        threadPoolExecutor.shutdown();
    }

    private static void dequeAdd(List<List<Integer>> dataList) {
        BlockingDeque blockingDeque = new LinkedBlockingDeque(1024);
        for (List<Integer> list1 : dataList) {
            list1.stream().forEach(num -> {
                blockingDeque.add(new Runnable() {
                    @Override
                    public void run() {
                        atomicInteger.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + "user--age:" + num);
                        // System.out.println(Thread.currentThread().getName() + "  atomicInteger  after " + atomicInteger.get());
                    }
                });
            });
        }
    }
}

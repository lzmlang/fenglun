package com.threads.server.threadPool.callable;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author luo_zm
 * @DESCRIPTION 施工承载力需要的Callable实现对象
 * @create 2020/2/19 10:50
 */
public class BearingCallable implements Callable<String> {
    private List<Integer> userList;

    public BearingCallable(List<Integer> userList) {
        this.userList = userList;
    }

    @Override
    public String call() {
        System.out.println("time:" + System.currentTimeMillis() + "--thread name:" + Thread.currentThread().getName() + "--遍历数组大小：" + userList.size());
        userList.stream().forEach(intNum -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("time:" + System.currentTimeMillis() + "--thread name:" + Thread.currentThread().getName() + "--数字为：" + intNum);

        });
        return "SUCCESS";
    }
}

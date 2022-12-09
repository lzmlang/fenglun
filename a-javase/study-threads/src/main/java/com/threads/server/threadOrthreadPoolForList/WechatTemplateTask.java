package com.threads.server.threadOrthreadPoolForList;

import java.util.List;

/**
 * 〈〉<br>
 *
 * @author luo_zm
 * @company
 * @create 2019/8/15
 * @since 1.0.0
 */
public class WechatTemplateTask implements Runnable {

    private List list;
    private int i;

    private WechatTemplateTask() {

    }

    public WechatTemplateTask(int i, List list) {
        this.i = i;
        this.list = list;
    }

    public static WechatTemplateTask getInstance(int i, List list) {
        WechatTemplateTask wechatTemplateTask = new WechatTemplateTask(i, list);
        return wechatTemplateTask;
    }

    @Override
    public void run() {
        System.out.println("time:" + System.currentTimeMillis() + "---thread name:" + Thread.currentThread().getName() + "--需要打印的数量：" + list.size() + "---索引:" + i);
        list.stream().forEach(t -> {
            System.out.println("time:" + System.currentTimeMillis() + "--thread name:" + Thread.currentThread().getName() + "--线程：" + t);
        });
    }
}

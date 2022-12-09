package com.threads.server.timertask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 〈传统的定时任务〉
 *
 * @author luo_zm
 * @create 2019-6-2
 */
public class TimerTastTwo {
    private static int count = 1;

    public static void main(String[] args) {
        //只执行一次的定时任务
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("快乐bug");
            }
        }, 1000);*/
        //第一时间参数是执行一次的定时任务,第二个时间是循环执行
       /* new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("快乐bug");
            }
        }, 3000,2000);*/
        //实现2秒打印一次4秒打印一次交替出现
        class MyTimerTast extends TimerTask {
            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("快乐bug");
                new Timer().schedule(new MyTimerTast(), 2000 + 2000 * count);
            }
        }
        new Timer().schedule(new MyTimerTast(), 2000);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


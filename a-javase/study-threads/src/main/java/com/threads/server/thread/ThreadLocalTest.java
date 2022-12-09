package com.threads.server.thread;

import java.util.Random;

/**
 * 〈ThreadLocal使用〉
 *
 * @author luo_zm
 * @create 2019-6-26
 */
public class ThreadLocalTest {
    public static int data = 0;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    public static ThreadLocal<MyThreadLocalData> mydata = new ThreadLocal<MyThreadLocalData>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        int data = new Random().nextInt();
                        threadLocal.set(data);
                        System.out.println(Thread.currentThread().getName() + "has put data:" + data);
                   /* MyThreadLocalData myThreadLocalData = new MyThreadLocalData();
                    myThreadLocalData.setName("name"+data);
                    myThreadLocalData.setAge(data);*/
                        MyThreadLocalData instance = MyThreadLocalData.getInstance();
                        instance.setAge(data);
                        instance.setName("name:" + data);
                        new A().get();
                        new B().get();
                 /*   Thread.State state = Thread.currentThread().getState();
                    System.out.println("state:"+state);
                    boolean alive = Thread.currentThread().isAlive();
                    System.out.println("isalive:"+alive);
*/
                    } catch (Exception e) {

                    } finally {
                        //前面所有的程序都执行完成.执行最终的finally这个时候可以说明线程将要死亡
                        System.out.println(Thread.currentThread().getName() + "i will death");
                    }
                }
            }).start();

        }
    }

    static class A {
        public void get() {
            int data = threadLocal.get();
            System.out.println("A from" + Thread.currentThread().getName() + "get data:" + data);
           /* MyThreadLocalData myThreadLocalData = mydata.get();
            String name = myThreadLocalData.getName();
            Integer age = myThreadLocalData.getAge();
            System.out.println("A from" + Thread.currentThread().getName() + "get myThreadLocalData--name:" + name + "---age:" + age);*/

            Integer age = MyThreadLocalData.getInstance().getAge();
            String name = MyThreadLocalData.getInstance().getName();
            System.out.println("A from" + Thread.currentThread().getName() + "get myThreadLocalData--name:" + name + "---age:" + age);
        }
    }

    static class B {
        public void get() {
            int data = threadLocal.get();
            System.out.println("B from" + Thread.currentThread().getName() + "get data:" + data);
            /* MyThreadLocalData myThreadLocalData = mydata.get();
            String name = myThreadLocalData.getName();
            Integer age = myThreadLocalData.getAge();
            System.out.println("A from" + Thread.currentThread().getName() + "get myThreadLocalData--name:" + name + "---age:" + age);*/
            Integer age = MyThreadLocalData.getInstance().getAge();
            String name = MyThreadLocalData.getInstance().getName();
            System.out.println("B from" + Thread.currentThread().getName() + "get myThreadLocalData--name:" + name + "---age:" + age);
        }
    }

    static class MyThreadLocalData {
        private String name;
        private Integer age;

        //单利模式,私有化构造方法
        private MyThreadLocalData() {
        }

        private static ThreadLocal<MyThreadLocalData> map = new ThreadLocal<>();

        //如果不使用这下面的null的判断的话那就使用synchronized关键字加载getInstance中
        private static MyThreadLocalData getInstance() {
            MyThreadLocalData instance = map.get();

            if (instance == null) {
                instance = new MyThreadLocalData();
                map.set(instance);
            }
            return map.get();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}


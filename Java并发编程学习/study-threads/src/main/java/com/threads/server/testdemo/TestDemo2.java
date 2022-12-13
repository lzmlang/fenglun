package com.threads.server.testdemo;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestDemo2 {
    static int x = 0, y = 0;
    static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        String string2 = "顺丰科技";
        String string = new String("顺丰科技");
        System.out.println(string.equals(string2));
        Integer a = 128;
//        asList();
//        testMAP();
        storeLoad();
    }

    public static void storeLoad() throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });
        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });
        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println(" (" + x + "," + y + ")");
    }

    private static void testMAP() {
        HashMap<String, String> hashMap = new HashMap<String, String>(8, 0.75F);
        for (int i = 1; i < 14; i++) {
            if (i == 12) {
                System.out.println("12了");
            }
            hashMap.put("公司" + i, "company");
        }
        System.out.println(JSON.toJSONString(hashMap));
        Object clone = hashMap.clone();
        System.out.println(JSON.toJSONString(clone));
    }

    public static void asList() {
        String[] str = {"a", "b", "c"};
        List listStr = Arrays.asList(str);
        System.out.println(listStr.size());//3
        int[] i = {1, 2, 3};
        List listI = Arrays.asList(i);
        System.out.println(listI.size());//1
    }


}

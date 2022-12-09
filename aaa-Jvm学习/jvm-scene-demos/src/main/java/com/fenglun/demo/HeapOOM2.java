package com.fenglun.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 罗泽民
 * @description
 * VM args: -Xms30m -Xmx30m -XX:PrintGCDetails
 * @date 2021/12/28 21:23
 */
public class HeapOOM2 {
    public static void main(String[] args) throws Exception {
        List<Object> list = new LinkedList<>();
        int i = 0;
        while (true) {
            i++;
            if (0 == i % 1000) {
                TimeUnit.MILLISECONDS.sleep(10);
            }
            list.add(new Object());
        }
    }

}

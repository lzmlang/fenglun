package com.fenglun.demo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 演示本地内存的溢出
 * VM args： -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class LocalMemoryOOM {
    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);

        Unsafe unsafe = (Unsafe) field.get(null);

        while (true) {
            unsafe.allocateMemory(1024 * 1024);
        }
    }
}

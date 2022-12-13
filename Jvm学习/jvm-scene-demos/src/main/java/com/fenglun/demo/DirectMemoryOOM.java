package com.fenglun.demo;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * 演示直接内存的溢出
 * VM args:-Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        List<ByteBuffer> list = new LinkedList<>();
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024);
            list.add(byteBuffer);
        }

    }
}

package com.fenglun.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 罗泽民
 *先介绍几个JVM参数：
 *
 * -Xms：设置JVM初始堆内存的大小。
 * -Xmx：设置JVM最大堆内存的大小。
 * -Xmn: 设置年轻代的大小、
 * -Xss：设置每个线程对应的栈的大小。
 * -XX:+HeapDumpOnOutOfMemoryError：发生OOM异常时生成heap dump文件
 * -XX:HeapDumpPath=path：heap dump文件生成的路径，例如XX:HeapDumpPath=/var/log/java/java_heapdump.hprof
 * -XX:+PrintGCDetails：打印GC的详细信息。
 * -XX:+PrintGCTimeStamps：打印GC的时间戳。
 * -XX:MetaspaceSize：设置元空间触发垃圾回收的大小。
 * -XX:MaxMetaspaceSize：设置元空间的最大值
 * https://www.csdn.net/tags/NtjaEgxsNzQ3MzctYmxvZwO0O0OO0O0O.html
 *
 *
 * 演示堆的溢出
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\dump\heap.hprof -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * @date 2021/12/28 21:08
 */
public class HeapOOM {
    public static void main(String[] args) {

        List<byte[]> list = new ArrayList<>();

        while (true) {
            list.add(new byte[1024 * 1024]); // 每次增加一个1M大小的数组对象
        }

    }
}

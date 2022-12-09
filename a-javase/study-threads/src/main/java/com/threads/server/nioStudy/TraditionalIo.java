package com.threads.server.nioStudy;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 〈传统io流和FileChannel(NIO)〉
 *
 * @author luo_zm
 * @create 2019-6-25
 */
public class TraditionalIo {
    public static void main(String[] args) {
        method1();
        method2();
    }

    /**
     * 〈nio方式读取文本数据〉
     *
     * @Author: luo_zm
     * @Date: 下午 14:50 下午 14:50
     */
    public static void method1() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("java_threads/src/nio.txt", "rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);

            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 〈传统io流-包装流(字节流)〉
     *
     * @Author: luo_zm
     * @Date: 下午 14:51 下午 14:51
     */
    public static void method2() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("java_threads/src/io.txt"));

            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


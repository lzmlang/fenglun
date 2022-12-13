package com.fenglun.demo;

/**
 * @author 罗泽民
 * VM args：-Xss1m
 * @description
 * @date 2021/12/28 21:24
 */
public class StackSOE {
    private static int index = 1;

    private static void test() {
        index++;
        test();
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable e) {
            System.out.println("Stack deep : " + index);
            e.printStackTrace();
        }
    }
}

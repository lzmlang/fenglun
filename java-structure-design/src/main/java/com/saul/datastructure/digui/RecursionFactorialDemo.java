package com.saul.datastructure.digui;

/**
 * @author 枫伦
 * @DESCRIPTION 阶乘的递归
 * @create 2021/9/23 7:52 下午
 */
public class RecursionFactorialDemo {
    public static void main(String[] args) {
        System.out.println(getFactorialFor(10));
        System.out.println(getFactorialByRecursion(10));
    }
    /**
     * 0！=1  1！=1
     * 负数没有阶乘,如果输入负数返回-1
     *
     * @param n
     * @return
     */
    public static int getFactorialFor(int n) {
        int temp = 1;
        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                temp = temp * i;
            }
        } else {
            return -1;
        }
        return temp;
    }

    /**
     * 0！=1  1！=1
     * 负数没有阶乘,如果输入负数返回-1
     *
     * @param n
     * @return
     */
    public static int getFactorialByRecursion(int n) {
        if (n >= 0) {
            if (n == 0) {
                System.out.println(n + "!=1");
                return 1;
            } else {
                System.out.println(n);
                int temp = n * getFactorialByRecursion(n - 1);
                System.out.println(n + "!=" + temp);
                return temp;
            }
        }
        return -1;
    }
}

package com.saul.datastructure.advance_sorting;

import java.util.Arrays;

/**
 * @author 枫伦
 * @DESCRIPTION 斐波那契数列查询算法
 * 斐波那契查找同样是查找算法家族中的一员，它要求数据是有序的（升序或降序）。斐波那契查找采用和二分查找/插值查找相似的区间分割策略，都是通过不断的分割区间缩小搜索的范围。
 * @create 2022/12/2 5:58 下午
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(fibonacciSearch(array, 7));
    }

    /**
     * 斐波那契查找算法
     *
     * @param arr       查找表
     * @param findValue 目标值
     * @return int  目标值在查找表中的索引
     */
    public static int fibonacciSearch(int[] arr, int findValue) {
        int i = 0;
        int mid;    // 中间值
        int left = 0;   // 区间左端
        int right = arr.length - 1;   // 区间右端

        // 1. 创建斐波那契数列
        int[] fibonacci = getFibonacci(20);
        // 2. 获取斐波那契数列中等于或者第一个大于数组长度的数
        while (fibonacci[i] < arr.length) {
            i++;
        }
        // 3. 按照斐波那契数列中的元素长度拷贝一个查找表
        int[] temp = Arrays.copyOf(arr, fibonacci[i]);
        // 4. 以原查找表最后一个元素补齐临时查找表长度
        for (int j = arr.length; j < temp.length; j++) {
            temp[j] = arr[arr.length - 1];
        }
        // 5. 循环判断
        while (left <= right) {
            mid = left + fibonacci[i - 1] - 1;  // 计算查找点
            if (temp[mid] < findValue) {  // 如果查找点小于目标值，说明在右区间
                left = mid + 1; // 右区间起点
                i -= 2; // 右区间长度是 f[i-2]，所以要把 i 换成 i-2
            } else if (temp[mid] > findValue) {    // 如果查找点大于目标值，说明在左区间
                right = mid - 1; // 左区间终点
                i -= 1; // 左区间长度是 f[i-1]，根据所以要把 i 换成 i-1
            } else {  // 如果相等，说明找到了
                /* 找到存在两种可能：一是找到的是原查找表中的元素，二是找到的是填充值。因此需要判别*/
                if (mid <= right) {  // 如果是原查找表中的元素，直接返回索引
                    return mid;
                } else {  // 如果找到的是填充值，则返回原查找表最后一个索引
                    return right;
                }
            }
        }
        return -1;
    }

    /**
     * 创建斐波那契数列
     *
     * @param maxSize 斐波那契数列长度
     * @return int[]    斐波那契数列
     */
    public static int[] getFibonacci(int maxSize) {
        int[] fibonacci = new int[maxSize];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

}

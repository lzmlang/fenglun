package com.saul.datastructure.sort_algorithm;

import java.util.Arrays;

/**
 * @author 罗泽民
 * @description 排序测试
 * @date 2020/11/15 17:54
 */
public class SortTest {
    public static final int[] arr = {99, 7, 23, 45, 6, 21, 46, 46, 8, 7, 21};

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(BubbleSort.sort(arr)));
//        System.out.println(Arrays.toString(SelectSort.sort(arr)));
        System.out.println(Arrays.toString(InsertSort.sort(arr)));
    }
}

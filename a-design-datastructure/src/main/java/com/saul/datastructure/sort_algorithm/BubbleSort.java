package com.saul.datastructure.sort_algorithm;

/**
 * @author 罗泽民
 * @description 冒泡排序
 * @date 2020/11/15 17:44
 */
public class BubbleSort {
    public static int[] sort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

}

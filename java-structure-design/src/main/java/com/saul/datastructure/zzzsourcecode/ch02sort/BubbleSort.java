package com.saul.datastructure.zzzsourcecode.ch02sort;

/***
 * @DESCRIPTION: 冒泡排序
 * @author 枫伦
 * @params:
 * @return:
 * @Date: 2021/9/8 11:18 上午
 * @Modified By:  
 */
public class BubbleSort {

    public static void sort(long[] arr) {
        long tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }
}

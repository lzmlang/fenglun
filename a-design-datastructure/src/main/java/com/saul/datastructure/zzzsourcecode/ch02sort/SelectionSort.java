package com.saul.datastructure.zzzsourcecode.ch02sort;

/***
 * @DESCRIPTION: 选择排序
 * @author 枫伦
 * @params:
 * @return:
 * @Date: 2021/9/8 11:18 上午
 * @Modified By:  
 */
public class SelectionSort {

    public static void sort(long[] arr) {
        int k = 0;
        long tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            k = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }
    }
}

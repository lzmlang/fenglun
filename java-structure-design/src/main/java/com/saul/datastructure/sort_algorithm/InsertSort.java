package com.saul.datastructure.sort_algorithm;

/**
 * @author 罗泽民
 * @description 插入排序
 * @date 2020/11/15 17:45
 */
public class InsertSort {
    public static int[] sort(int[] array) {
        int j;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];//记录要插入的数据
            j = i;
            while (j > 0 && tmp < array[j - 1]) {//从已经排序的序列最右边的开始比较，找到比其小的数
                array[j] = array[j - 1];//向后挪动
                j--;
            }
            array[j] = tmp;//存在比其小的数，插入
        }
        return array;
    }

}

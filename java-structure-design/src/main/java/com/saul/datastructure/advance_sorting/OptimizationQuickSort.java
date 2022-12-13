package com.saul.datastructure.advance_sorting;

import java.util.Arrays;

/**
 * @author 枫伦
 * @DESCRIPTION 优化快速排序
 * @create 2021/11/10 11:19 上午
 */
public class OptimizationQuickSort {
    //数组array中下标为i和j位置的元素进行交换
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * ⑤、优化分析
     * 　　假设我们是对一个逆序数组进行排序，选取第一个元素作为基准点，即最大的元素是基准点，那么第一次循环，左游标要执行到最右边，而右游标执行一次，然后两者进行交换。这也会划分成很多的子数组。
     * 　　那么怎么解决呢？理想状态下，应该选择被排序数组的中值数据作为基准，也就是说一半的数大于基准数，一般的数小于基准数，这样会使得数组被划分为两个大小相等的子数组，对快速排序来说，拥有两个大小相等的子数组是最优的情况。
     * 　　三项取中划分
     * <p>
     * 　　为了找到一个数组中的中值数据，一般是取数组中第一个、中间的、最后一个，选择这三个数中位于中间的数。
     * <p>
     * 处理小划分
     * 　　如果使用三数据取中划分方法，则必须遵循快速排序算法不能执行三个或者少于三个的数据，如果大量的子数组都小于3个，那么使用快速排序是比较耗时的。联想到前面我们讲过简单的排序（冒泡、选择、插入）。
     * 　　当数组长度小于M的时候（high-low <=M），不进行快排，而进行插入排序。转换参数M的最佳值和系统是相关的，一般来说， 5到15间的任意值在多数情况下都能令人满意。
     */
    //取数组下标第一个数、中间的数、最后一个数的中间值
    private static int medianOf3(int[] array, int left, int right) {
        int center = (right - left) / 2 + left;
        if (array[left] > array[right]) { //得到 array[left] < array[right]
            swap(array, left, right);
        }
        if (array[center] > array[right]) { //得到 array[left] array[center] < array[right]
            swap(array, center, right);
        }
        if (array[center] > array[left]) { //得到 array[center] <  array[left] < array[right]
            swap(array, center, left);
        }

        return array[left]; //array[left]的值已经被换成三数中的中位数， 将其返回
    }

    private static void recQuickSort(int[] array, int left, int right) {
        if (right <= left) {
            return;//终止递归
        } else {

            int partition = partitionIt(array, left, right);
            recQuickSort(array, left, partition - 1);// 对上一轮排序(切分)时，基准元素左边的子数组进行递归
            recQuickSort(array, partition + 1, right);// 对上一轮排序(切分)时，基准元素右边的子数组进行递归
        }
    }

    private static int partitionIt(int[] array, int left, int right) {
        //为什么 j加一个1，而i没有加1,是因为下面的循环判断是从--j和++i开始的.
        //而基准元素选的array[left],即第一个元素，所以左游标从第二个元素开始比较
        int i = left;
        int j = right + 1;
        int pivot = array[left];// pivot 为选取的基准元素（头元素）

        int size = right - left + 1;
        if (size >= 3) {
            pivot = medianOf3(array, left, right); //数组范围大于3，基准元素选择中间值。
        }
        while (true) {
            while (i < right && array[++i] < pivot) {
            }

            while (j > 0 && array[--j] > pivot) {
            }

            if (i >= j) {// 左右游标相遇时候停止， 所以跳出外部while循环
                break;
            } else {
                swap(array, i, j);// 左右游标未相遇时停止, 交换各自所指元素，循环继续
            }
        }
        swap(array, left, j);//基准元素和游标相遇时所指元素交换，为最后一次交换
        return j;// 一趟排序完成， 返回基准元素位置(注意这里基准元素已经交换位置了)
    }


    //插入排序
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    //测试优化了获取基准值后的快速排序
    public static void main(String[] args) {
        //int[] array = {7,3,5,2,9,8,6,1,4,7};
        System.out.println("---优化了获取基准值后的快速排序---");
        int[] array = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        recQuickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        testMergeSort();
    }

    //    PS：这里写一下归并排序的算法
    public static void testMergeSort() {
        System.out.println("-----归并排序的算法------");
        int[] array = {4, 2, 9, 8, 1, 6, 3, 5, 7};

        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //对左边数组进行排序
            mergeSort(array, left, mid);
            //对右边数据进行排序
            mergeSort(array, mid + 1, right);
            //合并两边数组
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        //注意每一次合并申请的临时数组大小是不一样的
        int[] temp = new int[right - left + 1];
        //新数组的索引
        int i = 0;
        //需要合并的两个数组起点
        int j = left, k = mid + 1;
        // 把较小的数先移到新数组中
        while (j <= mid && k <= right) {
            if (array[j] < array[k]) {
                temp[i++] = array[j++];
            } else {
                temp[i++] = array[k++];
            }
        }
        // 把左边剩余的数移入数组
        while (j <= mid) {
            temp[i++] = array[j++];
        }
        // 把右边边剩余的数移入数组
        while (k <= right) {
            temp[i++] = array[k++];
        }
        // 把新数组中的数覆盖array数组
        for (int l = 0; l < temp.length; l++) {
            array[l + left] = temp[l];
        }
    }
}

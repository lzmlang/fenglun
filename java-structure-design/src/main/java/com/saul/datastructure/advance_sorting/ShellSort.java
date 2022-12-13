package com.saul.datastructure.advance_sorting;

import java.util.Arrays;

/**
 * @author 枫伦
 * @DESCRIPTION 希尔排序
 * @create 2021/11/9 6:53 下午
 */
public class ShellSort {
    /**
     * 对于10个元素，我们选取4的间隔，那么100个数据，1000个数据，甚至更多的数据，我们应该怎么选取间隔呢？
     * <p>
     * 　　希尔的原稿中，他建议间隔选为N/2，也就是每一趟都将排序分为两半，因此对于N=100的数组，逐渐减小的间隔序列为：50,25,12，6,3,1。这个方法的好处是不需要在开始排序前为找到初始序列的间隔而计算序列，只需要用2整除N。但是这已经被证明并不是最好的序列。
     * <p>
     * 　　间隔序列中的数字互质是很重要的指标，也就是说，除了1，他们没有公约数。这个约束条件使得每一趟排序更有可能保持前一趟排序已经排好的结果，而希尔最初以N/2的间隔的低效性就是没有遵守这个准则。
     * <p>
     * 　　所以一种希尔的变形方法是用2.2来整除每一个间隔，对于n=100的数组，会产生序列45，20，9,4,1。这比用2会整除会显著的改善排序效果。
     * <p>
     * 　　还有一种很常用的间隔序列：knuth 间隔序列 3h+1
     */
    //希尔排序 knuth 间隔序列 3h+1
    public static void shellKnuthSort(int[] array) {
        System.out.println("原数组为" + Arrays.toString(array));
        int step = 1;
        int len = array.length;
        while (step <= len / 3) {
            step = step * 3 + 1;//1,4,13,40......
        }
        while (step > 0) {
            //分别对每个增量间隔进行排序
            for (int i = step; i < len; i++) {
                int temp = array[i];
                int j = i;
                while (j > step - 1 && temp <= array[j - step]) {
                    array[j] = array[j - step];
                    j -= step;
                }
                array[j] = temp;
            }//end for
            System.out.println("间隔为" + step + "的排序结果为" + Arrays.toString(array));
            step = (step - 1) / 3;
        }//end while(step>0)

        System.out.println("最终排序：" + Arrays.toString(array));
    }

    //希尔排序 间隔序列2h
    public static void shellSort(int[] array) {
        System.out.println("原数组为" + Arrays.toString(array));
        int step;
        int len = array.length;
        for (step = len / 2; step > 0; step /= 2) {
            //分别对每个增量间隔进行排序
            for (int i = step; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - step]) {
                    while (j - step >= 0 && temp < array[j - step]) {
                        array[j] = array[j - step];
                        j -= step;
                    }
                    array[j] = temp;
                }
            }
            System.out.println("间隔为" + step + "的排序结果为" + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3, 10};
        shellKnuthSort(array);
    }


}

package com.saul.datastructure.digui;

/**
 * @author 枫伦
 * @DESCRIPTION 二分法查找递归实现
 * @create 2021/9/23 7:59 下午
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(searchByRecursion(arr, 5, 1, 6));
    }

    public static int findTwoPoint(int[] array, int key) {
        int start = 0;
        int last = array.length - 1;
        while (start <= last) {
            int mid = (last - start) / 2 + start;//防止直接相加造成int范围溢出
            if (key == array[mid]) {//查找值等于当前值，返回数组下标
                return mid;
            }
            if (key > array[mid]) {//查找值比当前值大
                start = mid + 1;
            }
            if (key < array[mid]) {//查找值比当前值小
                last = mid - 1;
            }
        }
        return -1;
    }
    /***
     * @DESCRIPTION:  目标数组,查询的key,最小值,最大值
     * @author 枫伦
     * @params: [array, key, low, high]
     * @return: int
     * @Date: 2021/9/26 11:22 上午 
     * @Modified By:  
    */
    public static int searchByRecursion(int[] array, int key, int low, int high) {
        int mid = (high - low) / 2 + low;
        if (key == array[mid]) {//查找值等于当前值，返回数组下标
            return mid;
        } else if (low > high) {//找不到查找值，返回-1
            return -1;
        } else {
            if (key < array[mid]) {//查找值比当前值小
                return searchByRecursion(array, key, low, mid - 1);
            }
            if (key > array[mid]) {//查找值比当前值大
                return searchByRecursion(array, key, mid + 1, high);
            }
        }
        return -1;
    }
}

package com.saul.datastructure.array;

/**
 * @author 罗泽民
 * @description
 * @date 2020/12/8 14:29
 */
public class MyArray {
    public int[] arr;
    //数组中真实的数据个数,大小不一定等于arr的长度
    public int elements;

    public MyArray() {
        this.arr = new int[50];
    }

    public MyArray(int maxSize) {
        this.arr = new int[maxSize];
    }

    //添加数据
    public void insert(int value) {
        arr[elements] = value;
        elements++;
    }

    //有序插入
    public void insertSort(int value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (arr[i] > value) {
                break;
            }
        }
        for (int j = elements; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        elements++;
    }

    public void display() {
        System.out.print("[");
        //如果这里用arr.length那么会打印出很多的0
        for (int i = 0; i < elements; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");

    }

    //查找数据
    public int search(int value) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                break;
            }
        }

        if (i == elements) {
            return -1;
        } else {
            return i;
        }
    }

    //二分法查找
    public int binarySearch(int value) {
        int middle = 0;
        int low = 0;
        int pow = elements;
        while (true) {
            middle = (pow + low) / 2;
            if (arr[middle] == value) {
                return middle;
            } else if (low > pow) {
                return -1;
            } else {
                if (arr[middle] > value) {
                    pow = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
    }

    //查找数据
    public int get(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    //删除数据
    public void delete(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = index; i < arr.length; i++) {
                arr[index] = arr[index + 1];
            }
            elements--;
        }
    }

    //修改数据
    public void change(int index, int value) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = value;
        }
    }
}

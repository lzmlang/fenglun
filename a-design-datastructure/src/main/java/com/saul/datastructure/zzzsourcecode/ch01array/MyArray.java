package com.saul.datastructure.zzzsourcecode.ch01array;

/***
 * @DESCRIPTION: 数组
 * @author 枫伦
 * @params:
 * @return:
 * @Date: 2021/9/8 11:06 上午 
 * @Modified By:  
 */
public class MyArray {
    private long[] arr;
    //总数
    private int elements;

    public MyArray() {
        arr = new long[50];
    }

    public MyArray(int maxsize) {
        arr = new long[maxsize];
    }

    public void insert(long value) {
        arr[elements] = value;
        elements++;
    }

    /**
     * 打印数组元素
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < elements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public int search(long value) {
        int i;
        for (i = 0; i < elements; i++) {
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

    public long get(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    public void delete(int index) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = index; i < elements; i++) {
                arr[index] = arr[index + 1];
            }
            elements--;
        }
    }

    public void change(int index, int newvalue) {
        if (index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = newvalue;
        }
    }
}

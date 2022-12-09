package com.saul.datastructure.zzzsourcecode.ch03stackandqueue;

/***
 * @DESCRIPTION: 循环队列
 * @author 枫伦
 * @params:
 * @return:
 * @Date: 2021/9/8 11:14 上午 
 * @Modified By:  
 */
public class MyCycleQueue {
    private long[] arr;
    private int elements;
    private int front;
    private int end;

    public MyCycleQueue() {
        arr = new long[10];
        elements = 0;
        front = 0;
        end = -1;
    }

    public MyCycleQueue(int maxsize) {
        arr = new long[maxsize];
        elements = 0;
        front = 0;
        end = -1;
    }

    public void insert(long value) {
        if (end == arr.length - 1) {
            end = -1;
        }
        arr[++end] = value;
        elements++;
    }

    public long remove() {
        long value = arr[front++];
        if (front == arr.length) {
            front = 0;
        }
        elements--;
        return value;
    }

    public long peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public boolean isFull() {
        return elements == arr.length;
    }
}

package com.saul.datastructure.stackandqueue;

/**
 * @author 罗泽民
 * @description 模拟队列
 * @date 2020/11/15 18:56
 */
public class MyCycleQueue {
    public int[] arr;
    public int elements;//数据大小
    public int front;//队头
    public int end;//队尾

    public MyCycleQueue() {
        this.arr = new int[10];
        this.elements = 0;
        this.front = 0;
        this.end = -1;
    }

    public MyCycleQueue(int size) {
        this.arr = new int[size];
        this.elements = 0;
        this.front = 0;
        this.end = -1;
    }

    public void insert(int value) {
        if (end == arr.length - 1) {
            end = -1;
        }
        arr[++end] = value;
        elements++;
    }

    //移除
    public int remove() {
        int velue = arr[front++];
        if (front == arr.length) {
            front = 0;
        }
        elements--;
        return velue;
    }

    //查看队列头部
    public int peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    //是否满了
    public boolean isFull() {
        return elements == arr.length;
    }
}

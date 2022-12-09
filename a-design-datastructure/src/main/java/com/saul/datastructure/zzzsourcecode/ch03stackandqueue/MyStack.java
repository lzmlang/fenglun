package com.saul.datastructure.zzzsourcecode.ch03stackandqueue;

/***
 * @DESCRIPTION: 栈结构 先进后出
 * @author 枫伦
 * @params:
 * @return:
 * @Date: 2021/9/8 11:12 上午 
 * @Modified By:  
 */
public class MyStack {
    //栈的底层实现使用的是数组
    private long[] arr;
    private int top;

    public MyStack() {
        arr = new long[10];
        top = -1;
    }

    public MyStack(int maxsize) {
        arr = new long[maxsize];
        top = -1;
    }

    public void push(int value) {
        arr[++top] = value;
    }

    public long pop() {
        return arr[top--];
    }

    public long peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }
}

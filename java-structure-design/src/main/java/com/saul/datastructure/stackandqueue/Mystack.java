package com.saul.datastructure.stackandqueue;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author 罗泽民
 * @description 模拟栈
 * @date 2020/11/15 18:34
 */
public class Mystack {
    public int[] arr;
    public int top;
    public static int DEFAULT_SIZE = 10;

    public Mystack() {
        this.top = -1;
        this.arr = new int[DEFAULT_SIZE];
    }

    public Mystack(int size) {
        this.top = -1;
        this.arr = new int[size];
    }

    /**
     * 功能描述: 注意top++ 和++top的区别
     * arr[top++]=value 是先给arr[top]赋值,然后在top++
     * arr[++top]=value 是先top++然后arr[top]赋值,
     *
     * @return void
     * @Author luozemin
     * @Date 18:41 2020/11/15
     * @Param [value]
     **/
    public void push(int value) {
        arr[++top] = value;
    }

    //出栈
    public int pop() {
        return arr[top--];
    }

    //查看
    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //是否满了
    public boolean isFull() {
        return top == arr.length-1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mystack)) return false;
        Mystack mystack = (Mystack) o;
        return top == mystack.top &&
                Arrays.equals(arr, mystack.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(top);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public String toString() {
        return "Mystack{" +
                "arr=" + Arrays.toString(arr) +
                ", top=" + top +
                '}';
    }
}

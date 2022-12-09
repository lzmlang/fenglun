package com.saul.datastructure.stackandqueue;

/**
 * @author 罗泽民
 * @description
 * @date 2021/9/12 12:49
 */
public class MyQueue2Test {
    public static void main(String[] args) {
        MyQueue2 queue = new MyQueue2(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);//queArray数组数据为[1,2,3]

        System.out.println(queue.peekFront()); //1
        queue.remove();//queArray数组数据为[null,2,3]
        System.out.println(queue.peekFront()); //2

        queue.insert(4);//queArray数组数据为[4,2,3]
        queue.insert(5);//队列已满,queArray数组数据为[4,2,3]
    }
}

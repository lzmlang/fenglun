package com.saul.datastructure.linktable;

/**
 * @author 枫伦
 * @DESCRIPTION 双端链表实现队列
 * @create 2021/9/17 11:57 上午
 */
public class QueueByDoubleLinked {

    private DoublePointLinkedList dp;

    public QueueByDoubleLinked() {
        dp = new DoublePointLinkedList();
    }

    public void insert(Object data) {
        dp.addTail(data);
    }

    public void delete() {
        dp.deleteHead();
    }

    public boolean isEmpty() {
        return dp.isEmpty();
    }

    public int getSize() {
        return dp.getSize();
    }

    public void display() {
        dp.display();
    }

}

package com.saul.datastructure.linktable;

/**
 * @author 罗泽民
 * @description 节点
 * @date 2020/11/18 10:26
 */
public class Node {
    /**
     * 数据
     */
    public int data;
    //数据
    public Node next;

    public Node(int value) {
        this.data = value;
        this.next = null;
    }

    public void display() {
        System.out.println(data + " ");
    }
}

package com.saul.datastructure.zzzsourcecode.ch04link;

/*
 * ����㣬�൱���ǳ���
 */
public class Node {
    //������
    public long data;
    //ָ����
    public Node next;

    public Node(long value) {
        this.data = value;
    }

    /**
     * ��ʾ����
     */
    public void display() {
        System.out.print(data + " ");
    }
}

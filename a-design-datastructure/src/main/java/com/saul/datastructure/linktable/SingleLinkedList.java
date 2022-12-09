package com.saul.datastructure.linktable;

/**
 * @author 枫伦
 * @DESCRIPTION 单向链表
 *             链表通常由一连串节点组成，每个节点包含任意的实例数据（data fields）和一或两个用来指向上一个/或下一个节点的位置的链接（"links"）
 *             链表（Linked list）是一种常见的基础数据结构，是一种线性表，但是并不会按线性的顺序存储数据，而是在每一个节点里存到下一个节点的指针(Pointer)。
 * 　　使用链表结构可以克服数组链表需要预先知道数据大小的缺点，链表结构可以充分利用计算机内存空间，实现灵活的内存动态管理。但是链表失去了数组随机读取的优点，同时链表由于增加了结点的指针域，空间开销比较大。
 * @create 2021/9/16 7:47 下午
 */
public class SingleLinkedList {
    private int size;//链表节点的个数
    private Node head;//头节点

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    //链表的每个节点类
    private class Node {
        private Object data;//每个节点的数据
        private Node next;//每个节点指向下一个节点的连接

        public Node(Object data) {
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到了返回节点Node，找不到返回null
    public Node find(Object obj) {
        Node current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定的元素，删除成功返回true
    public boolean delete(Object value) {
        if (size == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        //如果删除的节点是第一个节点
        if (current == head) {
            head = current.next;
            size--;
        } else {//删除的节点不是第一个节点
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //显示节点信息
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {//当前链表只有一个节点
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }

}

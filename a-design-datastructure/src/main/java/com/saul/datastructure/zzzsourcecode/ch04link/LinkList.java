package com.saul.datastructure.zzzsourcecode.ch04link;

/***
 * @DESCRIPTION: 链表
 * @author 枫伦
 * @params:
 * @return:
 * @Date: 2021/9/8 11:17 上午 
 * @Modified By:  
 */
public class LinkList {
    //头结点
    private Node first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(long value) {
        Node node = new Node(value);
        node.next = first;
        first = node;
    }

    public Node deleteFirst() {
        Node tmp = first;
        first = tmp.next;
        return tmp;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * ���ҷ���
     */
    public Node find(long value) {
        Node current = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * ɾ������������������������ɾ��
     */
    public Node delete(long value) {
        Node current = first;
        Node previous = first;
        while (current.data != value) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;

    }
}

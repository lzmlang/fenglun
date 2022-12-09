package com.saul.datastructure.zzzsourcecode.ch05firstAndDoubleLink;

/*
 * ˫������
 */
public class FirstLastLinkList {
    //ͷ���
    private Node first;
    //β���
    private Node last;

    public FirstLastLinkList() {
        first = null;
        last = null;
    }

    /**
     * ����һ����㣬��ͷ������в���
     */
    public void insertFirst(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            last = node;
        }
        node.next = first;
        first = node;
    }

    /**
     * ����һ����㣬��β�����в���
     */
    public void insertLast(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    /**
     * ɾ��һ����㣬��ͷ�������ɾ��
     */
    public Node deleteFirst() {
        Node tmp = first;
        if (first.next == null) {
            last = null;
        }
        first = tmp.next;
        return tmp;
    }

    /**
     * ��ʾ����
     */
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

    /**
     * �ж��Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return (first == null);
    }
}

package com.saul.datastructure.linktable.shungduanlink;

import com.saul.datastructure.linktable.Node;

/**
 * @author 罗泽民
 * @description 链表
 * @date 2020/11/18 10:30
 */
public class FirstLastLinkList {
    /**
     * 头结点
     */
    public Node first;

    public FirstLastLinkList() {
        this.first = null;
    }

    /**
     * 插入一个头结点,在头结点插入
     */
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = first;
        first = node;
    }

    public Node deleteFirst() {
        Node temp = first.next;
        first = temp;
        return temp;
    }

    public void dsiplay() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    /**
     * 功能描述: 根据数据查找链表中的节点
     *
     * @return com.saul.datastructure.linktable.Node
     * @Author luozemin
     * @Date 15:20 2020/11/18
     * @Param [value]
     **/
    public Node find(int value) {
        Node current = first;
        while (current.next != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * 功能描述: 更据数据删除链表中的节点
     *
     * @return com.saul.datastructure.linktable.Node
     * @Author luozemin
     * @Date 15:21 2020/11/18
     * @Param [value]
     **/
    public Node delete(int value) {
        Node current = first;
        Node previous = first;
        while (current.next != null) {
            if (current.data != value) {
                previous = current;
                current = current.next;
            } else {
                break;
            }
        }
        if (current.data != value) {
            return null;
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

}

package com.saul.datastructure.linktable;

/**
 * @author 枫伦
 * @DESCRIPTION 有序链表
 * 前面的链表实现插入数据都是无序的，在有些应用中需要链表中的数据有序，这称为有序链表。
 * 　　在有序链表中，数据是按照关键值有序排列的。一般在大多数需要使用有序数组的场合也可以使用有序链表。有序链表优于有序数组的地方是插入的速度（因为元素不需要移动），另外链表可以扩展到全部有效的使用内存，而数组只能局限于一个固定的大小中。
 * <p>
 * 比如有一个无序数组需要排序，前面我们在讲解冒泡排序、选择排序、插入排序这三种简单的排序时，需要的时间级别都是O(N2)。
 * <p>
 * 　　现在我们讲解了有序链表之后，对于一个无序数组，我们先将数组元素取出，一个一个的插入到有序链表中，然后将他们从有序链表中一个一个删除，重新放入数组，那么数组就会排好序了。和插入排序一样，如果插入了N个新数据，那么进行大概N2/4次比较。但是相对于插入排序，每个元素只进行了两次排序，一次从数组到链表，一次从链表到数组，大概需要2*N次移动，而插入排序则需要N2次移动，
 * <p>
 * 　　效率肯定是比前面讲的简单排序要高，但是缺点就是需要开辟差不多两倍的空间，而且数组和链表必须在内存中同时存在，如果有现成的链表可以用，那么这种方法还是挺好的。
 * @create 2021/9/22 2:05 下午
 */
public class OrderLinkedList {
    private Node head;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public OrderLinkedList() {
        head = null;
    }

    //插入节点，并按照从小打到的顺序排列
    public void insert(int value) {
        Node node = new Node(value);
        Node pre = null;
        Node current = head;
        while (current != null && value > current.data) {
            pre = current;
            current = current.next;
        }
        if (pre == null) {
            head = node;
            head.next = current;
        } else {
            pre.next = node;
            node.next = current;
        }
    }

    //删除头节点
    public void deleteHead() {
        head = head.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

}

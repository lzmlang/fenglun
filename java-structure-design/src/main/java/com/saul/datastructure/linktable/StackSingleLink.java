package com.saul.datastructure.linktable;

/**
 * @author 枫伦
 * @DESCRIPTION 单向链表实现栈结构
 * @create 2021/9/16 8:10 下午
 */

public class StackSingleLink {
    private SingleLinkedList link;

    public StackSingleLink() {
        link = new SingleLinkedList();
    }

    //添加元素
    public void push(Object obj) {
        link.addHead(obj);
    }

    //移除栈顶元素
    public Object pop() {
        Object obj = link.deleteHead();
        return obj;
    }

    //判断是否为空
    public boolean isEmpty() {
        return link.isEmpty();
    }

    //打印栈内元素信息
    public void display() {
        link.display();
    }

}

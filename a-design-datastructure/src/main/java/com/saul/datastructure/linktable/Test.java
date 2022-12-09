package com.saul.datastructure.linktable;

/**
 * @author 罗泽民
 * @description 链表测试
 * 上面我们讲了各种链表，每个链表都包括一个LinikedList对象和许多Node对象，LinkedList对象通常包含头和尾节点的引用，分别指向链表的第一个节点和最后一个节点。
 * 而每个节点对象通常包含数据部分data，以及对上一个节点的引用prev和下一个节点的引用next，
 * 只有下一个节点的引用称为单向链表，两个都有的称为双向链表。
 * next值为null则说明是链表的结尾，
 * 如果想找到某个节点，我们必须从第一个节点开始遍历，不断通过next找到下一个节点，直到找到所需要的。
 * 栈和队列都是ADT，可以用数组来实现，也可以用链表实现。
 * @date 2020/11/18 10:53
 */
public class Test {
    public static void main(String[] args) {
//        testSingleLinkedList();
        String state = "refresh_appkey";
        for (String s : state.split("_")) {
            System.out.println(s);
        }
        String stsssate = "refresh";
        for (String s : stsssate.split("_")) {
            System.out.println(s);
        }
    }

    public static void testSingleLinkedList() {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
        //
    }
}

package com.saul.datastructure.stackandqueue;

/**
 * @author 罗泽民
 * @description
 * 通过前面讲的栈以及本篇讲的队列这两种数据结构，我们稍微总结一下：
 *
 * 　　①、栈、队列（单向队列）、优先级队列通常是用来简化某些程序操作的数据结构，而不是主要作为存储数据的。
 *
 * 　　②、在这些数据结构中，只有一个数据项可以被访问。
 *
 * 　　③、栈允许在栈顶压入（插入）数据，在栈顶弹出（移除）数据，但是只能访问最后一个插入的数据项，也就是栈顶元素。
 *
 * 　　④、队列（单向队列）只能在队尾插入数据，对头删除数据，并且只能访问对头的数据。而且队列还可以实现循环队列，它基于数组，数组下标可以从数组末端绕回到数组的开始位置。
 *
 * 　　⑤、优先级队列是有序的插入数据，并且只能访问当前元素中优先级别最大（或最小）的元素。
 *
 * 　　⑥、这些数据结构都能由数组实现，但是可以用别的机制（后面讲的链表、堆等数据结构）实现。
 * @date 2020/11/15 18:40
 */
public class Test {
    public static void main(String[] args) {
//        Mystack mystack = new Mystack(3);
//        mystack.push(1);
//        mystack.push(2);
//        mystack.push(3);
//        System.out.println(mystack.toString());
//        System.out.println(mystack.pop());
//        System.out.println(mystack.pop());
//        System.out.println(mystack.pop());
//        System.out.println(mystack.toString());

//        MyQueue myQueue = new MyQueue(3);
//        myQueue.insert(1);
//        myQueue.insert(2);
//        myQueue.insert(3);
//        System.out.println(myQueue.isEmpty());
//        System.out.println(myQueue.isFull());
//        System.out.println(myQueue.peek());
//        while (!myQueue.isEmpty()) {
//            System.out.println(myQueue.remove() + "  ");
//        }
//        myQueue.insert(21); //这里会出现异常.是因为我们在insert方法里面没有让front复原.front大小已经超过了数组的大小了


        MyCycleQueue myCycleQueue = new MyCycleQueue(3);
        myCycleQueue.insert(1);
        myCycleQueue.insert(2);
        myCycleQueue.insert(3);
        System.out.println(myCycleQueue.isEmpty());
        System.out.println(myCycleQueue.isFull());
        System.out.println(myCycleQueue.peek());
        while (!myCycleQueue.isEmpty()) {
            System.out.println(myCycleQueue.remove() + "  ");
        }
        myCycleQueue.insert(21);
        System.out.println(myCycleQueue.remove() + "  ");
    }
}

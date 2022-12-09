package com.saul.datastructure.tree.rbtree;

/**
 * @author 枫伦
 * @DESCRIPTION 红黑树节点
 * @create 2021/10/28 11:57 上午
 */
public class RBNode<T extends Comparable<T>> {
    boolean color;//颜色 红色为true,黑色为false
    T key;//关键值
    RBNode<T> left;//左子节点
    RBNode<T> right;//右子节点
    RBNode<T> parent;//父节点

    public static boolean RED = true;
    public static boolean BLACK = false;

    public RBNode(boolean color, T key, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
        this.color = color;
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    //获得节点的关键值
    public T getKey() {
        return key;
    }

    //打印节点的关键值和颜色信息
    @Override
    public String toString() {
        return "" + key + (this.color == RED ? "R" : "B");
    }
}

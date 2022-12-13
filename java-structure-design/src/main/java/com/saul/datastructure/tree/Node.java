package com.saul.datastructure.tree;

/**
 * @author 枫伦
 * @DESCRIPTION 二叉树的节点对象
 * @create 2021/10/9 5:37 下午
 */
public class Node {
    int data;   //节点数据
    Node leftChild; //左子节点的引用
    Node rightChild; //右子节点的引用
    boolean isDelete;//表示节点是否被删除

    public Node(int data) {
        this.data = data;
    }

    //打印节点内容
    public void display() {
        System.out.println(data);
    }
}

package com.saul.datastructure.tree;

/**
 * 前面我们介绍数组的数据结构，我们知道对于有序数组，查找很快，并介绍可以通过二分法查找，但是想要在有序数组中插入一个数据项，就必须先找到插入数据项的位置，然后将所有插入位置后面的数据项全部向后移动一位，来给新数据腾出空间，平均来讲要移动N/2次，这是很费时的。同理，删除数据也是。
 * <p>
 * 　　然后我们介绍了另外一种数据结构——链表，链表的插入和删除很快，我们只需要改变一些引用值就行了，但是查找数据却很慢了，因为不管我们查找什么数据，都需要从链表的第一个数据项开始，遍历到找到所需数据项为止，这个查找也是平均需要比较N/2次。
 * <p>
 * 　　那么我们就希望一种数据结构能同时具备数组查找快的优点以及链表插入和删除快的优点，于是 树 诞生了。
 *
 * @author 枫伦
 * @DESCRIPTION
 * @create 2021/10/9 5:39 下午
 */
public class BinaryTree implements Tree {
    //表示根节点
    private Node root;

    //查找节点
    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {//当前值比查找值大，搜索左子树
                current = current.leftChild;
            } else if (current.data < key) {//当前值比查找值小，搜索右子树
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;//遍历完整个树没找到，返回null
    }

    //插入节点
    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {//当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.data > data) {//当前值比插入值大，搜索左子节点
                    current = current.leftChild;
                    if (current == null) {//左子节点为空，直接将新值插入到该节点
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {//右子节点为空，直接将新值插入到该节点
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //中序遍历
    @Override
    public void infixOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.print(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    //前序遍历
    @Override
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    //后序遍历
    @Override
    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data + " ");
        }
    }

    //找到最大值
    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    //找到最小值
    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //查找删除值，找不到直接返回false
        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        //如果当前节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;

            //当前节点有一个子节点，右子节点
        } else if (current.leftChild == null && current.rightChild != null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            return true;
            //当前节点有一个子节点，左子节点
        } else if (current.leftChild != null && current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            return true;
        } else {
            //当前节点存在两个子节点
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;

    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        System.out.print("中序遍历: ");
        bt.infixOrder(bt.root);
        System.out.print("前序遍历: ");
        bt.preOrder(bt.root);
        System.out.print("后序遍历");
        bt.postOrder(bt.root);
        bt.delete(10);//删除没有子节点的节点
        bt.delete(30);//删除有一个子节点的节点
        bt.delete(80);//删除有两个子节点的节点
        System.out.println("\n------");

        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));

    }
}

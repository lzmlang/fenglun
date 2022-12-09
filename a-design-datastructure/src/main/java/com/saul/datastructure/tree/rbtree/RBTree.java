package com.saul.datastructure.tree.rbtree;

/**
 * 二叉搜索树，二叉搜索树对于某个节点而言，其左子树的节点关键值都小于该节点关键值，右子树的所有节点关键值都大于该节点关键值。二叉搜索树作为一种数据结构，其查找、插入和删除操作的时间复杂度都为O(logn),底数为2。但是我们说这个时间复杂度是在平衡的二叉搜索树上体现的，也就是如果插入的数据是随机的，则效率很高，但是如果插入的数据是有序的，比如从小到大的顺序【10,20,30,40,50】插入到二叉搜索树中：
 * <p>
 * 　　从大到小就是全部在左边，这和链表没有任何区别了，这种情况下查找的时间复杂度为O(N)，而不是O(logN)。当然这是在最不平衡的条件下，实际情况下，二叉搜索树的效率应该在O(N)和O(logN)之间，这取决于树的不平衡程度。
 * <p>
 * 　　那么为了能够以较快的时间O(logN)来搜索一棵树，我们需要保证树总是平衡的（或者大部分是平衡的），也就是说每个节点的左子树节点个数和右子树节点个数尽量相等。红-黑树的就是这样的一棵平衡树，对一个要插入的数据项（删除也是），插入例程要检查会不会破坏树的特征，如果破坏了，程序就会进行纠正，根据需要改变树的结构，从而保持树的平衡
 */
public class RBTree<T extends Comparable<T>> {
    //表示根节点
    private RBNode root;

    /*************对红黑树节点x进行左旋操作 ******************/
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode<T> x) {
        //1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;//如果x的父节点为空(即x为根节点)，则将y设为根节点
        } else {
            if (x == x.parent.left) {//如果x是左子节点
                x.parent.left = y;//则也将y设为左子节点
            } else {
                x.parent.right = y;//否则将y设为右子节点
            }
        }

        //3. 将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        x.parent = y;
    }

    /*************对红黑树节点y进行右旋操作 ******************/
    /*
     * 左旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    private void rightRotate(RBNode<T> y) {
        //1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;//如果y的父节点为空(即y为根节点)，则旋转后将x设为根节点
        } else {
            if (y == y.parent.left) {//如果y是左子节点
                y.parent.left = x;//则将x也设置为左子节点
            } else {
                y.parent.right = x;//否则将x设置为右子节点
            }
        }

        //3. 将x的左子节点设为y，将y的父节点设为y
        x.right = y;
        y.parent = x;
    }

    /*********************** 向红黑树中插入节点 **********************/
    public void insert(T key) {
        RBNode<T> node = new RBNode<T>(RBNode.RED, key, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    public void insert(RBNode<T> node) {
        RBNode<T> current = null;//表示最后node的父节点
        RBNode<T> x = this.root;//用来向下搜索

        //1.找到插入位置
        while (x != null) {
            current = x;
            int cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = current;//找到了插入的位置，将当前current作为node的父节点

        //2.接下来判断node是左子节点还是右子节点
        if (current != null) {
            int cmp = node.key.compareTo(current.key);
            if (cmp < 0) {
                current.left = node;
            } else {
                current.right = node;
            }
        } else {
            this.root = node;
        }

        //3.利用旋转操作将其修正为一颗红黑树
        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gparent;//定义父节点和祖父节点

        //需要修正的条件：父节点存在，且父节点的颜色是红色
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);//获得祖父节点

            //若父节点是祖父节点的左子节点，下面的else相反
            if (parent == gparent.left) {
                RBNode<T> uncle = gparent.right;//获得叔叔节点

                //case1:叔叔节点也是红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);//把父节点和叔叔节点涂黑
                    setBlack(gparent);
                    setRed(gparent);//把祖父节点涂红
                    node = gparent;//把位置放到祖父节点处
                    continue;//继续while循环，重新判断
                }

                //case2:叔叔节点是黑色，且当前节点是右子节点
                if (node == parent.right) {
                    leftRotate(parent);//从父节点出左旋
                    RBNode<T> tmp = parent;//然后将父节点和自己调换一下，为下面右旋做准备
                    parent = node;
                    node = tmp;
                }

                //case3:叔叔节点是黑色，且当前节点是左子节点
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {//若父节点是祖父节点的右子节点，与上面的情况完全相反，本质是一样的
                RBNode<T> uncle = gparent.left;

                //case1:叔叔节点也是红色的
                if (uncle != null && isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case2:叔叔节点是黑色的，且当前节点是左子节点
                if (node == parent.left) {
                    rightRotate(parent);
                    RBNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case3:叔叔节点是黑色的，且当前节点是右子节点
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(root);//将根节点设置为黑色
    }

    private void setRed(RBNode<T> node) {
        node.color = RBNode.RED;
    }

    private void setBlack(RBNode<T> node) {
        node.color = RBNode.BLACK;
    }

    private boolean isRed(RBNode<T> node) {
        return node.color;
    }

    private RBNode<T> parentOf(RBNode<T> node) {
        return node.parent;
    }
}

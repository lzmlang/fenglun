package com.saul.datastructure.hash.link_method;

/**
 * @author 枫伦
 * @DESCRIPTION 链址法解决hash碰撞
 * @create 2021/11/3 4:27 下午
 */
public class HashChain {
    private SortLink[] hashArray;//数组中存放链表
    private int arraySize;

    public HashChain(int size) {
        arraySize = size;
        hashArray = new SortLink[arraySize];
        //new 出每个空链表初始化数组
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortLink();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + "：");
            hashArray[i].displayLink();
        }
    }

    public int hashFunction(int key) {
        return key % arraySize;
    }

    public void insert(SortLink.LinkNode node) {
        int key = node.getKey();
        int hashVal = hashFunction(key);
        hashArray[hashVal].insert(node);//直接往链表中添加即可
    }

    public SortLink.LinkNode delete(int key) {
        int hashVal = hashFunction(key);
        SortLink.LinkNode temp = find(key);
        hashArray[hashVal].delete(key);//从链表中找到要删除的数据项，直接删除
        return temp;
    }

    public SortLink.LinkNode find(int key) {
        int hashVal = hashFunction(key);
        SortLink.LinkNode node = hashArray[hashVal].find(key);
        return node;
    }

}



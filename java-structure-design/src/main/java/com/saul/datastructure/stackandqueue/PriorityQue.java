package com.saul.datastructure.stackandqueue;

/**
 * @author 枫伦
 * @DESCRIPTION 优先级队列
 * insert() 方法，先检查队列中是否有数据项，如果没有，则直接插入到下标为0的单元里，否则，从数组顶部开始比较，找到比插入值小的位置进行插入，并把 nItems 加1.
 *
 * 　　remove 方法直接获取顶部元素。
 *
 * 　　优先级队列的插入操作需要 O(N)的时间，而删除操作则需要O(1) 的时间，后面会讲解如何通过 堆 来改进插入时间。
 * @create 2022/12/2 2:49 下午
 */
public class PriorityQue {
    private int maxSize;
    private int[] priQueArray;
    private int nItems;

    public PriorityQue(int s) {
        maxSize = s;
        priQueArray = new int[maxSize];
        nItems = 0;
    }

    //插入数据
    public void insert(int value) {
        int j;
        if (nItems == 0) {
            priQueArray[nItems++] = value;
        } else {
            j = nItems - 1;
            //选择的排序方法是插入排序，按照从大到小的顺序排列，越小的越在队列的顶端
            while (j >= 0 && value > priQueArray[j]) {
                priQueArray[j + 1] = priQueArray[j];
                j--;
            }
            priQueArray[j + 1] = value;
            nItems++;
        }
    }

    //移除数据,由于是按照大小排序的，所以移除数据我们指针向下移动
    //被移除的地方由于是int类型的，不能设置为null，这里的做法是设置为 -1
    public int remove() {
        int k = nItems - 1;
        int value = priQueArray[k];
        priQueArray[k] = -1;//-1表示这个位置的数据被移除了
        nItems--;
        return value;
    }

    //查看优先级最高的元素
    public int peekMin() {
        return priQueArray[nItems - 1];
    }

    //判断是否为空
    public boolean isEmpty() {
        return (nItems == 0);
    }

    //判断是否满了
    public boolean isFull() {
        return (nItems == maxSize);
    }

}
package com.saul.datastructure.vertex;

/**
 * ②、广度优先搜索（BFS）
 * <p>
 * 　　深度优先搜索要尽可能的远离起始点，而广度优先搜索则要尽可能的靠近起始点，它首先访问起始顶点的所有邻接点，然后再访问较远的区域，这种搜索不能用栈实现，而是用队列实现。
 * <p>
 * 　　规则1：访问下一个未访问的邻接点（如果存在），这个顶点必须是当前顶点的邻接点，标记它，并把它插入到队列中。
 * <p>
 * 　　规则2：如果已经没有未访问的邻接点而不能执行规则 1 时，那么从队列列头取出一个顶点（如果存在），并使其成为当前顶点。
 * <p>
 * 　　规则3：如果因为队列为空而不能执行规则 2，则搜索结束。
 * <p>
 * 　　对于上面的图，应用广度优先搜索：以A为起始点，首先访问所有与 A 相邻的顶点，并在访问的同时将其插入队列中，现在已经访问了 A,B,C,D和E。这时队列（从头到尾）包含 BCDE，已经没有未访问的且与顶点 A 邻接的顶点了，所以从队列中取出B，寻找与B邻接的顶点，这时找到F，所以把F插入到队列中。已经没有未访问且与B邻接的顶点了，所以从队列列头取出C，它没有未访问的邻接点。因此取出 D 并访问 G，D也没有未访问的邻接点了，所以取出E，现在队列中有 FG，在取出 F，访问 H，然后取出 G，访问 I，现在队列中有 HI，当取出他们时，发现没有其它为访问的顶点了，这时队列为空，搜索结束。
 *
 * @create 2021/11/9 5:00 下午
 */
public class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int remove() {
        int temp = queArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || front + SIZE - 1 == rear);
    }
}

package com.freedom.queue;

/**
 * @author freedom
 * @date 2020/8/5 20:37
 */
public class CircleArrayQueue {

    private int maxSize;

    private int[] arr;

    // front指向队列的第一个元素，也就是说，arr[front]就是队列的第一个元素
    private int front;

    // rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间做为约定
    private int rear;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("队列满了，不能加入数据");
        }

        arr[rear] = n;

        // 将rear后移，必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 当前队列有效数量的个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int displayQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        return arr[front];
    }
}

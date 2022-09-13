package com.hediantea.queue;

/**
 * 使用数组模拟队列代码实现-1
 *
 * @author HedianTea
 * @email daki9981@qq.com
 * @date 2022/8/7 10:08
 */
public class ArrayQueueDemo {
}

class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     */
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;  // 指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }

    public boolean isFull() {
        // rear  == maxSize - 1[队列满]
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        // 当front == rear 【队列为空】
        return rear == front;
    }

    /**
     * @param n 添加数据到队列
     */
    public void addQueue(int n) {
        // 先判断队列是否为满，如果满就添加不了
        if (isFull()) {
            System.out.println("队列已满，不能添加数据！！！");
            return;
        }
        rear++; // 让rear尾指针后移
        arr[rear] = n;
    }

    /**
     * @return 获取队列的数据，出队列
     */
    public int getQueue() {
        // 先判断队列是否为空，若为空则无法出队列，抛异常处理（而不是直接return）
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出数据！！！");
        }
        front++; // 头指针后移
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        // 先进行非空判断
        if (isEmpty()) {
            System.out.println("队列为空，没有数据无法遍历！！！");
            return;
        }
        for (int i : arr) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * @return 显示队列的头数据，注意不是取出数据
     */
    public int headQueue() {
        // 先判空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据！！！\"");
        }
        // 初始定义front = -1; 指向队列头部，分析出front是指向队列头的前一个位置，+1之后指向第一个位置
        return arr[front + 1];
    }

}

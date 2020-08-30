package com.fantasy.datastructure.queue.test;

import com.fantasy.datastructure.queue.LinkedQueue;

/**
 * “链式队列”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class LinkedQueueTest {

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }

}

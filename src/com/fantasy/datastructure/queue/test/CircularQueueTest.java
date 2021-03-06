package com.fantasy.datastructure.queue.test;

import com.fantasy.datastructure.queue.CircularQueue;

/**
 * “循环队列”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class CircularQueueTest {

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(10);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.toString());
        queue.enqueue("d");
        queue.enqueue("e");
        System.out.println(queue.toString());
    }

}

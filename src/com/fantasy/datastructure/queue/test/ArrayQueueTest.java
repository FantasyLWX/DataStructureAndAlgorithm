package com.fantasy.datastructure.queue.test;

import com.fantasy.datastructure.queue.ArrayQueue;

/**
 * “顺序队列”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }

}

package com.fantasy.datastructure.linkedlist.test;

import com.fantasy.datastructure.linkedlist.CircularLinkedList;

/**
 * “循环链表”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-03
 *     since   : 1.0, 2020-07-03
 * </pre>
 */
public class CircularLinkedListTest {

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insertHead(1);
        System.out.println(list); // [1]

        list.insertHead(2);
        list.insertTail(3);
        System.out.println(list); // [2, 1, 3]

        list.deleteHead();
        System.out.println(list); // [1, 3]

        list.deleteTail();
        System.out.println(list); // [1]
    }

}

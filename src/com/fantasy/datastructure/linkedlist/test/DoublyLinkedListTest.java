package com.fantasy.datastructure.linkedlist.test;

import com.fantasy.datastructure.linkedlist.DoublyLinkedList;

/**
 * “双向链表”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-05
 *     since   : 1.0, 2020-07-05
 * </pre>
 */
public class DoublyLinkedListTest {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertHead(1);
        System.out.println(list); // [1]

        list.insertHead(2);
        list.insertTail(3);
        list.insertTail(4);
        System.out.println(list); // [2, 1, 3, 4]
        System.out.println(list.reverse()); // [4, 3, 1, 2]

        list.deleteHead();
        System.out.println(list); // [1, 3, 4]

        list.deleteTail();
        System.out.println(list); // [1, 3]

        list.deleteHead();
        list.deleteTail();
        System.out.println(list); // []
    }

}

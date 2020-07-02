package com.fantasy.datastructure.linkedlist.test;

import com.fantasy.datastructure.linkedlist.ListNode;
import com.fantasy.datastructure.linkedlist.SingleLinkedList;

/**
 * “单链表”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-02
 *     since   : 1.0, 2020-07-02
 * </pre>
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.insertHead(1);
        list.insertTail(2);
        System.out.println(list); // [1, 2]

        ListNode node = new ListNode(4);
        list.insertTail(node);
        list.insertBefore(node, 3);
        list.insertAfter(node, 5);
        System.out.println(list); // [1, 2, 3, 4, 5]

        list.delete(node);
        list.deleteFirst(5);
        System.out.println(list); // [1, 2, 3]

        list.insertTail(2);
        System.out.println(list); // [1, 2, 3, 2]

        list.deleteAll(2);
        System.out.println(list); // [1, 3]
    }

}
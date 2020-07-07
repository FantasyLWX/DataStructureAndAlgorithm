package com.fantasy.algorithm.linkedlist;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 将两个有序链表合并为一个有序链表
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-07
 *     since   : 1.0, 2020-07-07
 * </pre>
 */
public class MergeTwoOrderedLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);
        System.out.println(node1); // [1, 3, 5]

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(6);
        System.out.println(node2); // [2, 4, 6]

        System.out.println(mergeTwoOrderedLinkedList(node1, node2)); // [1, 2, 3, 4, 5, 6]

        node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);
        System.out.println(node1); // [1, 3, 5]

        node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(6);
        System.out.println(node2); // [2, 4, 6]

        System.out.println(mergeTwoOrderedLinkedListRecursively(node1, node2)); // [1, 2, 3, 4, 5, 6]
    }

    public static ListNode mergeTwoOrderedLinkedList(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (node1 != null || node2 != null) {
            if (node1 == null) {
                temp.next = node2;
                break;
            }
            if (node2 == null) {
                temp.next = node1;
                break;
            }
            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        return dummy.next;
    }

    public static ListNode mergeTwoOrderedLinkedListRecursively(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val <= node2.val) {
            node1.next = mergeTwoOrderedLinkedListRecursively(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeTwoOrderedLinkedListRecursively(node1, node2.next);
            return node2;
        }
    }

}
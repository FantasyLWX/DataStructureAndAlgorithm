package com.fantasy.algorithm.linkedlist;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 反转单链表
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-05
 *     since   : 1.0, 2020-07-05
 * </pre>
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head); // [1, 2, 3, 4]

        ListNode reverseHead = reverseLinkedList(head);
        System.out.println(reverseHead); // [4, 3, 2, 1]
        System.out.println(reverseLinkedListRecursively(reverseHead)); // [1, 2, 3, 4]
    }

    /**
     * 使用迭代反转单链表
     *
     * @param head 原链表的头结点
     * @return 反转后的链表的头结点
     */
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 使用递归反转单链表
     *
     * @param head 原链表的头结点
     * @return 反转后的链表的头结点
     */
    public static ListNode reverseLinkedListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseLinkedListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}
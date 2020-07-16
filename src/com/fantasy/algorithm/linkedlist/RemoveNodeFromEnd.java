package com.fantasy.algorithm.linkedlist;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 删除链表倒数第 n 个结点
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-16
 *     since   : 1.0, 2020-07-16
 * </pre>
 */
public class RemoveNodeFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head); // [1, 2, 3, 4]
        System.out.println(removeNodeFromEnd(head, 1)); // [1, 2, 3]
        System.out.println(removeNodeFromEnd(head, 2)); // [1, 3]
    }

    /**
     * 删除链表倒数第 n 个结点
     *
     * @param head 头结点
     * @param n    第 n 个
     * @return 删除结点后的链表
     */
    public static ListNode removeNodeFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

}
package com.fantasy.algorithm.linkedlist;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 查找链表的中间结点
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-08
 *     since   : 1.0, 2020-07-08
 * </pre>
 */
public class FindMiddleNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head); // [1, 2, 3, 4]

        System.out.println(findMiddleNode(head).val); // 3

        head.next.next.next.next = new ListNode(5);
        System.out.println(head); // [1, 2, 3, 4, 5]

        System.out.println(findMiddleNode(head).val); // 3
    }

    /**
     * 查找链表的中间结点<br>
     * </br>
     * 思路：使用快慢两个指针，慢指针每次前进一步，快指针每次前进两步。 当快指针走到尾，而慢指针刚好走到中间。
     * 不过有个特殊情况，那就是当有偶数个结点时，中间结点是有两个。慢指针所指的结点是靠后的结点。
     *
     * @param head 头结点
     * @return 中间结点
     */
    public static ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
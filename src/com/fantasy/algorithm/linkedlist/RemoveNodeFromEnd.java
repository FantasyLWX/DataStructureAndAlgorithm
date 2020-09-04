package com.fantasy.algorithm.linkedlist;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 删除链表倒数第 n 个结点
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.1, 2020-09-04
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
        System.out.println(removeNodeFromEnd(head, 2)); // [1, 2, 4]
        System.out.println(removeNodeFromEnd(head, 3)); // [2, 4]
    }

    /**
     * 删除链表倒数第 n 个结点<br>
     * </br>
     * 思路：利用双指针，这两个指针相差 n 个元素，即 first 指针先走 n 步。 当 first 指针走到链表末尾的时候，second
     * 指针所指向的下一个结点就是要删除的结点。但是如果一开始 first 指针指向的为 null，那此时代表的意思就是要删除头结点了。
     *
     * @param head 头结点
     * @param n    第 n 个
     * @return 删除结点后的链表
     */
    public static ListNode removeNodeFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        while (n-- > 0) {
            first = first.next;
        }

        if (first != null) {
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
        } else {
            head = head.next;
        }

        return head;
    }

}
package com.fantasy.algorithm.linkedlist;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 判断单链表是否是回文
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-16
 *     since   : 1.0, 2020-07-16
 * </pre>
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next = new ListNode(1);
        System.out.println(head1); // [1, 2, 3, 3, 2, 1]
        System.out.println(isPalindrome(head1)); // true

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(1);
        System.out.println(head2); // [1, 2, 3, 2, 1]
        System.out.println(isPalindrome(head2)); // true
    }

    /**
     * 判断单链表是否是回文<br>
     * </br>
     * 思路：使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。如果有奇数个结点，则中间结点只有一个。
     * 如果有偶数个结点，则中间结点有两个，此时慢指针所指的结点是靠后的结点。
     * 在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
     *
     * @param head 头结点
     * @return 是回文，则返回true；不是回文，则返回false
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 奇数个结点，则快指针会移动到最后一个结点，此时慢指针是指向中结点的，
        // 所以要取 next 执政来作为后半串的头结点
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

}
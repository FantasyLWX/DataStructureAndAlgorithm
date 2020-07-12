package com.fantasy.algorithm.linkedlist;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 检测链表中的环
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-12
 *     since   : 1.0, 2020-07-12
 * </pre>
 */
public class DetectRing {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println("链表是否有环：" + hasRing(head)); // true
        System.out.println("链表中环的入口结点：" + getRingEntryNode(head).val); // 1
        System.out.println("链表中环的长度：" + getRingLength(head)); // 3
    }

    /**
     * 判断链表是否有环
     *
     * @param head 头结点
     * @return 有环，则返回true；没有环，则返回false
     */
    public static boolean hasRing(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 获取链表中环的入口结点<br>
     * </br>
     * 思路：从头结点和快慢指针碰撞的结点以相同速度出发，相遇的结点就是入口结点。
     *
     * @param head 头结点
     * @return 返回第一个进入环的结点，如果没有，则返回null
     */
    public static ListNode getRingEntryNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    /**
     * 求链表中环的长度<br>
     * </br>
     * 思路：从快慢指针相遇结点开始，再次相遇时，慢指针走过的距离就是环的长度。首先，快慢指针第一次相遇的结点，肯定是在环里面的。
     * 所以从此结点出发，肯定会再次相遇的，并且再次相遇的时候，快指针会比慢指针多走1圈。
     * 再加上快指针的速度是慢指针的2倍，两个指针用时是一样的，所以快指针走的距离会是慢指针的2倍。
     * 又因为前面已经分析了，快指针和慢指针再次相遇时，快指针会比慢指针多走1圈，所以慢指针走过的距离就是环的长度。
     *
     * @param head 头结点
     * @return 环的长度
     */
    public static int getRingLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                do {
                    len++;
                    slow = slow.next;
                    fast = fast.next.next;
                } while (slow != fast);
                return len;
            }
        }

        return 0;
    }

}
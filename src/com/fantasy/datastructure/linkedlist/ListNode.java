package com.fantasy.datastructure.linkedlist;

/**
 * 链表结点
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.1, 2020-07-05
 *     since   : 1.0, 2020-07-02
 * </pre>
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListNode node = this; node != null; node = node.next) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",").append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

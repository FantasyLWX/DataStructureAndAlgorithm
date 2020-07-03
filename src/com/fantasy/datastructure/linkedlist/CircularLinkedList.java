package com.fantasy.datastructure.linkedlist;

/**
 * 循环链表
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-03
 *     since   : 1.0, 2020-07-03
 * </pre>
 */
public class CircularLinkedList {
    private ListNode head;
    private ListNode tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void insertHead(int value) {
        insertHead(new ListNode(value));
    }

    public void insertHead(ListNode node) {
        if (head == null) {
            node.next = node;
            head = tail = node;
        } else {
            node.next = head;
            tail.next = node;
            head = node;
        }
    }

    public void insertTail(int value) {
        insertTail(new ListNode(value));
    }

    public void insertTail(ListNode node) {
        if (head == null) {
            node.next = node;
            head = tail = node;
        } else {
            node.next = head;
            tail.next = node;
            tail = node;
        }
    }

    public void deleteHead() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        tail.next = head;
    }

    public void deleteTail() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        ListNode temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListNode node = head; node != null; node = node.next) {
            sb.append(node.val);
            if (node.next != head) {
                sb.append(",").append(" ");
            } else {
                break;
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

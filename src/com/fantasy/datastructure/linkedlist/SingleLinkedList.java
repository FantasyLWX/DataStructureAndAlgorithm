package com.fantasy.datastructure.linkedlist;

/**
 * 单链表
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.1, 2020-07-03
 *     since   : 1.0, 2020-07-02
 * </pre>
 */
public class SingleLinkedList {
    private ListNode head;

    public SingleLinkedList() {
        head = null;
    }

    public void insertHead(int value) {
        insertHead(new ListNode(value));
    }

    public void insertHead(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertTail(int value) {
        insertTail(new ListNode(value));
    }

    public void insertTail(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void insertAfter(ListNode node, int value) {
        insertAfter(node, new ListNode(value));
    }

    public void insertAfter(ListNode node, ListNode newNode) {
        if (node == null) {
            return;
        }
        newNode.next = node.next;
        node.next = newNode;
    }

    public void insertBefore(ListNode node, int value) {
        insertBefore(node, new ListNode(value));
    }

    public void insertBefore(ListNode node, ListNode newNode) {
        if (node == null) {
            return;
        }

        if (node == head) {
            insertHead(newNode);
        }

        ListNode temp = head;
        while (temp != null && temp.next != node) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        newNode.next = node;
        temp.next = newNode;
    }

    public void delete(ListNode node) {
        if (node == null || head == null) {
            return;
        }

        if (node == head) {
            head = head.next;
            return;
        }

        ListNode temp = head;
        while (temp != null && temp.next != node) {
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        temp.next = temp.next.next;
    }

    public void deleteFirst(int value) {
        if (head == null) {
            return;
        }

        if (value == head.val) {
            head = head.next;
            return;
        }

        ListNode temp = head;
        while (temp.next != null && temp.next.val != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
    }

    public void deleteAll(int value) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == value) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        head = dummy.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListNode node = head; node != null; node = node.next) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",").append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

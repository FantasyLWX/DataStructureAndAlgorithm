package com.fantasy.datastructure.linkedlist;

/**
 * 双向链表
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-05
 *     since   : 1.0, 2020-07-05
 * </pre>
 */
public class DoublyLinkedList {

    /**
     * 双向链表的结点
     */
    public class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insertHead(int value) {
        insertHead(new Node(value));
    }

    public void insertHead(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void insertTail(int value) {
        insertTail(new Node(value));
    }

    public void insertTail(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
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
    }

    public void deleteTail() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node node = head; node != null; node = node.next) {
            sb.append(node.val);
            if (node != tail) {
                sb.append(",").append(" ");
            } else {
                break;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String reverse() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node node = tail; node != null; node = node.prev) {
            sb.append(node.val);
            if (node != head) {
                sb.append(",").append(" ");
            } else {
                break;
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

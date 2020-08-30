package com.fantasy.datastructure.queue;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 链式队列
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class LinkedQueue {
    private ListNode mHead;
    private ListNode mTail;

    public LinkedQueue() {
        mHead = null;
        mTail = null;
    }

    public void enqueue(int value) {
        ListNode node = new ListNode(value);
        if (mTail == null) {
            mHead = mTail = node;
        } else {
            mTail.next = node;
            mTail = node;
        }
    }

    public int dequeue() {
        if (mHead == null) {
            throw new IllegalArgumentException("queue empty");
        }

        int value = mHead.val;
        mHead = mHead.next;
        if (mHead == null) {
            mTail = null;
        }
        return value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListNode node = mHead; node != null; node = node.next) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",").append(" ");
            }
        }
        return sb.toString();
    }

}

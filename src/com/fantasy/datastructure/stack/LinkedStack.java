package com.fantasy.datastructure.stack;

import com.fantasy.datastructure.linkedlist.ListNode;

/**
 * 链式栈
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class LinkedStack {
    private ListNode mHead;
    /**
     * 当前元素个数
     */
    private int mSize;

    public LinkedStack() {
        mHead = null;
        mSize = 0;
    }

    public int push(int item) {
        ListNode node = new ListNode(item);
        node.next = mHead;
        mHead = node;
        mSize++;
        return item;
    }

    public int pop() {
        if (mSize == 0) {
            throw new IllegalArgumentException("Stack empty");
        }

        int obj = mHead.val;
        mHead = mHead.next;
        mSize--;

        return obj;
    }

    public int peek() {
        if (mSize == 0) {
            throw new IllegalArgumentException("Stack empty");
        }

        return mHead.val;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int size() {
        return mSize;
    }

}

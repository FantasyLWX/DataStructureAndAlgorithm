package com.fantasy.datastructure.stack;

/**
 * 顺序栈
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class ArrayStack {
    /**
     * 数组容器
     */
    private int[] mData;
    /**
     * 当前元素个数
     */
    private int mSize;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }

        mData = new int[capacity];
    }

    public int push(int item) {
        if (mSize == mData.length) {
            throw new IllegalArgumentException("Stack full");
        }

        mData[mSize++] = item;
        return item;
    }

    public int pop() {
        if (mSize == 0) {
            throw new IllegalArgumentException("Stack empty");
        }

        int obj = mData[mSize - 1];
        mSize--;

        return obj;
    }

    public int peek() {
        if (mSize == 0) {
            throw new IllegalArgumentException("Stack empty");
        }

        return mData[mSize - 1];
    }

    public boolean empty() {
        return size() == 0;
    }

    public int size() {
        return mSize;
    }

}

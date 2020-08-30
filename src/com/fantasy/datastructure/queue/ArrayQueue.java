package com.fantasy.datastructure.queue;

/**
 * 顺序队列
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class ArrayQueue {
    private String[] mData;
    /**
     * 当前元素个数
     */
    private int mSize = 0;
    /**
     * 队头下标
     */
    private int mHead = 0;
    /**
     * 队尾下标
     */
    private int mTail = 0;

    public ArrayQueue(int capacity) {
        mData = new String[capacity];
        mSize = capacity;
    }

    public boolean enqueue(String item) {
        // mTail == mSize，表示队列末尾没有空间了
        if (mTail == mSize) {
            // mTail == mSize && mHead == 0，表示整个队列都占满了
            if (mHead == 0) {
                return false;
            }
            // 数据搬移
            for (int i = mHead; i < mTail; i++) {
                mData[i - mHead] = mData[i];
            }
            // 搬移完之后重新更新 mHead 和 mTail
            mTail -= mHead;
            mHead = 0;
        }

        mData[mTail++] = item;
        return true;
    }

    public String dequeue() {
        if (mHead == mTail) {
            return null;
        }
        return mData[mHead++];
    }

    public String toString() {
        if (mSize == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = mHead; i < mTail; i++) {
            sb.append(mData[i]);
            if (i != mTail - 1) {
                sb.append(',').append(' ');
            }
        }

        return sb.toString();
    }

}

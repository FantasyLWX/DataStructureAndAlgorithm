package com.fantasy.datastructure.queue;

/**
 * 循环队列
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class CircularQueue {
    private String[] mData;
    /**
     * 队列的容量
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

    public CircularQueue(int capacity) {
        mData = new String[capacity];
        mSize = capacity;
    }

    public boolean enqueue(String item) {
        if ((mTail + 1) % mSize == mHead) {
            // 队满，mTail 指向的位置不存储数据，实际存储的数据个数为 mSize - 1
            return false;
        }
        mData[mTail] = item;
        mTail = (mTail + 1) % mSize;
        return true;
    }

    public String dequeue() {
        if (mHead == mTail) {
            return null;
        }
        String item = mData[mHead];
        mHead = (mHead + 1) % mSize;
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = mHead; i % mSize != mTail; i++) {
            sb.append(mData[i]);
            if ((i + 1) % mSize != mTail) {
                sb.append(",").append(" ");
            }
        }
        return sb.toString();
    }

}

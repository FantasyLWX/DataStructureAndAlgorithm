package com.fantasy.datastructure.array;

/**
 * 大小固定的有序数组
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-01
 *     since   : 1.0, 2020-07-01
 * </pre>
 */
public class OrderedArray {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 20;
    /**
     * 当前容量
     */
    private int mCapacity;
    /**
     * 当前元素个数
     */
    private int mSize;
    /**
     * 数组容器
     */
    private int[] mData;

    public OrderedArray() {
        this(DEFAULT_CAPACITY);
    }

    public OrderedArray(int capacity) {
        mCapacity = capacity;
        mData = new int[mCapacity];
    }

    /**
     * 添加元素
     *
     * @param element 元素
     */
    public void add(int element) {
        if (mSize == mCapacity) {
            throw new IllegalArgumentException("add fail. array is full.");
        }

        int i = mSize - 1;
        for (; i >= 0; i--) {
            if (element < mData[i]) {
                mData[i + 1] = mData[i];
            } else {
                break;
            }
        }
        mData[i + 1] = element;
        mSize++;
    }

    /**
     * 删除指定索引的元素
     *
     * @param index 索引
     * @return 被删除的元素
     */
    public int remove(int index) {
        if (index < 0 || index > mSize - 1) {
            throw new IllegalArgumentException("remove fail. index out of range.");
        }

        int element = mData[index];
        for (int i = index; i < mSize - 1; i++) {
            mData[i] = mData[i + 1];
        }
        mData[mSize - 1] = 0;
        mSize--;

        return element;
    }

    /**
     * 获取指定索引的元素
     *
     * @param index 索引
     * @return 元素
     */
    public int get(int index) {
        if (index < 0 || index > mSize - 1) {
            throw new IllegalArgumentException("get fail. index out of range.");
        }
        return mData[index];
    }

    public boolean isEmpty() {
        return mSize == 0;
    }

    public int getSize() {
        return mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < mSize; i++) {
            sb.append(get(i));
            if (i == mSize - 1) {
                sb.append("]");
            } else {
                sb.append(',').append(' ');
            }
        }

        return sb.toString();
    }

}

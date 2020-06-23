package com.fantasy.datastructure.array;

/**
 * 支持动态扩容的数组
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-06-23
 *     since   : 1.0, 2020-06-23
 * </pre>
 */
public class DynamicArray<T> {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 最大容量
     */
    private static final int MAX_CAPACITY = Integer.MAX_VALUE;
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
    private T[] mData;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(final int capacity) {
        mCapacity = capacity;
        mData = (T[]) new Object[capacity];
    }

    public void add(final T e) {
        addLast(e);
    }

    public void addFirst(final T e) {
        addElement(0, e);
    }

    public void addLast(final T e) {
        addElement(mSize, e);
    }

    /**
     * 在指定索引添加元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void addElement(final int index, final T e) {
        if (index < 0 || index > mSize) {
            throw new IllegalArgumentException("add fail. index out of range.");
        }

        if (mSize == MAX_CAPACITY) {
            throw new IllegalArgumentException("add fail. exceed max capacity.");
        }

        resize();

        for (int i = mSize - 1; i >= index; i--) {
            mData[i + 1] = mData[i];
        }
        mData[index] = e;
        mSize++;
    }

    public T remove() {
        return removeLast();
    }

    public T removeFirst() {
        return removeElement(0);
    }

    public T removeLast() {
        return removeElement(mSize - 1);
    }

    /**
     * 移除指定索引的元素
     *
     * @param index 索引
     * @return 移除的元素
     */
    public T removeElement(final int index) {
        if (index < 0 || index > mSize - 1) {
            throw new IllegalArgumentException("remove fail. index out of range.");
        }

        final T element = mData[index];
        for (int i = index; i < mSize - 1; i++) {
            mData[i] = mData[i + 1];
        }
        mData[mSize - 1] = null;
        mSize--;

        resize();

        return element;
    }

    /**
     * 获取指定索引的元素
     *
     * @param index 索引
     * @return 元素
     */
    public T get(final int index) {
        if (index < 0 || index > mSize - 1) {
            throw new IllegalArgumentException("get fail. index out of range.");
        }
        return mData[index];
    }

    /**
     * 根据索引设置元素值
     *
     * @param index 索引
     * @param value 值
     */
    public void set(final int index, final T value) {
        if (index < 0 || index > mSize - 1) {
            throw new IllegalArgumentException("set fail. index out of range.");
        }
        mData[index] = value;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return mSize == 0;
    }

    /**
     * 获取当前数组元素个数
     */
    public int getSize() {
        return mSize;
    }

    /**
     * 获取当前数组容量
     */
    public int getCapacity() {
        return mCapacity;
    }

    /**
     * 数组扩容
     */
    @SuppressWarnings("unchecked")
    public void resize() {
        final int oldCapacity = mCapacity;

        // 扩容
        if (mSize == mCapacity) {
            // 容量已满，容量扩大一倍
            if (mCapacity > MAX_CAPACITY / 2) {
                mCapacity = MAX_CAPACITY;
            } else {
                mCapacity = mCapacity * 2;
            }
        }

        // 缩容
        if (mSize <= mCapacity / 4 && mCapacity / 2 != 0) {
            // 当实际元素个数小于等于容量的四分之一时，将容量缩小为原来的一半
            mCapacity = mCapacity / 2;
        }

        if (mCapacity != oldCapacity) {
            final T[] newTable = (T[]) new Object[mCapacity];
            System.arraycopy(mData, 0, newTable, 0, mSize);
            mData = newTable;
        }
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        final StringBuilder sb = new StringBuilder();
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
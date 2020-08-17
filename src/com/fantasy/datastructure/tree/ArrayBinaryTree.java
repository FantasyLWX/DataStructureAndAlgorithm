package com.fantasy.datastructure.tree;

/**
 * 完全二叉树，数组顺序存储。</br>
 * </br>
 * 为了方便获取左右孩子结点以及父亲结点，从下标 1 开始存储数据。</br>
 * </br>
 * 数组下标为 i 的结点，左孩子结点下标为 i * 2，右孩子结点下标为 i * 2 + 1，父亲结点下标为 i / 2
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-17
 *     since   : 1.0, 2020-08-17
 * </pre>
 */
public class ArrayBinaryTree {
    private int[] array;
    /**
     * 二叉树存储的最大数据个数
     */
    private int n;
    /**
     * 二叉树已经存储的数据个数
     */
    private int count;

    public ArrayBinaryTree(int capacity) {
        array = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return;
        }

        count++;
        array[count] = data;
    }

    public void preorder(int index) {
        if (index > count) {
            return;
        }

        System.out.print(array[index]);
        if (index == count) {
            System.out.println();
        } else {
            System.out.print(" ");
        }

        preorder(index * 2);
        preorder(index * 2 + 1);
    }

    public void inorder(int index) {
        if (index > count) {
            return;
        }

        inorder(index * 2);

        System.out.print(array[index]);
        if (index == count) {
            System.out.println();
        } else {
            System.out.print(" ");
        }

        inorder(index * 2 + 1);
    }

    public void postorder(int index) {
        if (index > count) {
            return;
        }

        postorder(index * 2);
        postorder(index * 2 + 1);

        System.out.print(array[index]);
        if (index == 1) {
            System.out.println();
        } else {
            System.out.print(" ");
        }
    }

}
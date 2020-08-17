package com.fantasy.datastructure.tree.test;

import com.fantasy.datastructure.tree.ArrayBinaryTree;

/**
 * “完全二叉树”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-17
 *     since   : 1.0, 2020-08-17
 * </pre>
 */
public class ArrayBinaryTreeTest {

    public static void main(String[] args) {
        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 6   7
        int capacity = 7;

        ArrayBinaryTree tree = new ArrayBinaryTree(capacity);
        for (int i = 1; i <= capacity; i++) {
          tree.insert(i);
        }

        tree.preorder(1); // 1 2 4 5 3 6 7
        tree.inorder(1); // 4 2 5 1 6 3 7
        tree.postorder(1); // 4 5 2 6 7 3 1
    }

}
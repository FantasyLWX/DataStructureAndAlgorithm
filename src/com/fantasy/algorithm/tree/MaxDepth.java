package com.fantasy.algorithm.tree;

import java.util.LinkedList;

import com.fantasy.datastructure.tree.BinarySearchTree;
import com.fantasy.datastructure.tree.TreeNode;

/**
 * 二叉树的最大深度
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-18
 *     since   : 1.0, 2020-08-18
 * </pre>
 */
public class MaxDepth {

    public static void main(String[] args) {
        //      3
        //    /   \
        //   2     5
        //  /     / \
        // 1     4   6
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);

        System.out.println("max depth : " + getMaxDepth(tree.getRoot()));
        System.out.println("max depth2 : " + getMaxDepth2(tree.getRoot()));
    }

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);

        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }

    public static int getMaxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur, last;
        int level = 0;

        while (!queue.isEmpty()) {
            cur = 0; // 记录本层已经遍历的结点个数
            last = queue.size(); // 当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的结点的个数
            while (cur < last) { // 当还没有遍历到本层最后一个结点时，继续循环
                current = queue.poll(); // 出队一个元素
                cur++;
                // 把当前结点的左右结点入队（如果存在的话）
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++; // 每遍历完一层level+1
        }

        return level;
    }

}
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
        // tree.insert(7);

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

        int level = 0;
        TreeNode node = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int i = 0; // 记录本层已经遍历的结点个数
            int size = queue.size(); // 当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是下一层的结点个数
            while (i < size) { // 当还没有遍历到本层最后一个结点时，继续循环
                node = queue.poll(); // 出队一个元素
                i++;
                // 如果存在的话，把当前结点的左右结点入队
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++; // 每遍历完一层 level + 1
        }

        return level;
    }

}
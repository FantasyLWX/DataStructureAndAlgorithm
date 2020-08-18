package com.fantasy.algorithm.tree;

import com.fantasy.datastructure.tree.TreeNode;

/**
 * 判断二叉树的一些特性的相关算法
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-18
 *     since   : 1.0, 2020-08-18
 * </pre>
 */
public class JudgeBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("isBalanced : " + isBalanced(root));
        System.out.println("isSymmetric : " + isSymmetric(root));
    }

    private static boolean isBalanced = true;

    /**
     * 是否是平衡二叉树
     */
    public static boolean isBalanced(TreeNode root) {
        isBalanced = true;
        getDepth(root);
        return isBalanced;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 是否是镜像二叉树
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    public static boolean isSym(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        return r1.value == r2.value && isSym(r1.left, r2.right) && isSym(r1.right, r2.left);
    }

}
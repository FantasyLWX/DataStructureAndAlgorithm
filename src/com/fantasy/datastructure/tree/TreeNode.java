package com.fantasy.datastructure.tree;

/**
 * 树结点
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-17
 *     since   : 1.0, 2020-08-17
 * </pre>
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
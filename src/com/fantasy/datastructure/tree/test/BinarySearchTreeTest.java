package com.fantasy.datastructure.tree.test;

import com.fantasy.algorithm.tree.TraversalBinarySearchTree;
import com.fantasy.datastructure.tree.BinarySearchTree;
import com.fantasy.datastructure.tree.TreeNode;

/**
 * “二叉查找树”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-17
 *     since   : 1.0, 2020-08-17
 * </pre>
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        TraversalBinarySearchTree.preorder(root); // 3 2 5 4 6
        System.out.println();

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
        TraversalBinarySearchTree.preorder(tree.getRoot()); // 3 2 1 5 4 6
        System.out.println();

        TreeNode node = tree.find(5);
        if (node != null) {
            System.out.println("find node " + node.value);
        }

        System.out.print("delete 5, result : ");
        tree.delete(5);
        TraversalBinarySearchTree.preorder(tree.getRoot()); // 3 2 1 6 4
        System.out.println();

        System.out.println("max node " + tree.getMaxNode().value);
        System.out.println("min node " + tree.getMinNode().value);

        int data = 4;
        System.out.print("Predecessor node of " + data + " is : ");
        if (tree.predecessor(data) != null) {
            System.out.println(tree.predecessor(data).value);
        } else {
            System.out.println("null");
        }

        System.out.print("Successor node of " + data + " is : ");
        if (tree.successor(data) != null) {
            System.out.println(tree.successor(data).value);
        } else {
            System.out.println("null");
        }
    }

}
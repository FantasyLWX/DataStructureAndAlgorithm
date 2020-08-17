package com.fantasy.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.fantasy.datastructure.tree.BinarySearchTree;
import com.fantasy.datastructure.tree.TreeNode;

/**
 * 遍历二叉查找树
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-17
 *     since   : 1.0, 2020-08-17
 * </pre>
 */
public class TraversalBinarySearchTree {

    public static void main(String[] args) {
        // 3
        // / \
        // 2 5
        // / / \
        // 1 4 6
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);

        // 先序遍历
        System.out.print("preorder : ");
        preorder(tree.getRoot()); // 3 2 1 5 4 6
        System.out.println();
        System.out.println("preorder2 : " + preorder2(tree.getRoot()));
        System.out.println("preorder3 : " + preorder3(tree.getRoot()));

        // 中序遍历
        System.out.print("inorder : ");
        inorder(tree.getRoot()); // 1 2 3 4 5 6
        System.out.println();
        System.out.println("inorder2 : " + inorder2(tree.getRoot()));

        // 后序遍历
        System.out.print("postorder : ");
        postorder(tree.getRoot()); // 1 2 4 6 5 3
        System.out.println();
        System.out.println("postorder2 : " + postorder2(tree.getRoot()));
        System.out.println("postorder3 : " + postorder3(tree.getRoot()));

        // 广度优先遍历
        System.out.println("level order : " + levelOrder(tree.getRoot())); // 3 2 5 1 4 6
        System.out.println("level order2 : " + levelOrder2(tree.getRoot()));
    }

    /**
     * 先序遍历（递归）
     *
     * @param root 根结点
     */
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 中序遍历（递归）
     *
     * @param root 根结点
     */
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    /**
     * 后序遍历（递归）
     *
     * @param root 根结点
     */
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 先序遍历（非递归）
     *
     * @param root 根结点
     * @return 结果
     */
    public static List<Integer> preorder2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        TreeNode temp = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            temp = stack.pop();
            list.add(temp.value);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return list;
    }

    /**
     * 先序遍历（非递归）
     *
     * @param root 根结点
     * @return 结果
     */
    public static List<Integer> preorder3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (temp != null || !stack.empty()) {
            while (temp != null) {
                list.add(temp.value);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            temp = temp.right;
        }

        return list;
    }

    /**
     * 中序遍历（非递归）
     *
     * @param root 根结点
     * @return 结果
     */
    public static List<Integer> inorder2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.value);
            temp = temp.right;
        }

        return list;
    }

    /**
     * 后序遍历（非递归）
     *
     * @param root 根结点
     * @return 结果
     */
    public static List<Integer> postorder2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        TreeNode temp = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            temp = stack.pop();
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
            list.add(0, temp.value); // 逆序添加节点值
        }

        return list;
    }

    /**
     * 后序遍历（非递归）
     *
     * @param root 根结点
     * @return 结果
     */
    public static List<Integer> postorder3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null; // 记录上一次访问的节点

        while (cur != null || !stack.empty()) {
            // 从根节点开始，将其所有左子节点入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == last) {
                // 如果当前节点没有右孩子，或者当前节点的右孩子刚刚被访问过，
                // 这时应该访问当前节点
                list.add(cur.value);
                stack.pop();
                last = cur;
                cur = null;
            } else {
                // 否则，将当前指针移到其右孩子节点上
                cur = cur.right;
            }
        }

        return list;
    }

    /**
     * 广度优先遍历二叉树，又称层次遍历二叉树
     *
     * @param root 根结点
     * @return 结果
     */
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        TreeNode temp = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            temp = queue.poll();
            list.add(temp.value);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return list;
    }

    /**
     * 广度优先遍历二叉树，又称层次遍历二叉树
     *
     * @param root 根结点
     * @return 结果
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        List<Integer> level = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            level = new ArrayList<>(); // 一层一个list
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(level);
        }

        return list;
    }

}
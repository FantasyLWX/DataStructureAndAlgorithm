package com.fantasy.datastructure.tree;

/**
 * 二叉查找树，又称二叉排序树、二叉搜索树
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-17
 *     since   : 1.0, 2020-08-17
 * </pre>
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }

        TreeNode temp = root;
        while (temp != null) {
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = new TreeNode(value);
                    break;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new TreeNode(value);
                    break;
                }
                temp = temp.right;
            }
        }
    }

    public void delete(int value) {
        TreeNode parent = null;
        TreeNode temp = root;

        while (temp != null && temp.value != value) {
            parent = temp;
            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (temp == null) {
            return; // 没有找到要删除的结点
        }

        // 要删除的结点有两个孩子结点
        if (temp.left != null && temp.right != null) {
            TreeNode minNode = temp.right;
            TreeNode minNodeParent = temp;
            // 找到右子树的最小结点，替换到要删除的结点上
            while (minNode.left != null) {
                minNodeParent = minNode;
                minNode = minNode.left;
            }
            temp.value = minNode.value;
            // 要删除的结点变成了右子树的最小结点
            // 由于该结点肯定不会有左孩子，因此可以使用接下来的代码进行删除
            temp = minNode;
            parent = minNodeParent;
        }

        // 删除叶子结点，或者只有一个孩子的结点
        TreeNode child;
        if (temp.left != null) {
            child = temp.left;
        } else if (temp.right != null) {
            child = temp.right;
        } else {
            child = null;
        }

        if (parent == null) {
            root = child; // 删除的是根结点
        } else if (parent.left == temp) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public TreeNode find(int value) {
        TreeNode temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return temp;
            }
        }
        return null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getMaxNode() {
        return getMaxNode(root);
    }

    public TreeNode getMaxNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public TreeNode getMinNode() {
        return getMinNode(root);
    }

    public TreeNode getMinNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    /**
     * 查找结点的前驱结点。中序遍历的前一个结点，小于该结点的所有结点中最大的那个结点。
     *
     * @param value 结点的值
     * @return 前驱结点
     */
    public TreeNode predecessor(int value) {
        if (root == null) {
            return null;
        }

        TreeNode parent = null; // 查找过程中当前结点的父亲结点
        TreeNode lastR = null; // 最后一次在查找路径中出现右拐的结点
        TreeNode temp = root;

        while (temp != null) {
            if (temp.value == value) {
                break; // 查找到结点
            }
            parent = temp;
            if (value < temp.value) {
                temp = temp.left;
            } else {
                lastR = temp;
                temp = temp.right;
            }
        }

        if (temp == null) {
            return null; // 没有找到结点
        }

        // 如果结点有左子树，那么该结点的前驱结点是其左子树中值最大的结点
        if (temp.left != null) {
            return getMaxNode(temp.left);
        }

        // 如果是最小的结点，则没有前驱结点
        if (parent == null || lastR == null) {
            return null;
        }

        // 如果结点没有左子树，那么判断该结点和其父结点的关系
        if (temp == parent.right) {
            // 如果结点是其父亲结点的右边结点，那么该结点的前驱结点即为其父亲结点
            return parent;
        } else {
            // 如果结点是其父亲结点的左边孩子，那么沿着其父亲结点一直向树的顶端寻找出现右拐的结点
            return lastR;
        }
    }

    /**
     * 查找结点的后继结点。中序遍历的后一个结点，大于该结点的所有结点中最小的那个结点。
     *
     * @param value 结点的值
     * @return 后继结点
     */
    public TreeNode successor(int value) {
        if (root == null) {
            return null;
        }

        TreeNode parent = null; // 查找过程中当前结点的父亲结点
        TreeNode lastL = null; // 最后一次在查找路径中出现左拐的结点
        TreeNode temp = root;

        while (temp != null) {
            if (temp.value == value) {
                break; // 查找到结点
            }
            parent = temp;
            if (value < temp.value) {
                lastL = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (temp == null) {
            return null; // 没有找到结点
        }

        // 如果结点有右子树，那么该结点的后继结点是其右子树中值最小的结点
        if (temp.right != null) {
            return getMinNode(temp.right);
        }

        // 如果是最大的结点，则没有后继结点
        if (parent == null || lastL == null) {
            return null;
        }

        // 如果结点没有右子树，那么判断该结点和其父结点的关系
        if (temp == parent.left) {
            // 如果结点是其父亲结点的左边结点，那么该结点的后继结点即为其父亲结点
            return parent;
        } else {
            // 如果结点是其父亲结点的右边孩子，那么沿着其父亲结点一直向树的顶端寻找出现左拐的结点
            return lastL;
        }
    }

}
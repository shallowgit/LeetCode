package com.aqiu._2_Stack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Flatten Binary Tree to Linked List
 *
 * @author Aqiu
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _3_P114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new _3_P114_FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null));
        treeNode.right = new TreeNode(5, null, new TreeNode(6, null, null));
        solution.flatten(treeNode);
    }

    /**
     * 题解链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
     * 方法一：前序遍历 递归实现
     */
    class Solution {
        ArrayList<TreeNode> list = new ArrayList<>();

        public void flatten(TreeNode root) {
            flat(root);
            int size = list.size(); //是否抽离 size 变量会影响效率，事先声明 size 变量运行显示会省空间
            for (int i = 1; i < size; i++) {
                TreeNode node = list.get(i - 1);
                node.left = null;
                node.right = list.get(i);
            }
        }

        private void flat(TreeNode root) {
            if (root != null) {
                list.add(root);
                flat(root.left);
                flat(root.right);
            }
        }
    }
    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了13.62% 的Java用户
     */

    /**
     * 前序遍历 迭代实现
     */
    class Solution2 {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            ArrayList<TreeNode> list = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            for (int i = 1; i < list.size(); i++) {
                TreeNode node = list.get(i - 1);
                node.left = null;
                node.right = list.get(i);
            }
        }
    }
    /**
     * 执行耗时:1 ms,击败了21.02% 的Java用户
     * 内存消耗:40.8 MB,击败了83.99% 的Java用户
     */

    /**
     * 前序遍历 迭代实现
     */
    class Solution3 {
        public void flatten(TreeNode root) {
            ArrayList<TreeNode> list = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    list.add(node);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode temp = list.get(i - 1);
                temp.left = null;
                temp.right = list.get(i);
            }
        }
    }
    /**
     * 执行耗时:1 ms,击败了21.02% 的Java用户
     * 内存消耗:41.3 MB,击败了13.62% 的Java用户
     */

    /**
     * 方法二：前序遍历和展开同步进行
     */
    class Solution4 {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            TreeNode prev = null;
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (prev != null) {
                    prev.left = null;
                    prev.right = cur;
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                prev = cur;
            }
        }
    }

    /**
     * 执行耗时:1 ms,击败了21.02% 的Java用户
     * 内存消耗:41.6 MB,击败了5.09% 的Java用户
     */

    /**
     * 方法三：寻找前驱节点
     * Morris 遍历
     */
    class Solution5 {
        public void flatten(TreeNode root) {
            TreeNode cur = root;    //其实 cur 变量可以不声明
            while (cur != null) {
                if (cur.left != null) {
                    TreeNode temp = cur.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    temp.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                }
                cur = cur.right;
            }
        }
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了38.90% 的Java用户
     */
}
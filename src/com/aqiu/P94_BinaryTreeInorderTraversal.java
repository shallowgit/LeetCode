package com.aqiu;

import java.util.*;

/**
 * Binary Tree Inorder Traversal
 *
 * @author zhaohanqing
 */
public class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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

    /**
     * 递归
     */
    class Solution {
        LinkedList<Integer> list = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            inorder(root);
            return list;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了74.86% 的Java用户
     */

    /**
     * 迭代
     */
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> res = new LinkedList<>();
            //这里为什么用 ArrayDeque 而不是 LinkedList ，请看 https://leetcode.cn/circle/article/bXc4tx/
            ArrayDeque<TreeNode> list = new ArrayDeque<>();
            while (root != null || !list.isEmpty()) {
                while (root != null) {
                    list.add(root);
                    root = root.left;
                }
                root = list.pollLast();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }
    }
    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了86.44% 的Java用户
     */

    /**
     * 题解链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
     */
    public class ColorNode {
        boolean flag;
        TreeNode node;

        ColorNode(TreeNode node, Boolean flag) {
            this.node = node;
            this.flag = flag;
        }
    }

    class Solution3 {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            ArrayDeque<ColorNode> deque = new ArrayDeque<>();
            deque.addLast(new ColorNode(root, false));
            while (deque.size() != 0) {
                ColorNode colorNode = deque.pollLast();
                if (colorNode.flag == false) {
                    if (colorNode.node.right != null) {
                        deque.addLast(new ColorNode(colorNode.node.right, false));
                    }
                    deque.addLast(new ColorNode(colorNode.node, true));
                    if (colorNode.node.left != null) {
                        deque.addLast(new ColorNode(colorNode.node.left, false));
                    }
                } else {
                    list.add(colorNode.node.val);
                }
            }
            return list;
        }
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了19.69% 的Java用户
     */

    class Solution4 {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            ArrayDeque<Object> deque = new ArrayDeque<>();
            deque.addLast(root);
            while (deque.size() != 0) {
                Object cur = deque.pollLast();
                if (cur instanceof TreeNode) {  //null instanceof 任意类型 都返回false
                    TreeNode node = (TreeNode) cur;
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    deque.addLast(node.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                }
                if (cur instanceof Integer) {
                    list.add((Integer) cur);
                }
            }
            return list;
        }
    }
    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了47.38% 的Java用户
     */

    /**
     * 方法三：Morris 中序遍历
     * 解法来自官方题解的评论区
     */
    class Solution5 {
        public List<Integer> inorderTraversal (TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            while (root != null) {
                if (root.left == null) {
                    list.add(root.val);
                    root = root.right;
                } else {
                    TreeNode pre = root.left;
                    while (pre.right != null && pre.right != root) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = root;
                        root = root.left;
                    } else {
                        pre.right = null;
                        list.add(root.val);
                        root = root.right;
                    }
                }
            }
            return list;
        }
    }
    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了95.96% 的Java用户
     */
}
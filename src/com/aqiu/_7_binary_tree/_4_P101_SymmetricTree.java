package com.aqiu._7_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _4_P101_SymmetricTree {
    public static void main(String[] args) {
        Solution2 solution = new _4_P101_SymmetricTree().new Solution2();
        solution.isSymmetric(null);
    }

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

    //递归
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            if (root.left == null || root.right == null || root.left.val != root.right.val) {
                return false;
            }
            return symmetric(root.left, root.right);
        }

        public boolean symmetric(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
        }
    }

    //迭代
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(root);
            TreeNode node1, node2;
            while (!queue.isEmpty()) {
                node1 = queue.poll();
                node2 = queue.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null || node1.val != node2.val) {
                    return false;
                }
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
            return true;
        }
    }
}
package com.aqiu._7_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _2_P100_SameTree {
    public static void main(String[] args) {
        Solution solution = new _2_P100_SameTree().new Solution();
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

    //深度优先搜索
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    //广度优先搜索
    class Solution2 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null || node1.val != node2.val) {
                    return false;
                }
                queue.offer(node1.left);
                queue.offer(node2.left);
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            return true;
        }
    }
}
package com.aqiu._7_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _1_P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new _1_P104_MaximumDepthOfBinaryTree().new Solution();
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
    //知道了左子树和右子树的最大深度 l 和 r，那么该二叉树的最大深度即为 max(l,r)+1
    //而左子树和右子树的最大深度又可以以同样的方式进行计算。因此可以用「深度优先搜索」的方法来计算二叉树的最大深度。
    //具体而言，在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，然后在 O(1) 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            }
        }
    }

    //广度优先搜索
    //广度优先搜索的队列里存放的是「当前层的所有节点」。
    //每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，需要将队列里的所有节点都拿出来进行拓展，
    //这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即一层一层地进行拓展，最后用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 ans
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans;
        }
    }
}
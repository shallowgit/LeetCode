package com.aqiu;

import java.util.Arrays;

public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
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

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root = new TreeNode(preorder[0]);
            if (preorder.length == 1)
                return root;
            int rootValue = preorder[0];
            int index = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootValue)
                    index = i;
            }
            if (index == 0)
                root.left = null;
            else
                root.left = builLeftTree(preorder, inorder, 0, index - 1);

            if (index == preorder.length - 1)
                root.right = null;
            else
                root.right = buildRightTree(preorder, inorder, index + 1, preorder.length);

            return root;
        }

        public TreeNode builLeftTree(int[] preorder, int[] inorder, int leftBorder, int rightBorder) {
            new TreeNode(preorder[])
        }

        public TreeNode buildRightTree(int[] preorder, int[] inorder, int leftBorder, int rightBorder) {

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
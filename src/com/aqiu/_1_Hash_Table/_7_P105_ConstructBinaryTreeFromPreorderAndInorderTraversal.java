package com.aqiu._1_Hash_Table;

import java.util.HashMap;

/**
 * @author Aqiu
 */
public class _7_P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _7_P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
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

    /**
     * 题解链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
     */
    class Solution {
        int[] preorder; //保留先序遍历
        HashMap<Integer, Integer> hashMap = new HashMap<>();    //标记中序遍历

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
            for (int i = 0; i < inorder.length; i++) {
                hashMap.put(inorder[i], i);
            }
            return buildMyTree(0, 0, inorder.length - 1);
        }

        public TreeNode buildMyTree(int root, int left, int right) {
            if (left > right)   // 递归终止
            {
                return null;
            }
            int index = hashMap.get(preorder[root]);    // 划分根节点、左子树、右子树
            TreeNode treeNode = new TreeNode(preorder[root]);   // 建立根节点
            treeNode.left = buildMyTree(root + 1, left, index - 1); // 开启左子树递归
            treeNode.right = buildMyTree(index - left + root + 1, index + 1, right);    // 开启右子树递归
            return treeNode;    // 回溯返回根节点
        }
    }

    class Solution2 {
        int root;   //当前根节点在先序遍历数组里的位置
        int[] preorder; //保留先序遍历
        HashMap<Integer, Integer> hashMap = new HashMap<>();    //标记中序遍历

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
            for (int i = 0; i < inorder.length; i++) {
                hashMap.put(inorder[i], i);
            }
            this.preorder = preorder;
            root = 0;
            return buildMyTree(0, inorder.length - 1);
        }

        public TreeNode buildMyTree(int left, int right) {
            if (left > right)   // 递归终止
            {
                return null;
            }
            int index = hashMap.get(preorder[root]);    // 划分根节点、左子树、右子树
            TreeNode treeNode = new TreeNode(preorder[root]);   // 建立根节点
            root++; //由于root是全局变量，并且先遍历左子树，所以轮到右子树时，root的值是正确的；并且一定要先遍历左子树；并且一定要先遍历右子树，这样root的下标才能对上
            treeNode.left = buildMyTree(left, index - 1); // 开启左子树递归
            treeNode.right = buildMyTree(index + 1, right);    // 开启右子树递归
            return treeNode;    // 回溯返回根节点
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
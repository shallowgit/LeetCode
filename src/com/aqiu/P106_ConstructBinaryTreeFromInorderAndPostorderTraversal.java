package com.aqiu;

import java.util.HashMap;

/**
 * @author Aqiu
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

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
        int root;   //当前根节点在先序遍历数组里的位置
        int[] postorder;    //保留先序遍历
        HashMap<Integer, Integer> hashMap = new HashMap<>();    //标记中序遍历

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            //将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
            for (int i = 0; i < inorder.length; i++) {
                hashMap.put(inorder[i], i);
            }
            this.postorder = postorder;
            root = postorder.length - 1;
            return buildMyTree(0, postorder.length - 1);
        }

        public TreeNode buildMyTree(int left, int right) {
            if (left > right)   // 递归终止
            {
                return null;
            }
            int index = hashMap.get(postorder[root]);   // 划分根节点、左子树、右子树
            TreeNode treeNode = new TreeNode(postorder[root]);  // 建立根节点
            root--; //由于root是全局变量，并且先遍历右子树，所以轮到左子树时，root的值是正确的；并且一定要先遍历右子树，这样root的下标才能对上
            treeNode.right = buildMyTree(index + 1, right); // 开启右子树递归
            treeNode.left = buildMyTree(left, index - 1);   // 开启左子树递归
            return treeNode;    // 回溯返回根节点
        }
    }

    class Solution2 {
        int[] postorder;
        int root;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            root = postorder.length - 1;
            for (int i = 0; i < inorder.length; i++) {
                hashMap.put(inorder[i], i);
            }
            return buildMyTree(0, inorder.length - 1);
        }

        public TreeNode buildMyTree(int left, int right) {
            if (left > right) {
                return null;
            }
            int index = hashMap.get(postorder[root]);
            TreeNode treeNode = new TreeNode(postorder[root]);
            root--;
            treeNode.right = buildMyTree(index + 1, right);
            treeNode.left = buildMyTree(left, index - 1);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
package com.aqiu._2_Stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Preorder Traversal
 *
 * @author Aqiu
 */
public class _5_P144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new _5_P144_BinaryTreePreorderTraversal().new Solution();
    }

    //Definition for a binary tree node.
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
        List<Integer> list = new LinkedList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            preOrder(root);
            return list;
        }

        private void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.push(root);
            while (deque.size() > 0) {
                root = deque.pop();
                list.add(root.val);
                if (root.right != null) {
                    deque.push(root.right);
                }
                if (root.left != null) {
                    deque.push(root.left);
                }
            }
            return list;
        }
    }

    class FlagNode {
        TreeNode node;
        boolean flag;

        public FlagNode(TreeNode root, boolean flag) {
            this.node = root;
            this.flag = flag;
        }
    }

    class Solution3 {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            ArrayDeque<FlagNode> deque = new ArrayDeque<>();
            deque.push(new FlagNode(root, false));
            while (deque.size() > 0) {
                FlagNode node = deque.pop();
                if (node.flag == false) {
                    if (node.node.right != null) {
                        deque.push(new FlagNode(node.node.right, false));
                    }
                    if (node.node.left != null) {
                        deque.push(new FlagNode(node.node.left, false));
                    }
                    deque.push(new FlagNode(node.node, true));
                } else {
                    list.add(node.node.val);
                }
            }
            return list;
        }
    }

    class Solution4 {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            if (root == null) {
                return list;
            }
            ArrayDeque<Object> deque = new ArrayDeque<>();
            deque.push(root);
            while (deque.size() > 0) {
                Object obj = deque.pop();
                if (obj instanceof TreeNode) {
                    TreeNode node = (TreeNode) obj;
                    if (node.right != null) {
                        deque.push(node.right);
                    }
                    if (node.left != null) {
                        deque.push(node.left);
                    }
                    deque.push(node.val);
                } else {
                    list.add((int) obj);
                }
            }
            return list;
        }
    }

    /**
     * ??????????????????
     */
    class Solution5 {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            while (root != null || !deque.isEmpty()) {
                while (root != null) {
                    list.add(root.val);
                    deque.push(root);
                    root = root.left;
                }
                root = deque.pop().right;
            }
            return list;
        }
    }

    /**
     * ????????????Morris??????
     * ???????????????https://leetcode.cn/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
     */
    class Solution6 {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            while (root != null) {
                if (root.left != null) {
                    TreeNode temp = root.left;
                    while (temp.right != null && temp.right != root) {
                        temp = temp.right;
                    }
                    if (temp.right == null) {
                        list.add(root.val);
                        temp.right = root;
                        root = root.left;
                        continue;
                    } else {
                        temp.right = null;
                    }
                } else {
                    list.add(root.val);
                }
                root = root.right;
            }
            return list;
        }
    }

    /**
     * Morris??????
     */
    class Solution7 {
        //????????????Morris??????????????????????????????????????????????????????
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            while (root != null) {
                //???????????????????????????
                list.add(root.val);
                //???????????????????????????????????????????????????????????????
                //??????????????????????????????????????????????????????????????????????????????????????????
                //????????????????????????????????????1??????????????????2?????????????????????????????????????????????????????????
                if (root.left != null) {
                    TreeNode precessor = root.left;
                    //1??????????????????????????????
                    while (precessor.right != null || precessor.left != null) {
                        //2?????????????????????????????????????????????????????????
                        if (precessor.right != null) {
                            precessor = precessor.right;
                        } else {
                            precessor = precessor.left;
                        }
                    }
                    //?????????????????????????????????????????????
                    precessor.right = root.right;
                    //??????????????????
                    root = root.left;
                } else {
                    //?????????????????????????????????????????????????????????
                    root = root.right;
                }
            }
            return list;
        }
    }
}
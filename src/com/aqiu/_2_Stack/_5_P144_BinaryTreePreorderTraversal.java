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
     * 方法二：迭代
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
     * 方法三：Morris遍历
     * 题解链接：https://leetcode.cn/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
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
     * Morris遍历
     */
    class Solution7 {
        //个人理解Morris的思想就是借助树的空闲指针将树链表化
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<Integer> list = new LinkedList<>();
            while (root != null) {
                //前序遍历添加根节点
                list.add(root.val);
                //左子树不为空，按照前序遍历规则先遍历左子树
                //遍历前先将左子树在前序遍历的最后一个节点指向根节点的右子树。
                //前序遍历的最后一个节点：1、是叶节点，2、优先右子树，如果没有右子树再找左子树
                if (root.left != null) {
                    TreeNode precessor = root.left;
                    //1、是叶节点才终止循环
                    while (precessor.right != null || precessor.left != null) {
                        //2、优先右子树，如果没有右子树再找左子树
                        if (precessor.right != null) {
                            precessor = precessor.right;
                        } else {
                            precessor = precessor.left;
                        }
                    }
                    //最后一个节点指向根节点的右子树
                    precessor.right = root.right;
                    //先遍历左子树
                    root = root.left;
                } else {
                    //左子树为空，按照前序遍历规则遍历右子树
                    root = root.right;
                }
            }
            return list;
        }
    }
}
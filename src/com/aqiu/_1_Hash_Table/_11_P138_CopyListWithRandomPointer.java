package com.aqiu._1_Hash_Table;

import java.util.HashMap;

/**
 * Copy List with Random Pointer
 *
 * @author Aqiu
 */
public class _11_P138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new _11_P138_CopyListWithRandomPointer().new Solution();
    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        /**
         * 解法一：原地处理，将克隆结点放在原结点后面，在原链表上处理克隆结点的random指针，最后分离两个链表
         * 空间复杂度O(1)
         */
        public Node copyRandomList1(Node head) {
            if (head == null) {
                return head;
            }
            // 空间复杂度O(1)，将克隆结点放在原结点后面
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val, cur.next, null);
                cur.next = node;
                cur = cur.next.next;
            }
            // 第二步：处理复制节点的random指针
            cur = head;
            while (cur != null) {
                if (cur.random == null) {
                    cur.next.random = null;
                } else {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            // 还原原始链表，即分离原链表和克隆链表
            Node newHead = head.next; // 复制链表的头节点
            Node pre = head; // 专门遍历原节点
            while (pre != null) {
                Node copyNode = pre.next; // 当前原节点对应的复制节点
                Node nextOrigin = copyNode.next; // 下一个原节点（暂存）

                // 1. 恢复原链表：当前原节点指向后一个原节点
                pre.next = nextOrigin;
                // 2. 构建复制链表：当前复制节点指向后一个复制节点（若存在）
                copyNode.next = (nextOrigin != null) ? nextOrigin.next : null;

                // 3. 推进遍历：原节点向后移动
                pre = nextOrigin;
            }
            return newHead;
        }

        /**
         * 解法二： 使用hash存储原结点和克隆结点的映射关系，通过映射关系处理克隆结点的random指针
         * 时间复杂度O(n)；空间复杂度O(n)
         */
        public Node copyRandomList2(Node head) {
            if (head == null) {
                return head;
            }
            // map方法，空间复杂度O(n)
            // 使用hash表存储旧结点和新结点的映射
            HashMap<Node, Node> hashMap = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val, null, null);
                hashMap.put(cur, node);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                Node temp = hashMap.get(cur);
                //HashMap的get方法对于null值有处理，返回null，所以不用判断
/*                if (cur.random != null) {
                    temp.random = hashMap.get(cur.random);
                } else {
                    temp.random = null;
                }
                if (cur.next != null) {
                    temp.next = hashMap.get(cur.next);
                }*/
                temp.random = hashMap.get(cur.random);
                temp.next = hashMap.get(cur.next);
                cur = cur.next;
            }
            return hashMap.get(head);
        }
    }
}
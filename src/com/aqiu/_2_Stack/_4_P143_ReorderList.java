package com.aqiu._2_Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Reorder List
 *
 * @author Aqiu
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class _4_P143_ReorderList {
    public static void main(String[] args) {
        Solution solution = new _4_P143_ReorderList().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution.reorderList(node1);
    }

    class Solution {
        /**
         * 自己写的
         */
        public void reorderList(ListNode head) {
            ListNode cur = head;
            ArrayDeque<ListNode> deque = new ArrayDeque<ListNode>();
            while (cur != null) {
                deque.push(cur);
                cur = cur.next;
            }
            cur = head;
            while (cur != deque.getFirst()) {
                ListNode temp = deque.pop();
                if (cur.next == temp) {
                    cur.next.next = null;
                    return;
                }
                temp.next = cur.next;
                cur.next = temp;
                cur = cur.next.next;
            }
            cur.next = null;
        }
        /**
         * 执行耗时:3 ms,击败了33.99% 的Java用户
         * 内存消耗:44 MB,击败了69.29% 的Java用户
         */

        /**
         * 题解链接：https://leetcode.cn/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
         * 方法一：线性表
         */
        public void reorderList2(ListNode head) {
            ArrayList<ListNode> list = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                if (i == j) {
                    break;
                }
                ListNode left = list.get(i);
                ListNode right = list.get(j);
                left.next = right;
                i++;
                right.next = list.get(i);
                j--;
            }
            list.get(i).next = null;
        }

        /**
         * 执行耗时:2 ms,击败了43.75% 的Java用户
         * 内存消耗:43.5 MB,击败了96.83% 的Java用户
         */
    }

    /**
     * 题解链接：https://leetcode.cn/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
     * 方法二：寻找链表中点 + 链表逆序 + 合并链表
     */
    class Solution2 {
        public void reorderList3(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode l1 = head;
            ListNode l2 = reverseList(mid.next);
            mid.next = null;
            mergeList(l1, l2);
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {   //这里第一个条件不能改成 slow.next != null
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            return prev;
        }

        private void mergeList(ListNode l1, ListNode l2) {
            ListNode next1;
            ListNode next2;
            while (l1 != null && l2 != null) {
                next1 = l1.next;
                next2 = l2.next;
                l1.next = l2;
                l2.next = next1;
                l1 = next1;
                l2 = next2;
            }
        }
        /**
         * 执行耗时:1 ms,击败了99.85% 的Java用户
         * 内存消耗:44 MB,击败了60.26% 的Java用户
         */
    }

    class Solution3 {
        public void reorderList3(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode l1 = head;
            ListNode l2 = reverseList(mid.next);
            mid.next = null;
            mergeList(l1, l2);
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            return prev;
        }

        private void mergeList(ListNode l1, ListNode l2) {
            ListNode l1_temp;
            ListNode l2_temp;
            while (l1 != null && l2 != null) {
                l1_temp = l1.next;
                l2_temp = l2.next;
                l1.next = l2;
                l2.next = l1_temp;
                l1 = l1_temp;
                l2 = l2_temp;
            }
        }
    }
}
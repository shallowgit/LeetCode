package com.aqiu._6_linkedlist;

public class _3_P92_ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution2 solution = new _3_P92_ReverseLinkedListIi().new Solution2();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        solution.reverseBetween(node1, 2, 4);
    }

    public static class ListNode {
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

    //https://leetcode.cn/problems/reverse-linked-list-ii/solutions/634701/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/?envType=study-plan-v2&envId=top-interview-150
    //穿针引线
    //第 1 步：先将待反转的区域反转；
    //第 2 步：把 pre 的 next 指针指向反转以后的链表头节点，把反转以后的链表的尾节点的 next 指针指向 next
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
            ListNode preHead = new ListNode(-1);
            preHead.next = head;

            ListNode pre = preHead;
            // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
            // 建议写在 for 循环里，语义清晰
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
            ListNode rightNode = pre;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }

            // 第 3 步：切断出一个子链表（截取链表）
            ListNode leftNode = pre.next;
            ListNode next = rightNode.next;

            // 注意：切断链接
            pre.next = null;
            rightNode.next = null;

            // 第 4 步：反转链表的子区间
            reverseLinkedList(leftNode);

            // 第 5 步：接回到原来的链表中
            pre.next = rightNode;
            leftNode.next = next;
            return preHead.next;
        }

        public void reverseLinkedList(ListNode cur) {
            ListNode pre = null;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
    }

    class Solution2 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode preHead = new ListNode(-1);
            preHead.next = head;
            ListNode pre = preHead;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            ListNode next;
            for (int i = 0; i < right - left; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return preHead.next;
        }
    }
}
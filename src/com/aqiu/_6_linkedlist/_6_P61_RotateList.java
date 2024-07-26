package com.aqiu._6_linkedlist;

public class _6_P61_RotateList {
    public static void main(String[] args) {
        Solution1 solution = new _6_P61_RotateList().new Solution1();
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        solution.rotateRight(listNode1, 2);
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

    //三步走
    //1.全反转
    //2.前k反转
    //3.后n-k反转
    class Solution1 {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head;
            int len = 0;
            while (cur != null) {
                len++;
                cur = cur.next;
            }
            //链表长度不大于 1，或者 k 为 n 的倍数时，新链表将与原链表相同，无需进行任何处理
            k = k % len;
            if (k == 0) {
                return head;
            }
            //全反转
            head = reverse(head);
            cur = head;
            for (int i = 0; i < k - 1; i++) {
                cur = cur.next;
            }
            //后n-k反转
            ListNode second = reverse(cur.next);
            cur.next = null;
            cur = head;
            //前k反转
            head = reverse(cur);
            cur.next = second;
            return head;
        }

        public ListNode reverse(ListNode head) {
            ListNode pre = head;
            ListNode cur = head;
            ListNode next = cur.next;
            while (next != null) {
                cur.next = next.next;
                next.next = pre;
                pre = next;
                next = cur.next;
            }
            return pre;
        }
    }

    //闭合为环
    //记给定链表的长度为 n，注意到当向右移动的次数 k≥n 时，仅需要向右移动 k mod n 次即可。
    //因为每 n 次移动都会让链表变为原状。这样可以知道，新链表的最后一个节点为原链表的第 (n−1)−(k mod n) 个节点（从 0 开始计数）。
    //可以先将给定的链表连接成环，然后将指定位置断开。
    //具体代码中，首先计算出链表的长度 n，并找到该链表的末尾节点，将其与头节点相连。这样就得到了闭合为环的链表。
    //然后找到新链表的最后一个节点（即原链表的第 (n−1)−(k mod n) 个节点），将当前闭合为环的链表断开，即可得到我们所需要的结果。
    //特别地，当链表长度不大于 1，或者 k 为 n 的倍数时，新链表将与原链表相同，无需进行任何处理
    class Solution2 {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            int len = 1;
            ListNode cur = head;
            while (cur.next != null) {
                len++;
                cur = cur.next;
            }
            k = k % len;
            if (k == 0) {
                return head;
            }
            cur.next = head;
            for (int i = 0; i < len - k; i++) {
                cur = cur.next;
            }
            ListNode result = cur.next;
            cur.next = null;
            return result;
        }
    }
}
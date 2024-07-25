package com.aqiu._6_linkedlist;

public class _6_P61_RotateList {
    public static void main(String[] args) {
        Solution solution = new _6_P61_RotateList().new Solution();
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
    class Solution {
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
}
package com.aqiu._6_linkedlist;

public class _5_P82_RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new _5_P82_RemoveDuplicatesFromSortedListIi().new Solution();
    }

    public class ListNode {
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

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode preHead = new ListNode(101, head);
            ListNode pre = preHead;
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    while (cur.next != null && cur.val == cur.next.val) {
                        cur = cur.next;
                    }
                    pre.next = cur.next;
                }else{
                    pre = pre.next;
                }
                cur = cur.next;
            }
            return preHead.next;
        }
    }
}
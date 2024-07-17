package com.aqiu._6_linkedlist;

public class _2_P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new _2_P21_MergeTwoSortedLists().new Solution();
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

    //迭代
    //当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
    //当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode start = new ListNode();
            ListNode result = start;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    start.next = list1;
                    list1 = list1.next;
                } else {
                    start.next = list2;
                    list2 = list2.next;
                }
                start = start.next;
            }
            // 合并后 list1 和 list2 最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表即可
            start.next = list1 == null ? list2 : list1;
            return result.next;
        }
    }
}
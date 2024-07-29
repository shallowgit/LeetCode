package com.aqiu._6_linkedlist;

public class _7_P86_PartitionList {
    public static void main(String[] args) {
        Solution solution = new _7_P86_PartitionList().new Solution();
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

    //直观来说只需维护两个链表 small 和 large 即可，small 链表按顺序存储所有小于 x 的节点，large 链表按顺序存储所有大于等于 x 的节点。
    //遍历完原链表后，只要将 small 链表尾节点指向 large 链表的头节点即能完成对链表的分隔。
    //为了实现上述思路，设 smallHead 和 largeHead 分别为两个链表的哑节点，即它们的 next 指针指向链表的头节点，这样做的目的是为了更方便地处理头节点为空的边界条件。
    //同时设 small 和 large 节点指向当前链表的末尾节点。开始时 smallHead=small,largeHead=large。
    //随后，从前往后遍历链表，判断当前链表的节点值是否小于 x，如果小于就将 small 的 next 指针指向该节点，否则将 large 的 next 指针指向该节点。
    //遍历结束后，将 large 的 next 指针置空，这是因为当前节点复用的是原链表的节点，而其 next 指针可能指向一个小于 x 的节点，需要切断这个引用。
    //同时将 small 的 next 指针指向 largeHead 的 next 指针指向的节点，即真正意义上的 large 链表的头节点。最后返回 smallHead 的 next 指针即为要求的答案
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode small = new ListNode(0);
            ListNode smallHead = small;
            ListNode large = new ListNode(0);
            ListNode largeHead = large;
            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                } else {
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }
            small.next = largeHead.next;
            large.next = null;
            return smallHead.next;
        }
    }
}
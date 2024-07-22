package com.aqiu._6_linkedlist;

public class _4_P19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new _4_P19_RemoveNthNodeFromEndOfList().new Solution();
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

    //方法一：计算链表长度，两遍遍历
    //时间复杂度：O(L)，其中 L 是链表的长度。
    //空间复杂度：O(1)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int len = 0;
            ListNode cur = head;
            while (cur != null) {
                len++;
                cur = cur.next;
            }
            ListNode preHead = new ListNode(-1, head);
            cur = preHead;
            for (int i = 0; i < len - n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return preHead.next;
        }

        //方法二：栈
        //在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 n 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。
        //时间复杂度：O(L)，其中 L 是链表的长度。
        //空间复杂度：O(L)，其中 L 是链表的长度。主要为栈的开销。
        //此处就不展开栈的写法了

        //方法三：双指针
        //使用两个指针 first 和 second 同时对链表进行遍历，并且 first 比 second 超前 n 个节点。当 first 遍历到链表的末尾时，second 就恰好处于倒数第 n 个节点。
        //具体地，初始时 first 和 second 均指向头节点。我们首先使用 first 对链表进行遍历，遍历的次数为 n。
        //此时，first 和 second 之间间隔了 n−1 个节点，即 first 比 second 超前了 n 个节点。
        //在这之后，我们同时使用 first 和 second 对链表进行遍历。当 first 遍历到链表的末尾（即 first 为空指针）时，second 恰好指向倒数第 n 个节点。
        //根据方法一和方法二，如果我们能够得到的是倒数第 n 个节点的前驱节点而不是倒数第 n 个节点的话，删除操作会更加方便。因此我们可以考虑在初始时将 second 指向哑节点，其余的操作步骤不变。这样一来，当 first 遍历到链表的末尾时，second 的下一个节点就是我们需要删除的节点。
        public ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode preHead = new ListNode(-1, head);
            ListNode fast = preHead, slow = preHead;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return preHead.next;
        }
    }
}
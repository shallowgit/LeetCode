package com.aqiu._2_Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
 * 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
 * 当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
 * 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中
 *
 * 题解链接：https://leetcode.cn/problems/min-stack/solutions/242190/zui-xiao-zhan-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150
 */
public class _7_P155_MinStack{
    public static void main(String[] args) {
        Solution solution = new _7_P155_MinStack().new Solution();
    }

    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class Solution {}
}
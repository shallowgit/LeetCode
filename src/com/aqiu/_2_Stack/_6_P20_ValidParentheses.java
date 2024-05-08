package com.aqiu._2_Stack;

import java.util.*;

public class _6_P20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new _6_P20_ValidParentheses().new Solution();
    }

    class Solution {
        public boolean isValid(String s) {
            int length = s.length();
            if (length % 2 == 1) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || stack.pop() != map.get(c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
}
package com.aqiu;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Simplify Path
 *
 * @author Aqiu
 */
public class P71_SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new P71_SimplifyPath().new Solution();
        solution.simplifyPath("/home/");
    }

    /**
     * 题解链接：https://leetcode.cn/problems/simplify-path/solution/jian-hua-lu-jing-by-leetcode-solution-aucq/
     */
    class Solution {
        public String simplifyPath(String path) {
            String[] s = path.split("/");
            Deque<String> deque = new LinkedList<>();
            for (String temp : s) {
                if (temp.equals("") || temp.equals(".")) {
                    continue;
                }
                if (temp.equals("..")) {
                    deque.pollLast();
                } else {
                    deque.addLast(temp);
                }
            }
            if (deque.isEmpty()) {
                return "/";
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append("/");
                sb.append(deque.pollFirst());
            }
            return sb.toString();
        }
    }
}